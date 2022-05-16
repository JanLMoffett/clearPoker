
package javapoker;

import java.util.ArrayList;
/**
 * A class that classifies poker hands according to type. 
 * @author Jan L. Moffett
 */
public class HandFinder {
    
    /**
     * Returns the largest group of cards with equal ranks in a hand, or the card with the or group of cards with the most value rank in case of a tie.
     * @param hand  a hand of cards.
     * @return  an ArrayList of cards. 
     */
    public static ArrayList<Card> getBestGroup(CardHand hand){
        
        hand.sortHand();
        
        ArrayList<Card> cards = hand.getHand();
        ArrayList<Card> group = new ArrayList<>();
        int curSize = 1;
        
        for(int i = 0; i < cards.size()-1; i++){
            //keep a temp list for group matching each card
            ArrayList<Card> temp = new ArrayList<>();
            
            //add current card to temp list
            temp.add(cards.get(i));
            
            //go through rest of cards and compare
            for(int j = i+1; j < cards.size(); j++){
            
                if(cards.get(i).equalRank(cards.get(j))){
                    temp.add(cards.get(j));

                }
            }
            
            if(temp.size() >= curSize){
                curSize = temp.size();
                group = temp;
            }
            
        }
        
        //if no group larger than one, return high card
        if(group.size()==1){
            group.set(0, cards.get(cards.size()-1));
        }
        
        return group;
        
    }
    
    /**
     * Returns the cards with the longest run of consecutive ranks in a hand, or the group with more valuable ranks in case of a tie.
     * @param hand  a hand of cards.
     * @return  an ArrayList of cards. 
     */
    public static ArrayList<Card> getBestRun(CardHand hand){
        
        hand.sortHand();
        
        ArrayList<Card> cards = hand.getHand();
        ArrayList<Card> group = new ArrayList<>();
        ArrayList<Card> temp = new ArrayList<>();
        
        temp.add(cards.get(0));
        
        for(int i = 0; i < cards.size()-1; i++){
            
            if(cards.get(i+1).compareRank(cards.get(i)) == 1){
                temp.add(cards.get(i+1));
                
                
            }else if(cards.get(i+1).compareRank(cards.get(i)) > 1){
                
                if(temp.size() > group.size())
                    group = temp;
                temp = new ArrayList<>();
                temp.add(cards.get(i+1));
            
            }else if(cards.get(i+1).compareRank(cards.get(i)) == 0){
                
                temp.set(temp.size()-1, cards.get(i+1));
                
            }
        }
        
        if(temp.size() >= group.size()){
            group = temp;
        }
        
        return group;
        
    }
    
    /**
     * Tests the hand for a Flush - at least 5 cards of the same suit.
     * @param hand  a hand of cards in a Texas Holdem poker game.
     * @return  true if the hand contains a flush, false otherwise. 
     */
    public static boolean hasFlush(CardHand hand){
        
        //assert that hand has at least 5 cards
        if(hand.getSize() < 5)
            return false;
        
        ArrayList<Card> cards = hand.getHand();
        
        ArrayList<Card> clubs = new ArrayList<>();
        ArrayList<Card> diamonds = new ArrayList<>();
        ArrayList<Card> hearts = new ArrayList<>();
        ArrayList<Card> spades = new ArrayList<>();
        
        for(Card c :  cards){
            switch(c.getSuit()){
                case CLUBS:
                    clubs.add(c);
                    break;
                case DIAMONDS:
                    diamonds.add(c);
                    break;
                case HEARTS:
                    hearts.add(c);
                    break;
                case SPADES:
                    spades.add(c);
                    break;
            
            }
        }
        
        if(clubs.size() >= 5){
            return true;
        }else if(diamonds.size() >= 5){
            return true;
        }else if(hearts.size() >= 5){
            return true;
        }else if(spades.size() >= 5){
            return true;
        }
        
        return false;
        
    }
    
