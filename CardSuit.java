/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javapoker;

/**
 *
 * @author Jan
 */
public enum CardSuit {
    
    CLUBS("Clubs", 1),
    DIAMONDS("Diamonds", 2),
    HEARTS("Hearts", 3),
    SPADES("Spades", 4);
    
    private final String word;
    private final int value;
    
    CardSuit(String w, int v){
        word = w;
        value = v;
    }
    
    public String word(){
        return word;
    }
    
    public int value(){
        return value;
    }
    
}
