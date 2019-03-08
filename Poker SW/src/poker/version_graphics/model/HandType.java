package poker.version_graphics.model;

import java.util.ArrayList;

public enum HandType {
    HighCard, OnePair, TwoPair, ThreeOfAKind, Straight, Flush, FullHouse, FourOfAKind, StraightFlush;
    
    /**
     * Determine the value of this hand. Note that this does not
     * account for any tie-breaking
     */
    public static HandType evaluateHand(ArrayList<Card> cards) {
        HandType currentEval = HighCard;
        
        if (isOnePair(cards)) currentEval = OnePair;
        if (isTwoPair(cards)) currentEval = TwoPair;
        if (isThreeOfAKind(cards)) currentEval = ThreeOfAKind;
        //if (isStraight(cards)) currentEval = Straight;
       // if (isFlush(cards)) currentEval = Flush;
       // if (isFullHouse(cards)) currentEval = FullHouse;
     // if (isFourOfAKind(cards)) currentEval = FourOfAKind;
        //if (isStraightFlush(cards)) currentEval = StraightFlush;
     
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
        boolean foundOnePair = false;
        boolean foundThreeOfKind = false;
        for (int i = 0; i < cards.size(); i++) {
            for (int j = i+1; j < cards.size(); j++) {
            		if (cards.get(i).getRank() == cards.get(j).getRank())
            		{
            			if (foundOnePair) {
            				foundThreeOfKind = true;
            			}
            			else {
            				foundOnePair = true;
            			}
            		}
            	}
        }
            
        return foundThreeOfKind;
    }
    
    public static boolean isStraight(ArrayList<Card> cards) {
        // TODO        
        return false;
    }
    
    public static boolean isFlush(ArrayList<Card> cards) {
        // TODO        
        return false;
    }
    
    /*public static boolean isFullHouse(ArrayList<Card> cards) {
    	boolean foundThree = false;
        boolean foundPair = false;
        boolean found = false;
        
        /* searches for 3 of a kind
         * 
       
        for (int i = 0; i < cards.size() - 1 && !foundThree; i++) {
            for (int j = i+1; j < cards.size() && !foundThree; j++) {
            		if (cards.get(i).getRank() == cards.get(j).getRank() && cards.get(i).getRank() == cards.get(j).getRank())
            			foundThree = true; 
            }
        }
    /*        	
    //searching for one pair using onePair method
       
            		for (int x = 0; x < cards.size() -1 && !foundPair; x++) {
            	            for (int y = x+1; y < cards.size() && !foundPair; y++) {
            	                if (cards.get(x).getRank() == cards.get(y).getRank()) {
            	             foundPair = true;
            	            }
            	        }
            	
            	}
        if (foundThree && foundPair == true) 
        	found = true;
    
        return found;
    }
    
    /* public static boolean isFourOfAKind(ArrayList<Card> cards) {
        boolean found = false;
        for (int i = 0; i < cards.size() - 1 && !found; i++) {
            for (int j = i+1; j < cards.size() && !found; j++) {
            	for (int k =j +1; k < cards.size() && !found; k++) {
            		for (int l = k+1; l < cards.size() && !found; l++) {
            			if (cards.get(i).getRank() == cards.get(j).getRank() && cards.get(i).getRank() == cards.get(k).getRank()
            					&& cards.get(k).getRank() == cards.get(l).getRank());
                			found = true;
                		}
                	}
                }
         	}
        	return found;  
} */

    
    
    public static boolean isStraightFlush(ArrayList<Card> cards) {
        // TODO        
        return false;
    }
}