    /**
     * Returns the cards that constitute the flush, if a hand contains one.
     * @param hand  a hand of cards.
     * @return  an ArrayList of five or more cards, or null if the hand has no flush. 
     */
    public static ArrayList<Card> getFlush(CardHand hand){
        
        hand.sortHand();
        ArrayList<Card> cards = hand.getHand();
        
        ArrayList<Card> clubs = new ArrayList<>();
        ArrayList<Card> diamonds = new ArrayList<>();
        ArrayList<Card> hearts = new ArrayList<>();
        ArrayList<Card> spades = new ArrayList<>();
        
        for(Card c :  cards){
            switch(c.getSuit()){
                case CLUBS:
                    clubs.add(c);
                    break;
                case DIAMONDS:
                    diamonds.add(c);
                    break;
                case HEARTS:
                    hearts.add(c);
                    break;
                case SPADES:
                    spades.add(c);
                    break;
            
            }
        }
        
        if(clubs.size() >= 5){
            switch(clubs.size()){
                case 5:
                    return clubs;
                case 6:
                    clubs.remove(0);
                    return clubs;
                case 7:
                    clubs.remove(0);
                    clubs.remove(0);
                    return clubs;
            
            }
            
        }else if(diamonds.size() >= 5){
            switch(diamonds.size()){
                case 5:
                    return diamonds;
                case 6:
                    diamonds.remove(0);
                    return diamonds;
                case 7:
                    diamonds.remove(0);
                    diamonds.remove(0);
                    return diamonds;
            
            }
        }else if(hearts.size() >= 5){
            switch(hearts.size()){
                case 5:
                    return hearts;
                case 6:
                    hearts.remove(0);
                    return hearts;
                case 7:
                    hearts.remove(0);
                    hearts.remove(0);
                    return hearts;
            
            }
        }else if(spades.size() >= 5){
            switch(spades.size()){
                case 5:
                    return spades;
                case 6:
                    spades.remove(0);
                    return spades;
                case 7:
                    spades.remove(0);
                    spades.remove(0);
                    return spades;
            
            }
        }
        
        return null;
        
    }
    
    /**
     * Tests a hand for a Four of a Kind - four cards with the same rank.
     * @param hand  a hand of cards.
     * @return  true if the hand contains a Four of a Kind, false otherwise. 
     */
    public static boolean hasFourOfAKind(CardHand hand){
    
        ArrayList<Card> group1 = getBestGroup(hand);
        return group1.size() == 4;
    
    }
    
    /**
     * Returns the cards that constitute the Four of a Kind.
     * @param hand  a hand of cards.
     * @return  an ArrayList of four cards, or null if the hand has no Four of a Kind. 
     */
    public static ArrayList<Card> getFourOfAKind(CardHand hand){
    
        ArrayList<Card> group1 = getBestGroup(hand);
        if(group1.size() == 4){
            return group1;
        }else{
            return null;
        }
    
    }
    
    /**
     * Tests a hand for a Three of a Kind - three cards with the same rank.
     * @param hand  a hand of cards.
     * @return  true if the hand had a Three of a Kind, false otherwise. 
     */
    public static boolean hasThreeOfAKind(CardHand hand){
    
        ArrayList<Card> group1 = getBestGroup(hand);
        return group1.size() == 3;
    
    }
    
    /**
     * Returns the cards than constitute the Three of a Kind.
     * @param hand  a hand of cards.
     * @return  an ArrayList of three cards, or null if the hand has no Three of a Kind. 
     */
    public static ArrayList<Card> getThreeOfAKind(CardHand hand){
    
        ArrayList<Card> group1 = getBestGroup(hand);
        if(group1.size() == 3){
            return group1;
        }else{
            return null;
        }
    }
    
    /**
     * Tests the hand for a Full House - three cards of one rank and two cards of another.
     * @param hand  a hand of cards.
     * @return  true if the hand contains a Full House, false otherwise. 
     */
    public static boolean hasFullHouse(CardHand hand){
        
        ArrayList<Card> h = new ArrayList<>();
        h.addAll(hand.getHand());
        CardHand handCopy = new CardHand(h);
        
        ArrayList<Card> group1 = getBestGroup(handCopy);
        
        if(group1.size() < 3)
            return false;
        
        group1.forEach(c -> handCopy.removeCard(c));
        
        ArrayList<Card> group2 = getBestGroup(handCopy);
        
        return group2.size() >= 2;
            
    }
    
