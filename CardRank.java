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
    
    CardRank(String w, int v){
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
