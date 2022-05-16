
package javapoker;
import java.util.Comparator;
/**
 *A comparator built for playing cards.
 * @author Jan L. Moffett
 */
public class CardComparator implements Comparator<Card>{
    
    /**
     * Compares the values of two cards.
     * @param card1 a first card.
     * @param card2 a second card.
     * @return  1 if the first card is more valuable than the second card, -1 if the first card is less valuable than the second card, 0 if the two cards are equal.   
     */
    @Override
    public int compare(Card card1, Card card2){
    
        return card1.compareTo(card2)>0? 1 : card1.compareTo(card2)<0? -1 : 0;
        
    
    }
    
    /**
     * Compares the values of two cards.
     * @param card1 a first card.
     * @param card2 a second card.
     * @return  1 if the first card is more valuable than the second card, -1 if the first card is less valuable than the second card, 0 if the two cards are equal. 
     */
    static int compareCards(Card card1, Card card2){
        return card1.compareTo(card2)>0? 1 : card1.compareTo(card2)<0? -1 : 0;
    
    }
    
    /**
     * Compares the values of two cards based on their suits.
     * @param card1 a first card.
     * @param card2 a second card.
     * @return  1 if the first card's suit is more valuable than the second card's suit, -1 if the first card's suit is less valuable than the second card's suit, 0 if the suits are equal. 
     */
    static int compareSuits(Card card1, Card card2){
        return card1.compareSuit(card2)>0? 1 : card1.compareSuit(card2)<0? -1 : 0;
        
    }
    
    /**
     * Compares the values of two cards based on their ranks.
     * @param card1 a first card.
     * @param card2 a second card.
     * @return  1 if the first card's rank is more valuable than the second card's rank, -1 if the first card's rank is less valuable than the second card's rank, 0 if the ranks are equal. 
     */
    static int compareRanks(Card card1, Card card2){
        return card1.compareRank(card2)>0? 1 : card1.compareRank(card2)<0? -1 : 0;
        
    }
    
    
}
