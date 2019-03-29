package poker.version_graphics.model;

import java.util.ArrayList;

import poker.version_graphics.PokerGame;

public class PokerGameModel {
	public final static ArrayList<Player> players = new ArrayList<>();
	private DeckOfCards deck;
	
	public PokerGameModel() {
		for (int i = 1; i < PokerGame.NUM_PLAYERS+1; i++) {
			players.add(new Player("Player " + i));
		}
		
		deck = new DeckOfCards();
	}
	
	public Player getPlayer(int i) {
		return players.get(i);
	}
	
	public DeckOfCards getDeck() {
		return deck;
	}
}
