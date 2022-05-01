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
public class Card implements Comparable<Card>{
    
    private final CardSuit suit;
    private final CardRank rank;
    
    Card(CardSuit s, CardRank r){
        suit = s;
        rank = r;
    
    }
    
    public CardSuit getSuit(){
        return suit;
    
    }
    
    public CardRank getRank(){
        return rank;
    }
    
    @Override
    public String toString(){
    
        return rank.word() + " of " + suit.word();
    
    }
    
    @Override
    public boolean equals(Object otherCard){
    
        if(otherCard instanceof Card){
            Card oc = (Card)otherCard;
            return suit == oc.suit && rank == oc.rank;
        }else{
            return false;
        }
    
    }
    
    public boolean equalSuit(Card otherCard){
        return suit == otherCard.suit;
    
    }
    
    public boolean equalRank(Card otherCard){
        return rank == otherCard.rank;
    
    }
    
    @Override
    public int hashCode(){
    
        return suit.value() + rank.value()*10;
    
    }
    
    @Override
    public int compareTo(Card otherCard){
    
        return this.hashCode() - otherCard.hashCode();
    
    }
    
    public int compareSuit(Card otherCard){
        return suit.value() - otherCard.suit.value();
    }
    
    public int compareRank(Card otherCard){
        return rank.value() - otherCard.rank.value();
    
    }
    
}
