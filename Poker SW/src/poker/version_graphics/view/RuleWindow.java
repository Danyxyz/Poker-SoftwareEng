package poker.version_graphics.view;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class RuleWindow {

	
	public static void display(String title) {
		
		//Opens a new window and shows the rules of a poker-game
		Stage window = new Stage();
		
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle(title);
		window.setMinWidth(300);
		window.setHeight(900);
		
	
		
		
		Label label = new Label(); // tabulatoren und fette wörter müssen geändert werden
		
		label.setText("\t"+"\t"+"\t"+"NOTE: THIS IS A SIMPLER VERSION OF THE GAME, NOT EVERY RULE IS IMPLEMENTED"+
				"\n"+"\n"+"The Rules of Poker\r\n" + 
				"\t"+"Poker is a game of chance. However, when you introduce the concept of betting, poker gains quite a bit of skill and psychology. (This isn't to say that there isn't skill at poker when nothing is at risk, there just isn't nearly as much). This is meant as a very basic primer into the rules of poker, for more information, get a book on the game (or start playing with a group of people who know how. It's more expensive than reading a book, but the group won't mind. *Snicker*).\r\n" + 
				"\t"+"This list is currently broken into several parts:\r\n" + 
				"\r\n" + 
				"The Very Basics\r\n" + 
				"How the Hands are Ranked\r\n" + 
				"Descriptions of Hand Ranks\r\n" + 
				"Betting\r\n" + 
				"An Example 5-Card Draw Hand\r\n" + 
				"The Very Basics\r\n" + 
				"\t"+"Poker is played from a standard pack of 52 cards. (Some variant games use multiple packs or add a few cards called jokers.) The cards are ranked (from high to low) Ace, King, Queen, Jack, 10, 9, 8, 7, 6, 5, 4, 3, 2, Ace. (Ace can be high or low, but is usually high). There are four suits (spades, hearts, diamonds and clubs); however, no suit is higher than another. All poker hands contain five cards, the highest hand wins.\r\n" + 
				"\t"+"Some games have Wild Cards, which can take on whatever suit and rank their possessor desires. Sometimes jokers will be used as wild cards, other times, the game will specify which cards are wild (dueces, one-eyed jacks, or whatever).\r\n" + 
				"\r\n" + 
			 
				"Descriptions of Hand Ranks"+
				"\t"+"The best possible straight flush is known as a royal flush, which consists of the ace, king, queen, jack and ten of a suit. A royal flush is an unbeatable hand."+
				"\t"+"A straight flush is the best natural hand. A straight flush is a straight (5 cards in order, such as 5-6-7-8-9) that are all of the same suit. As in a regular straight, you can have an ace either high (A-K-Q-J-T) or low (5-4-3-2-1). However, a straight may not 'wraparound'. (Such as K-A-2-3-4, which is not a straight). An Ace high straight-flush is called a Royal Flush and is the highest natural hand.\r\n" + 
				"\t"+"Four of a Kind\r\n" + 
				"\t"+"Four of a kind is simply four cards of the same rank. If there are two or more hands that qualify, the hand with the higher-rank four of a kind wins. If, in some bizarre game with many wild cards, there are two four of a kinds with the same rank, then the one with the high card outside the four of the kind wins. General Rule: When hands tie on the rank of a pair, three of a kind, etc, the cards outside break ties following the High Card rules.\r\n" + 
				"Full House\r\n" + 
				"A full house is a three of a kind and a pair, such as K-K-K-5-5. Ties are broken first by the three of a kind, then pair. So K-K-K-2-2 beats Q-Q-Q-A-A, which beats Q-Q-Q-J-J. (Obviously, the three of a kind can only be similiar if wild cards are used.)\r\n" + 
				"Flush\r\n" + 
				"A flush is a hand where all of the cards are the same suit, such as J-8-5-3-2, all of spades. When flushes ties, follow the rules for High Card.\r\n" + 
				"Straight\r\n" + 
				"A straight is 5 cards in order, such as 4-5-6-7-8. An ace may either be high (A-K-Q-J-T) or low (5-4-3-2-1). However, a straight may not 'wraparound'. (Such as Q-K-A-2-3, which is not a straight). When straights tie, the highest straight wins. (AKQJT beats KQJT9 down to 5432A). If two straights have the same value (AKQJT vs AKQJT) they split the pot.\r\n" + 
				"Three of a Kind\r\n" + 
				"Three cards of any rank, matched with two cards that are not a pair (otherwise it would be a Full House . Again, highest three of a kind wins. If both are the same rank, then the compare High Cards.\r\n" + 
				"Two Pair\r\n" + 
				"This is two distinct pairs of card and a 5th card. The highest pair wins ties. If both hands have the same high pair, the second pair wins. If both hands have the same pairs, the high card wins.\r\n" + 
				"Pair\r\n" + 
				"One pair with three distinct cards. High card breaks ties.\r\n" + 
				"High Card\r\n" + 
				"This is any hand which doesn't qualify as any one of the above hands. If nobody has a pair or better, then the highest card wins. If multiple people tie for the highest card, they look at the second highest, then the third highest etc. High card is also used to break ties when the high hands both have the same type of hand (pair, flush, straight, etc).\r\n" + 
				"Betting\r\n" + 
				"So, how do you bet? Poker is, after all, a gambling game. In most games, you must 'ante' something (amount varies by game, our games are typically a nickel), just to get dealt cards. After that players bet into the pot in the middle. At the end of the hand, the highest hand (that hasn't folded) wins the pot. Basically, when betting gets around to you (betting is typically done in clockwise order), you have one of three choices:\r\n" + 
				"Call\r\n" + 
				"When you call, you bet enough to match what has been bet since the last time you bet (for instance, if you bet a dime last time, and someone else bet a quarter, you would owe fifteen cents).\r\n" + 
				"Raise\r\n" + 
				"When you raise, you first bet enough to match what has been bet since the last time you bet (as in calling), then you 'raise' the bet another amount (up to you, but there is typically a limit.) Continuing the above example, if you had bet a dime, the other person raised you fifteen cents (up to a quarter), you might raise a quarter (up to fifty cents). Since you owed the pot 15 cents for calling and 25 for your raise, you would put 40 cents into the pot.\r\n" + 
				"Fold\r\n" + 
				"When you fold, you drop out of the current hand (losing any possibility of winning the pot), but you don't have to put any money into the pot.\r\n" + 
				"Betting continues until everyone calls or folds after a raise or initial bet.\r\n" + 
				"Some Standard Betting Rules\r\n" + 
				"In the group I play in, we ante a nickel. The maximum first bet is fifty cents, and the maximum raise is fifty cents. However, during one round of betting, raises may total no more than one dollar.\r\n" + 
				"An Example Five Card Draw Hand.\r\n" + 
				"Five card draw is one of the most common types of poker hands. Each player is dealt five cards, then a round of betting follows. Then each player may discard up to 3 cards (4 if your last card is an ace or wild card, in some circles) and get back (from the deck) as many cards as he/she discarded. Then there is another round of betting, and then hands are revealed (the showdown) and the highest hand wins the pot. So you are the dealer at a five card draw game (against four other players, Alex, Brad, Charley and Dennis (seated in that order to your left). Everyone puts a nickel into the pot (Ante) and you deal out 5 cards to each player.\r\n" + 
				"You deal yourself a fairly good hand Ks-Kd-Jd-5c-3d. A pair of kings isn't bad off the deal (not great, but not bad). Then the betting starts...\r\n" + 
				"\r\n" + 
				"Alex 'Checks' (checking is basically calling when you don't owe anything to the pot).\r\n" + 
				"Brad bets a dime.\r\n" + 
				"Charley calls (and puts a dime into the pot).\r\n" + 
				"Dennis raises a dime (and puts twenty cents into the pot).\r\n" + 
				"Well, it's your turn. Twenty cents to you. You can fold, call or raise. Like I said before, pair of kings isn't bad, not good but not bad. You call and put twenty cents into the pot.\r\n" + 
				"Back to Alex, who grumbles and tosses his cards into the center of the table, folding. (Note, when folding, never show your cards to anyone).\r\n" + 
				"Brad calls. The total bet is twenty cents, but he had already bet a dime, so he owes a dime, which he tosses into the pot.\r\n" + 
				"Charley is in the same position as brad, and tosses a dime into the pot.\r\n" + 
				"The round of betting is over. After Dennis's raise, everyone else folded or called (there weren't any raises) so, everyone is all square with the pot. Now everyone can discard up to 3 cards. Brad discards 3 cards, Charley discards one card, Dennis discards two cards. (You deal replacements to everyone) and now it's your turn. You have a pair of kings, three spades, and no chance for a straight. It's best to just keep the two kings and hope to get a 3rd or fourth king. You discard three cards, and your new hand is: Ks-Kd-Kc-4c-8h. Three Kings! A nice little hand.\r\n" + 
				"What do you suppose the others were trying for? Well, Brad kept two cards, so he probably had a pair (just like you) but it probably wasn't aces, so even if brad got a three of a kind, you probably beat him. Charley kept four cards, so he was probably trying for a straight or flush. (If Charley had four of a kind, he might have bet much harder). The big problem is Dennis. He raised earlier, and only drew two cards. He might be bluffing, but he could have had three of a kind off the deal... In any case, the second round of betting starts (with dealers left).\r\n" + 
				"\r\n" + 
				"Brad bets a nickel.\r\n" + 
				"Charley folds (I guess he didn't get his straight or flush).\r\n" + 
				"Dennis raises twenty cents (to a quarter total).\r\n" + 
				"You call.\r\n" + 
				"Brad looks at his cards, then calls (betting twenty cents).\r\n" + 
				"Again, everyone called Dennis's raise, so the round of betting is over.\r\n" + 
				"Well, the betting is over, everyone reveals his hand:\r\n" + 
				"You had Ks-Kd-Kc-4c-8h.\r\n" + 
				"Brad had Jh-Jd-3c-3s-Ah.\r\n" + 
				"Dennis had Qh-Qs-Qd-As-7s.\r\n" + 
				"Well, the highest hand is three of a kind, and the highest three of a kind is your three kings. You win!");
				
				
		Button exitbtn = new Button ("Exit");
		exitbtn.setOnAction(e -> window.close());		
		
		BorderPane layout = new BorderPane();

		layout.setCenter(label);
		layout.setBottom(exitbtn);
		layout.setId("ruleWindow");
		
		
		Scene scene = new Scene (layout);
		window.setScene(scene);
		window.showAndWait();
	}
}
