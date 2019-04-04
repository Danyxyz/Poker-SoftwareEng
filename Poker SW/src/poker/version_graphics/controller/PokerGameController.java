package poker.version_graphics.controller;

import java.util.ArrayList;

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
	
	//initialize wincounters to set win labels after
	public int winCountp1 = 0;
	public int winCountp2 = 0;
	public int winCountp3 = 0; 
	public int winCountp4 = 0;
	
	public PokerGameController(PokerGameModel model, PokerGameView view) {
		this.model = model;
		this.view = view;
		
		view.getShuffleButton().setOnAction( e -> shuffle() ); //shuffle cards
		view.getDealButton().setOnAction( e -> deal()); //deal cards	
		view.getExitButton().setOnAction(e -> System.exit(0)); //close game
		view.getFSButton().setOnAction(e -> view.getStage().setFullScreen(true)); //sets screen to fullscreen
		view.getAddPlayerBtn().setOnAction(e -> increasePlayer()); //add player
		view.getDecreaseButton().setOnAction(e -> decreasePlayer()); //remove player
		view.getRuleButton().setOnAction(e -> RuleWindow.display("Rules")); //show rules
		view.getChangeMusicButton().setOnAction(e -> view.updateMusic("res//Take_Ten.wav")); //change song
		view.getStopMusicButton().setOnAction(e -> view.stopMusic()); //stop music
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
    		pp.gamesWon.setText("-");
    	}
    	// reset the win labels
    	winCountp1 = 0;
    	winCountp2 = 0;
    	winCountp3 = 0;
    	winCountp4 = 0;
    	model.getDeck().shuffle();
    	
    
	
    }
    
    /**
     * Deal each player five cards, then evaluate the two hands
     */
    private void deal() {
    	int cardsRequired = PokerGame.NUM_PLAYERS * Player.HAND_SIZE;
    	DeckOfCards deck = model.getDeck();
    	if (cardsRequired <= deck.getCardsRemaining()) {
        	ArrayList <Player> currentWinners = null;
    		for (int i = 0; i < PokerGame.NUM_PLAYERS; i++) {
        		Player p = model.getPlayer(i);
        		p.discardHand();
        		for (int j = 0; j < Player.HAND_SIZE; j++) {
        			Card card = deck.dealCard();
        			p.addCard(card);
        		}
        		p.evaluateHand();
        		currentWinners = p.checkWinner(currentWinners, p);
        		PlayerPane pp = view.getPlayerPane(i);
        		pp.updatePlayerDisplay();
        	}
    		// set winner-labels
    		for (int i = 0; i < currentWinners.size(); i++) {
    			int number = (int)currentWinners.get(i).getPlayerName().charAt(currentWinners.get(i).getPlayerName().length()-1) - '0';

    			PlayerPane pp = new PlayerPane();
    		
    			switch (number) {
    			case 1:
    			winCountp1++;
    			pp = view.getPlayerPane(number-1);
    			pp.gamesWon.setText(Integer.toString(winCountp1));
    			break;
    		
    			case 2:
    			winCountp2++;
    			pp = view.getPlayerPane(number-1);
    			pp.gamesWon.setText(Integer.toString(winCountp2));
    			break;
    			
    			case 3:
				winCountp3++;
				pp = view.getPlayerPane(number-1);
				pp.gamesWon.setText(Integer.toString(winCountp3));
    			break;
    			
    			case 4:
    			winCountp4++;
    			pp = view.getPlayerPane(number-1);
    			pp.gamesWon.setText(Integer.toString(winCountp4));
    			break;
    			
    			}
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
    	if (PokerGame.NUM_PLAYERS <=3) { //set max to 4 players 
    	PokerGame.NUM_PLAYERS++;
     	this.updateDisplay();
    } else {
    	   Alert alert = new Alert(AlertType.ERROR, "Max 4 Players....");
           alert.showAndWait();
    }
    }
    public void decreasePlayer() {
    	if (PokerGame.NUM_PLAYERS <=1) { //minimum of 1 player required
    		   Alert alert = new Alert(AlertType.ERROR, "1 Player required");
               alert.showAndWait();
    	} else {
    	PokerGame.NUM_PLAYERS--;
     	this.updateDisplay();	
    }
    }
   
}
