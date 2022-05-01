/*
Once cards are removed, they can't be added back in to deck.  Must initialize new deck. 

 */
package javapoker;

import java.util.ArrayList;
import java.util.Random;
import java.util.Comparator;

public class CardDeck {
    
    ArrayList<Card> deck;
    int size;
    
    CardDeck(){
        deck = new ArrayList<>();
        
        
        for(CardSuit s : CardSuit.values()){
            for(CardRank r : CardRank.values()){
            
                Card tc = new Card(s, r);
                deck.add(tc);
            }
        
        }
        
        size = deck.size();
    
    }
    
    public ArrayList<Card> getDeck(){
        return deck;
    
    }
    
    public void shuffleDeck(){
    
        Random rand = new Random();
        ArrayList<Integer> sortedIxs = new ArrayList<>();
        ArrayList<Integer> randomIxs = new ArrayList<>();
        ArrayList<Card> newDeck = new ArrayList<>();
        
        for(int i = 0; i < deck.size(); i++){
            sortedIxs.add(i);
            newDeck.add(null);
        }
        
        while(randomIxs.size() < deck.size()){
            
            int rn = rand.nextInt(deck.size());
            
            if(!randomIxs.contains((Integer)rn)){
                randomIxs.add((Integer)rn);
            }
        }
        
        for(int i = 0; i < deck.size(); i++){
            int si = sortedIxs.get(i);
            int ri = randomIxs.get(i);
            
            newDeck.set(ri, deck.get(si));
        }
        
        deck = newDeck;
    }
    
    public void sortDeck(){
        Comparator<Card> cp = new CardComparator();
        deck.sort(cp);
    
    }
    
    public void printDeck(){
        deck.forEach(c -> System.out.println(c.toString()));
    }
    
    public Card dealCard(){
        
        size--;
        return deck.remove(0);
        
        
    }
    
    public int getSize(){
        return size;
    
    }
    
}

