
package javapoker;

import java.util.Comparator;

/**
 * A comparator built for poker players.
 * @author Jan L. Moffett
 */
public class PlayerComparator implements Comparator<TexasHoldemPlayer>{
    
    /**
     * Compares two players in a Texas Holdem poker game.
     * @param p1    the first player.
     * @param p2    the second player.
     * @return  1 if the first player has a better hand than the second player, -1 if the first player has a worse hand than the second player, and 0 if there is a tie. 
     */
    @Override
    public int compare(TexasHoldemPlayer p1, TexasHoldemPlayer p2){
    
        if(p1.getScore() - p2.getScore() > 0)
            return 1;
        else if(p1.getScore() - p2.getScore() < 0)
            return -1;
        else
            return 0;
    
    }
    
}
