
package javapoker;

import java.util.ArrayList;
import java.util.Random;
import java.util.Comparator;

/**
 * A deck of 52 playing cards.
 * <p>
 * Once cards are removed, they can't be added back in to deck.  A new deck must be initialized to restore removed cards.
 * @author Jan L. Moffett
 */
public class CardDeck {
     
    ArrayList<Card> deck;
    int size;
    
    /**
     * Sole constructor.
     */
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
    
    /**
     * Randomly orders the cards within the deck.
     */
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
    
    /**
     * Sorts the deck in ascending order, from 2 of Clubs, to Ace of Spades.
     */
    public void sortDeck(){
        Comparator<Card> cp = new CardComparator();
        deck.sort(cp);
    
    }
    
    /**
     * Prints the contents of the deck.
     */
    public void printDeck(){
        deck.forEach(c -> System.out.println(c.toString()));
    }
    
    /***
     * Deals a card from the top of the deck.
     * @return  the card in the first position of the deck. 
     */
    public Card dealCard(){
        
        size--;
        return deck.remove(0);
        
        
    }
    
    /**
     * Returns the number of cards in the deck.
     * @return  a number between 0 and 52, inclusive. 
     */
    public int getSize(){
        return size;
    
    }
    
}

