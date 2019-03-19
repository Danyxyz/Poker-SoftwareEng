package poker.version_graphics.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public enum HandType {
    HighCard, OnePair, TwoPair, ThreeOfAKind, Straight, Flush, FullHouse, FourOfAKind, StraightFlush, RoyalFlush;
    
    /**
     * Determine the value of this hand. Note that this does not
     * account for any tie-breaking
     */
    public static HandType evaluateHand(ArrayList<Card> cards) {
        HandType currentEval = HighCard;
        
        if (isOnePair(cards)) currentEval = OnePair;
        if (isTwoPair(cards)) currentEval = TwoPair;
        if (isThreeOfAKind(cards)) currentEval = ThreeOfAKind;
        if (isStraight(cards)) currentEval = Straight;
        if (isFlush(cards)) currentEval = Flush;
        if (isFullHouse(cards)) currentEval = FullHouse;
        if (isFourOfAKind(cards)) currentEval = FourOfAKind;
        if (isStraightFlush(cards)) currentEval = StraightFlush;
        if (isRoyalFlush(cards)) currentEval = RoyalFlush;
     
        // Royal Flush?
        
        return currentEval;
    }
    

	public static boolean isOnePair(ArrayList<Card> cards) {
    	boolean found = false;
        for (int i = 0; i < cards.size() - 1 && !found; i++) {
            for (int j = i+1; j < cards.size() && !found; j++) {
                if (cards.get(i).getRank() == cards.get(j).getRank()) found = true;
            }
        }
        return found;
    }
    
    public static boolean isTwoPair(ArrayList<Card> cards) {
        // Clone the cards, because we will be altering the list
        ArrayList<Card> clonedCards = (ArrayList<Card>) cards.clone();

        // Find the first pair; if found, remove the cards from the list
        boolean firstPairFound = false;
        for (int i = 0; i < clonedCards.size() - 1 && !firstPairFound; i++) {
            for (int j = i+1; j < clonedCards.size() && !firstPairFound; j++) {
                if (clonedCards.get(i).getRank() == clonedCards.get(j).getRank()) {
                    firstPairFound = true;
                    clonedCards.remove(j);  // Remove the later card
                    clonedCards.remove(i);  // Before the earlier one
                }
            }
        }
        // If a first pair was found, see if there is a second pair
        return firstPairFound && isOnePair(clonedCards);
    }
    
    public static boolean isThreeOfAKind(ArrayList<Card> cards) {
    	boolean foundThree = false;
    	for (int i = 0; i <= cards.size() - 1 && !foundThree; i++) {
            for (int j = i+1; j <= cards.size() - 1 && !foundThree; j++) {
            	for (int k =j +1; k <= cards.size() -1 && !foundThree; k++) {
            			if (cards.get(i).getRank() == cards.get(j).getRank() && cards.get(i).getRank() == cards.get(k).getRank())
            					foundThree = true;            			
            	}
            }
    	}
    	return foundThree;
    }
        
    
    
    public static boolean isStraight(ArrayList<Card> cards) {
    	boolean straightFound = false;
    	 ArrayList<Card> clonedCards = (ArrayList<Card>) cards.clone();
    
    	Collections.sort(clonedCards, new Comparator <Card>() {
    		@Override
    		public int compare(Card card1, Card card2) {
    			return card1.getOrdinal() - card2.getOrdinal();
    			
    		}
    	});
    	if (clonedCards.get(0).getOrdinal() == clonedCards.get(1).getOrdinal()-1
    		&& clonedCards.get(1).getOrdinal() == clonedCards.get(2).getOrdinal()-1
			&& clonedCards.get(2).getOrdinal() == clonedCards.get(3).getOrdinal()-1
			&& clonedCards.get(3).getOrdinal() == clonedCards.get(4).getOrdinal()-1) 
    	{
    		straightFound = true;
    	}else if (clonedCards.get(4).getOrdinal()==12 && 
    			clonedCards.get(0).getOrdinal()==0 && 
    			clonedCards.get(1).getOrdinal()==1 &&
    			clonedCards.get(2).getOrdinal()==2 && 
    			clonedCards.get(3).getOrdinal()== 3) {
    		straightFound = true;
    	}
			
		
		return straightFound;
    }
   
    
    public static boolean isFlush(ArrayList<Card> cards) {
    	boolean foundFlush = false;
        if (cards.get(0).getSuit() == cards.get(1).getSuit() && cards.get(0).getSuit() == cards.get(2).getSuit() && 
         	cards.get(0).getSuit() == cards.get(3).getSuit() && cards.get(0).getSuit() == cards.get(4).getSuit()) 
         		foundFlush = true;
   
        
         	return foundFlush;
    }

      
    public static boolean isFullHouse(ArrayList<Card> cards) {
    			boolean foundOP = false;
    		ArrayList<Card> clonedCards = (ArrayList<Card>) cards.clone();
    	
            for (int i = 0; i < cards.size() - 1 && !foundOP; i++) {
                for (int j = i+1; j < cards.size() && !foundOP; j++) {
                    if (cards.get(i).getRank() == cards.get(j).getRank()) {
                    foundOP = true;
                    clonedCards.remove(j);
                    clonedCards.remove(i);
                }
                }            	
            }
             return foundOP && isThreeOfAKind(clonedCards);
    	}
    		
    
       
    public static boolean isFourOfAKind(ArrayList<Card> cards) {
    	boolean foundFour = false;
    	
    	ArrayList<Card> clonedCards = (ArrayList<Card>) cards.clone();
        
    	Collections.sort(clonedCards, new Comparator <Card>() {
    		@Override
    		public int compare(Card card1, Card card2) {
    			return card1.getOrdinal() - card2.getOrdinal();
    		}
    	});
    	
    	if (clonedCards.get(0).getRank() == clonedCards.get(3).getRank()) {
    		foundFour = true;
    	}
    	if (clonedCards.get(1).getRank() == clonedCards.get(4).getRank()) {
    		foundFour = true;
    	}
    		   	
    	return foundFour;
    }
    		
    	
   
    public static boolean isStraightFlush(ArrayList<Card> cards) {
                return isFlush(cards) && isStraight(cards);
    }
    
    
    private static boolean isRoyalFlush(ArrayList<Card> cards) {
    	boolean royalFound = false;
    	
    	if (isFlush(cards) && isStraight(cards) == true && cards.get(0).getOrdinal() == 9 && cards.get(4).getOrdinal() == 12) {
    		royalFound = true;
    	}
    	return royalFound;
    }
}
