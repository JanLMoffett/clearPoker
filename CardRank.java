
package javapoker;

/**
 * A playing card rank; 2-10, Jack Queen, or King.
 * @author Jan L. Moffett
 */
public enum CardRank {
    TWO("2", 2),
    THREE("3", 3),
    FOUR("4", 4),
    FIVE("5", 5),
    SIX("6", 6),
    SEVEN("7", 7),
    EIGHT("8", 8),
    NINE("9", 9),
    TEN("10", 10),
    JACK("Jack", 11),
    QUEEN("Queen", 12),
    KING("King", 13),
    ACE("Ace", 14);
    
    private final String word;
    private final int value;
    
    /**
     * Sole constructor.
     * @param w a word identifying the rank, i.e. "8" or "Queen."
     * @param v a number identifying the rank, i.e. 8 or 12. 
     */
    CardRank(String w, int v){
        word = w;
        value = v;
    
    }
    
    /**
     * Returns the rank in word form.
     * @return  a word identifying the rank, i.e. "8" or "Queen.   
     */
    public String word(){
        return word;
    }
    
    /**
     * Returns the rank in number form.
     * @return  a number identifying the rank, i.e. 8 or 12. 
     */
    public int value(){
        return value;
    }
    
}
