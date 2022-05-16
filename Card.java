
package javapoker;
/**
 *A playing card with a suit and a rank that can be compared to other cards.
 * 
 * @author Jan L. Moffett
 */
public class Card implements Comparable<Card>{
    
    private final CardSuit suit;
    private final CardRank rank;
    
    /**
     * Sole constructor.
     * @param s one of four suits: Clubs, Diamonds, Hearts, or Spades. 
     * @param r one of thirteen ranks: 2-10, Jack, Queen, King, or Ace.  
     */
    Card(CardSuit s, CardRank r){
        suit = s;
        rank = r;
    
    }
    
    /**
     * Returns the card's suit.
     * @return  one of four suits: Clubs, Diamonds, Hearts, or Spades.   
     */
    public CardSuit getSuit(){
        return suit;
    
    }
    
    /**
     * Returns the card's rank.
     * @return  one of thirteen ranks: 2-10, Jack, Queen, King, or Ace. 
     */
    public CardRank getRank(){
        return rank;
    }
    
    /**
     * Returns a verbal description of the card's suit and rank. 
     * @return  the card's suit and rank as a phrase, i.e. "King of Hearts."   
     */
    @Override
    public String toString(){
    
        return rank.word() + " of " + suit.word();
    
    }
    
    /**
     * Tests if two cards have the same suit and rank.
     * @param otherCard the card you want to compare to this card.
     * @return  true if the other card is equal to this card, false otherwise. 
     */
    @Override
    public boolean equals(Object otherCard){
    
        if(otherCard instanceof Card){
            Card oc = (Card)otherCard;
            return suit == oc.suit && rank == oc.rank;
        }else{
            return false;
        }
    
    }
    
    /**
     * Tests if two cards have the same suit.
     * @param otherCard the card you want to compare to this card.
     * @return  true if the suit of the other card is the same as the suit of this card, false otherwise.
     */
    public boolean equalSuit(Card otherCard){
        return suit == otherCard.suit;
    
    }
    
    /**
     * Tests if two cards have the same rank.
     * @param otherCard the card you want to compare to this card.
     * @return  true if the rank of the other card is the same as the rank of this card, false otherwise. 
     */
    public boolean equalRank(Card otherCard){
        return rank == otherCard.rank;
    
    }
    
    /**
     * Creates a hashcode to uniquely identify the card's suit and rank combination.
     * @return  a number.
     */
    @Override
    public int hashCode(){
    
        return suit.value() + rank.value()*10;
    
    }
    
    /**
     * Compares the values of two cards based on their hashcodes.
     * @param otherCard the card you want to compare to this card.
     * @return  the difference between this card's hashcode and the other card's hashcode, a negative number if the other card has a higher value than this card, a positive number otherwise.
     */
    @Override
    public int compareTo(Card otherCard){
    
        return this.hashCode() - otherCard.hashCode();
    
    }
    
    /**
     * Compares the values of two cards based on their suits.
     * @param otherCard the card you want to compare to this card.
     * @return  the difference between this card's suit value and the other card's suit value, a negative number if the other card's suit is more valuable, positive otherwise. 
     */
    public int compareSuit(Card otherCard){
        return suit.value() - otherCard.suit.value();
    }
    
    /**
     * Compares the values of two cards based on their ranks.
     * @param otherCard the card you want to compare to this card.
     * @return  the difference between this card's rank and the other card's rank, a negative number if the other card's rank is more valuable, positive otherwise.   
     */
       public int compareRank(Card otherCard){
        return rank.value() - otherCard.rank.value();
    
    }
    
}
