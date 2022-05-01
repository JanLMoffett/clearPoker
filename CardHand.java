/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javapoker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;


public class CardHand {
    
    ArrayList<Card> hand = new ArrayList<>();
    
    
    CardHand(Card... cards){
        hand.addAll(Arrays.asList(cards));
    }
    
    CardHand(ArrayList<Card> cardList){
        hand = cardList;
    
    }
    
    public ArrayList<Card> getHand(){
        return hand;
    
    }
    
    public int getSize(){
        return hand.size();
    }
    
    public void addCard(Card c){
        hand.add(c);
    
    }
    
    public void removeCard(Card c){
        hand.remove(c);
    }
    
    public void sortHand(){
        Comparator<Card> cp = new CardComparator();
        hand.sort(cp);
    }
    
    public Card getHighCard(){
        sortHand();
        return hand.get(hand.size()-1);
    }
    
    public void printHand(){
        hand.forEach(c -> System.out.println(c.toString()));
    }
    
    public ArrayList<CardRank> getRanks(){
        ArrayList<CardRank> ranks = new ArrayList<>();
        
        hand.forEach(c -> ranks.add(c.getRank()));
            
        return ranks;
    
    }
    
    public ArrayList<CardSuit> getSuits(){
        ArrayList<CardSuit> suits = new ArrayList<>();
        
        hand.forEach(c -> suits.add(c.getSuit()));
        
        return suits;
    
    }
    
    public int getHashScore(){
    
        int hs = 0;
        for(Card c : hand){
            hs += c.hashCode();
        }
        
        return hs;
                      
    }
    
    
}
