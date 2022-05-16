
package javapoker;

/**
 * A playing card suit; Clubs, Diamonds, Hearts, or Spades.
 * @author Jan L. Moffett
 */
public enum CardSuit {
    
    CLUBS("Clubs", 1),
    DIAMONDS("Diamonds", 2),
    HEARTS("Hearts", 3),
    SPADES("Spades", 4);
    
    private final String word;
    private final int value;
    
    /**
     * Sole constructor.
     * @param w a word identifying the suit of the card; "Clubs", "Diamonds", "Hearts", or "Spades".
     * @param v a number identifying the suit of the card; 1, 2, 3, or 4. 
     */
    CardSuit(String w, int v){
        word = w;
        value = v;
    }
    
    /**
     * Returns the suit in word form.
     * @return  a word identifying the suit of the card; "Clubs", "Diamonds", "Hearts", or "Spades".
     */
    public String word(){
        return word;
    }
    
    /**
     * Returns the suit of the card in number form.
     * @return  a number identifying the suit of the card; 1, 2, 3, or 4. 
     */
    public int value(){
        return value;
    }
    
}
