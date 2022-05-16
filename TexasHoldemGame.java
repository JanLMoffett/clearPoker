
package javapoker;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * A game of Texas Holdem poker.
 * @author Jan L. Moffett
 */
public class TexasHoldemGame {
    
    private CardDeck deck;
    
    private ArrayList<Card> flop;
    private Card turn;
    private Card river;
    
    private TexasHoldemPlayer player1;
    private TexasHoldemPlayer player2;
    private TexasHoldemPlayer player3;
    private TexasHoldemPlayer player4;
    private TexasHoldemPlayer player5;
    
    private ArrayList<TexasHoldemPlayer> players;
    
    /**
     * Sole constructor.
     */
    public TexasHoldemGame(){
        
        deck = new CardDeck();
        deck.shuffleDeck();
        
        player1 = new TexasHoldemPlayer("Player 1", deck.dealCard(), deck.dealCard());
        player2 = new TexasHoldemPlayer("Player 2", deck.dealCard(), deck.dealCard());
        player3 = new TexasHoldemPlayer("Player 3", deck.dealCard(), deck.dealCard());
        player4 = new TexasHoldemPlayer("Player 4", deck.dealCard(), deck.dealCard());
        player5 = new TexasHoldemPlayer("Player 5", deck.dealCard(), deck.dealCard());
        
        players = new ArrayList<>();
        players.add(player1);
        players.add(player2);
        players.add(player3);
        players.add(player4);
        players.add(player5);
        
        flop = new ArrayList<>();
        for(int i = 0; i<3; i++){
            flop.add(deck.dealCard());
        }
         
        turn = deck.dealCard();
        river = deck.dealCard();
        
    }
    
    /**
     * Prints each player's hand and the results of the game.
     */
    public void printGame(){
    
        System.out.print("Player 1: ");
        player1.printPlayer();
        player1.printEval();
        System.out.println();
        
        System.out.print("Player 2: ");
        player2.printPlayer();
        player2.printEval();
        System.out.println();
        
        System.out.print("Player 3: ");
        player3.printPlayer();
        player3.printEval();
        System.out.println();
        
        System.out.print("Player 4: ");
        player4.printPlayer();
        player4.printEval();
        System.out.println();
        
        System.out.print("Player 5: ");
        player5.printPlayer();
        player5.printEval();
        System.out.println();
    
    }
    
    /**
     * Returns a player.
     * @param playerNum a number between 1 and 5.
     * @return  the player identified by playerNum.
     */
    public TexasHoldemPlayer getPlayer(int playerNum){
    
        switch(playerNum){
            case 1: return player1;
            case 2: return player2;
            case 3: return player3;
            case 4: return player4;
            case 5: return player5;
            default: System.out.println("Invalid player number.  Enter 1-5.");
                return null;
            
        }
    }
    
    /**
     * Returns the Flop, the first public card dealt after the initial deal.
     * @return  a card from the top of the deck. 
     */
    public ArrayList<Card> getFlop(){
        return flop;
    
    }
    
    /**
     * Returns the Turn, the second public card dealt.
     * @return  a card from the top of the deck.
     */
    public Card getTurn(){
        return turn;
    }
    
    /**
     * Returns the River, the third and final public card dealt.
     * @return  a card from the top of the deck. 
     */
    public Card getRiver(){
        return river;
    }
    
    /**
     * Evaluates each player's hand with public cards included.
     */
    public void evaluatePlayers(){
        
        for(TexasHoldemPlayer p : players){
            p.addFlop(flop);
            p.addTurn(turn);
            p.addRiver(river);
            p.evaluateHand();
            
        }
        
    }
    
    /**
     * Evaluates each player's hand with public cards included.
     * @return  an ArrayList of player hand evaluations. 
     */
    public ArrayList<String> evaluatePlayersSim(){
        
        ArrayList<String> results = new ArrayList<>();
        
        for(TexasHoldemPlayer p : players){
            p.addFlop(flop);
            p.addTurn(turn);
            p.addRiver(river);
            results.add(p.evaluateHand());
            
        }
        return results;
    }
    
    /**
     * Sorts players based on the value of their hand.
     */
    public void sortPlayers(){
        Comparator<TexasHoldemPlayer> cp = new PlayerComparator();
        players.sort(cp);
        
    }
    
    /**
     * Returns the winning player.
     * @return  the player with the most valuable hand at the end of the game.
     */
    public TexasHoldemPlayer getWinner(){
        sortPlayers();
        return players.get(players.size()-1);
    
    }
    
    
}
