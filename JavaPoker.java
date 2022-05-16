
package javapoker;

import java.util.ArrayList;


/**
 * The class containing the main method of the javapoker package.
 * @author Jan L. Moffett
 */
public class JavaPoker {

    
    public static void main(String[] args) {
        
        runGame();
        
    }
    
    /**
     * Simulates the sequence of events in a Texas Holdem poker game.
     * @return  A verbal description of the results of the game at each step. 
     */
    public static ArrayList<String> simulateGame(){
        
        TexasHoldemGame g = new TexasHoldemGame();
        ArrayList<String> results = g.evaluatePlayersSim();
        //results.forEach(s -> resultMap.put(s, resultMap.get(s)+1));
        //System.out.println(results);
        return results;
        
    }
    
    /**
     * Runs the mechanics of a Texas Holdem poker game and prints the results.
     */
    public static void runGame(){
        
        TexasHoldemGame g = new TexasHoldemGame();
        
        TexasHoldemPlayer p1 = g.getPlayer(1);
        Card p1c1 = p1.getCard1();
        Card p1c2 = p1.getCard2();
        System.out.println("Player1 Card1: " + p1c1);
        System.out.println("Player1 Card2: " + p1c2);
        System.out.println();
        
        TexasHoldemPlayer p2 = g.getPlayer(2);
        Card p2c1 = p2.getCard1();
        Card p2c2 = p2.getCard2();
        System.out.println("Player2 Card1: " + p2c1);
        System.out.println("Player2 Card2: " + p2c2);
        System.out.println();
        
        TexasHoldemPlayer p3 = g.getPlayer(3);
        Card p3c1 = p3.getCard1();
        Card p3c2 = p3.getCard2();
        System.out.println("Player3 Card1: " + p3c1);
        System.out.println("Player3 Card2: " + p3c2);
        System.out.println();
        
        TexasHoldemPlayer p4 = g.getPlayer(4);
        Card p4c1 = p4.getCard1();
        Card p4c2 = p4.getCard2();
        System.out.println("Player4 Card1: " + p4c1);
        System.out.println("Player4 Card2: " + p4c2);
        System.out.println();
        
        TexasHoldemPlayer p5 = g.getPlayer(5);
        Card p5c1 = p5.getCard1();
        Card p5c2 = p5.getCard2();
        System.out.println("Player5 Card1: " + p5c1);
        System.out.println("Player5 Card2: " + p5c2);
        System.out.println();
        
        ArrayList<Card> flop = g.getFlop();
        Card fc1 = flop.get(0);
        Card fc2 = flop.get(1);
        Card fc3 = flop.get(2);
        System.out.println("Flop Card1: " + fc1);
        System.out.println("Flop Card2: " + fc2);
        System.out.println("Flop Card3: " + fc3);
        System.out.println();
        
        Card turn = g.getTurn();
        System.out.println("Turn Card: " + turn);
        System.out.println();
        
        Card river = g.getRiver();
        System.out.println("River Card: " + river);
        System.out.println();
        
        
        
        
    }
    
    /**
     * Generates a path to the image file representing the card.
     * @param card  a playing card.
     * @return  a file path i.e. "images/diamonds_02.jpg" 
     */
    public static String cardToImage(Card card){
        return ("images/" + card.getSuit() + "_" + card.getRank() + ".jpg").toLowerCase();
        
    
    }
    
    /**
     * Deals seven cards from a randomly ordered deck.
     * @param deck  a deck of cards.
     * @return  an array of seven cards. 
     */
    public static Card[] dealSeven(CardDeck deck){
        Card[] hand = new Card[7];
        
        for(int i = 0; i < 7; i++){
            hand[i] = deck.dealCard();
        }
        
        return hand;
    
    }
    
    /**
     * Builds an array of cards out of an array of suits and an array of ranks.
     * @param suits an array of card suits, must be the same length as ranks.
     * @param ranks an array of card ranks, must be the same length as suits.
     * @return  an array of cards. 
     */
    public static Card[] buildHand(CardSuit[] suits, CardRank[] ranks){
        
        Card[] ret = new Card[suits.length];
        
        if(suits.length >= ranks.length){
            for(int i = 0; i < suits.length; i++){
                Card tc = new Card(suits[i], ranks[i]);
                ret[i] = tc;
            }
        
        }
        
        return ret;
    
    }
    
    
    
}
