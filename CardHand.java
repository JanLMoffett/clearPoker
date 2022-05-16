
package javapoker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * A hand of cards, as dealt to a player in a Texas Holdem game.
 * @author Jan L. Moffett
 */
public class CardHand {
    
    ArrayList<Card> hand = new ArrayList<>();
    
    /**
     * Constructs a hand of cards from one or more individual cards.
     * @param cards the cards to deal to the hand. 
     */
    CardHand(Card... cards){
        hand.addAll(Arrays.asList(cards));
    }
    
    /**
     * Constructs a hand of cards from an ArrayList of cards.
     * @param cardList 
     */
    CardHand(ArrayList<Card> cardList){
        hand = cardList;
    
    }
    
    /**
     * Returns the hand.
     * @return  the cards of the hand contained in an ArrayList. 
     */
    public ArrayList<Card> getHand(){
        return hand;
    
    }
    
    /**
     * Returns the number of cards in the hand.
     * @return  a number. 
     */
    public int getSize(){
        return hand.size();
    }
    
    /**
     * Adds a card to the hand.
     * @param c the card to be added to the hand. 
     */
    public void addCard(Card c){
        hand.add(c);
    
    }
    
    /**
     * Removes a card from the hand.
     * @param c the card to be removed from the hand.
     */
    public void removeCard(Card c){
        hand.remove(c);
    }
    
    /**
     * Sorts the hand in ascending order.
     */
    public void sortHand(){
        Comparator<Card> cp = new CardComparator();
        hand.sort(cp);
    }
    
    /**
     * Returns the most valuable card in the hand.
     * @return  the card with the highest value in the hand. 
     */
    public Card getHighCard(){
        sortHand();
        return hand.get(hand.size()-1);
    }
    
    /**
     * Prints the cards in the hand.
     */
    public void printHand(){
        hand.forEach(c -> System.out.println(c.toString()));
    }
    
    /**
     * Returns the ranks of the cards in the hand.
     * @return  an ArrayList of card ranks. 
     */
    public ArrayList<CardRank> getRanks(){
        ArrayList<CardRank> ranks = new ArrayList<>();
        
        hand.forEach(c -> ranks.add(c.getRank()));
            
        return ranks;
    
    }
    
    /**
     * Returns the suits of the cards in the hand.
     * @return  an ArrayList of card suits.
     */
    public ArrayList<CardSuit> getSuits(){
        ArrayList<CardSuit> suits = new ArrayList<>();
        
        hand.forEach(c -> suits.add(c.getSuit()));
        
        return suits;
    
    }
    
    /**
     * Computes the value of the hand in terms hashcodes.
     * @return  a number expressing the value of the hand based on the cards it contains, to be compared to other hands. 
     */
    public int getHashScore(){
    
        int hs = 0;
        for(Card c : hand){
            hs += c.hashCode();
        }
        
        return hs;
                      
    }
    
    
}
