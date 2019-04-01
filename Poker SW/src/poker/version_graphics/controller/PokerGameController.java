package poker.version_graphics.controller;

import javax.sound.sampled.Clip;

import javafx.scene.control.Alert;

import javafx.scene.control.Alert.AlertType;
import poker.version_graphics.PokerGame;
import poker.version_graphics.model.Card;
import poker.version_graphics.model.DeckOfCards;
import poker.version_graphics.model.Player;
import poker.version_graphics.model.PokerGameModel;
import poker.version_graphics.view.CardLabel;
import poker.version_graphics.view.PlayerPane;
import poker.version_graphics.view.PokerGameView;
import poker.version_graphics.view.RuleWindow;

public class PokerGameController {
	private PokerGameModel model;
	private PokerGameView view;
	private CardLabel lbl;
	private PlayerPane pp;
	
	public PokerGameController(PokerGameModel model, PokerGameView view) {
		this.model = model;
		this.view = view;
		
		view.getShuffleButton().setOnAction( e -> shuffle() );		
		view.getDealButton().setOnAction( e -> deal()); 				
		view.getExitButton().setOnAction(e -> System.exit(0)); 				
		view.getFSButton().setOnAction(e -> view.getStage().setFullScreen(true));
		view.getAddPlayerBtn().setOnAction(e -> increasePlayer());
		view.getDecreaseButton().setOnAction(e -> decreasePlayer());
		view.getRuleButton().setOnAction(e -> RuleWindow.display("Rules"));
		view.getChangeMusicButton().setOnAction(e -> view.updateMusic("res//Take_Ten.wav"));
		view.getStopMusicButton().setOnAction(e -> view.stopMusic());
	}
	


    /**
     * Remove all cards from players hands, and shuffle the deck
     */
    private void shuffle() {
    	for (int i = 0; i < PokerGame.NUM_PLAYERS; i++) {
    		Player p = model.getPlayer(i);
    		p.discardHand();
    		PlayerPane pp = view.getPlayerPane(i);
    		pp.updatePlayerDisplay();
    	}

    	model.getDeck().shuffle();
    }
    
    /**
     * Deal each player five cards, then evaluate the two hands
     */
    private void deal() {
    	int cardsRequired = PokerGame.NUM_PLAYERS * Player.HAND_SIZE;
    	DeckOfCards deck = model.getDeck();
    	if (cardsRequired <= deck.getCardsRemaining()) {
        	for (int i = 0; i < PokerGame.NUM_PLAYERS; i++) {
        		Player p = model.getPlayer(i);
        		p.discardHand();
        		for (int j = 0; j < Player.HAND_SIZE; j++) {
        			Card card = deck.dealCard();
        			p.addCard(card);
        		}
        		p.evaluateHand();
        		PlayerPane pp = view.getPlayerPane(i);
        		pp.updatePlayerDisplay();
        	}
    	} else {
            Alert alert = new Alert(AlertType.ERROR, "Not enough cards - shuffle first");
            alert.showAndWait();
    	}
    }
    
    public void updateDisplay() {
    	PokerGameModel.players.clear();
    	view.clearDisplay();
    	
    	for (int i = 1; i < PokerGame.NUM_PLAYERS+1; i++) {
			PokerGameModel.players.add(new Player("Player " + i));
		}
    	
    	view.updatePane();
    
    }
    public void increasePlayer() {
    	PokerGame.NUM_PLAYERS++;
     	this.updateDisplay();
    }
    public void decreasePlayer() {
    	PokerGame.NUM_PLAYERS--;
     	this.updateDisplay();
     	
    }
    
}
