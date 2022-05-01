/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javapoker;

import java.util.Comparator;

/**
 *
 * @author Jan
 */
public class PlayerComparator implements Comparator<TexasHoldemPlayer>{
    
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
