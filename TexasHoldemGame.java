/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javapoker;
import java.util.ArrayList;
import java.util.Comparator;
/**
 *
 * @author Jan
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
    
    public ArrayList<Card> getFlop(){
        return flop;
    
    }
    
    public Card getTurn(){
        return turn;
    }
    
    public Card getRiver(){
        return river;
    }
    
    
    public void evaluatePlayers(){
        
        for(TexasHoldemPlayer p : players){
            p.addFlop(flop);
            p.addTurn(turn);
            p.addRiver(river);
            p.evaluateHand();
            
        }
        
    }
    
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
    
    public void sortPlayers(){
        Comparator<TexasHoldemPlayer> cp = new PlayerComparator();
        players.sort(cp);
        
    }
    
    public TexasHoldemPlayer getWinner(){
        sortPlayers();
        return players.get(players.size()-1);
    
    }
    
    
}
