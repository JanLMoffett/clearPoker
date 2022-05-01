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
public class CardComparator implements Comparator<Card>{
    
    @Override
    public int compare(Card card1, Card card2){
    
        return card1.compareTo(card2)>0? 1 : card1.compareTo(card2)<0? -1 : 0;
        
    
    }
    
    static int compareCards(Card card1, Card card2){
        return card1.compareTo(card2)>0? 1 : card1.compareTo(card2)<0? -1 : 0;
    
    }
    
    static int compareSuits(Card card1, Card card2){
        return card1.compareSuit(card2)>0? 1 : card1.compareSuit(card2)<0? -1 : 0;
        
    }
    
    static int compareRanks(Card card1, Card card2){
        return card1.compareRank(card2)>0? 1 : card1.compareRank(card2)<0? -1 : 0;
        
    }
    
    
}