    /**
     * Returns the cards that constitute the Full House.
     * @param hand  a hand of cards.
     * @return  an ArrayList of five cards, or null if the hand has no Full House.
     */
    public static ArrayList<Card> getFullHouse(CardHand hand){
        
        ArrayList<Card> h = new ArrayList<>();
        h.addAll(hand.getHand());
        CardHand handCopy = new CardHand(h);
        
        ArrayList<Card> group1 = getBestGroup(handCopy);
        
        if(group1.size() < 3)
            return null;
        
        group1.forEach(c -> handCopy.removeCard(c));
        
        ArrayList<Card> group2 = getBestGroup(handCopy);
        
        if(group2.size() < 2)
            return null;
        
        group1.addAll(group2);
        return group1;
            
    }
    
    /**
     * Tests the hand for a Straight - five or more cards with consecutive ranks.
     * @param hand  a hand of cards.
     * @return  true if the hand contains a Straight, false otherwise. 
     */
    public static boolean hasStraight(CardHand hand){
        
        ArrayList<Card> run = getBestRun(hand);
        
        return run.size() >= 5;
    
    }
    
    /**
     * Returns the cards that constitute the Straight.
     * @param hand  a hand of cards.
     * @return  an ArrayList of five cards, or null if the hand has no Straight.
     */
    public static ArrayList<Card> getStraight(CardHand hand){
        
        //assert that hand input has at least 7 cards
        if(hand.getSize() < 7)
            return null;
        
        ArrayList<Card> run = getBestRun(hand);
        
        switch(run.size()){
            case 5:
                return run;
            case 6: 
                run.remove(0);
                return run;
            case 7:
                run.remove(0);
                run.remove(0);
                return run;
            default:
                return null;
        
        }
    }
    
    /**
     * Returns all the cards that constitute a Pair - two cards with the same rank.
     * WARNING: This method should only be called after Four of a Kind, Three of a Kind, and Full House are ruled out.
     * @param hand a hand of cards.
     * @return  an ArrayList of cards, or null if the hand has no Pairs. 
     */
    public static ArrayList<Card> getPairs(CardHand hand){
        
        ArrayList<Card> h = new ArrayList<>();
        h.addAll(hand.getHand());
        CardHand handCopy = new CardHand(h);
        
        ArrayList<Card> group1 = getBestGroup(handCopy);
        
        if(group1.size() < 2){
            return null;
        }
        
        group1.forEach(c -> handCopy.removeCard(c));
        
        ArrayList<Card> group2 = getBestGroup(handCopy);
        
        if(group2.size() == 2){
            group1.addAll(group2);
            return group1;
        
        }else{
            return group1;
        }
        
    
    }
    
    /**
     * Tests the hand for Two Pair - two pair of cards with the same rank.
     * @param hand  a hand of cards.
     * @return  true if the hand has Two Pair,  false otherwise.
     */
    public static boolean hasTwoPair(CardHand hand){
        
        ArrayList<Card> h = new ArrayList<>();
        h.addAll(hand.getHand());
        CardHand handCopy = new CardHand(h);
        
        ArrayList<Card> group1 = getBestGroup(handCopy);
        
        if(group1.size() < 2){
            return false;
        }
        
        group1.forEach(c -> handCopy.removeCard(c));
        
        ArrayList<Card> group2 = getBestGroup(handCopy);
        
        return group2.size() >= 2;
        
    
    }
    
    /**
     * Tests the hand for a Pair - two cards with the same rank.
     * @param hand  a hand of cards.
     * @return  true if the hand contains a Pair, false otherwise. 
     */
    public static boolean hasPair(CardHand hand){
        
        ArrayList<Card> group1 = getBestGroup(hand);
        
        return group1.size() >= 2;
        
    
    }
    
}

