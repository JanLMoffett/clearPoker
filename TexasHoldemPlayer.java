
package javapoker;

import java.util.ArrayList;

public class TexasHoldemPlayer {
    private final String playerName;
    private CardHand playerHand;
    
    boolean straight;
    boolean flush;
    boolean straightFlush;
    boolean royalFlush;
    boolean fullHouse;
    boolean fourOfAKind;
    boolean threeOfAKind;
    boolean twoPair;
    boolean pair;
    
    
    public TexasHoldemPlayer(String name, Card card1, Card card2){
        playerName = name;
        playerHand = new CardHand(card1, card2);
        
        straight = false;
        flush = false;
        straightFlush = false;
        royalFlush = false;
        fullHouse = false;
        fourOfAKind = false;
        threeOfAKind = false;
        pair = false;
        twoPair = false;
    }
    
    public String getName(){
        return playerName;
        
    }
    
    public Card getCard1(){
        return playerHand.getHand().get(0);
    }
    
    public Card getCard2(){
        return playerHand.getHand().get(1);
    }
    
    public void printPlayer(){
        System.out.println(playerName);
        playerHand.printHand();
    
    }
    
    public void setHoleHand(Card card1, Card card2){
        playerHand = new CardHand(card1, card2);
    
    }
    
    public void addFlop(ArrayList<Card> flop){
        flop.forEach(c -> playerHand.addCard(c));
        
    }
    
    public void addTurn(Card turn){
        playerHand.addCard(turn);
    
    }
    
    public void addRiver(Card river){
        playerHand.addCard(river);
    }
    
    public String evaluateHand(){
        
        String ret = "";
        
        straight = HandFinder.hasStraight(playerHand);
        flush = HandFinder.hasFlush(playerHand);
        fourOfAKind = HandFinder.hasFourOfAKind(playerHand);
        fullHouse = HandFinder.hasFullHouse(playerHand);
        threeOfAKind = HandFinder.hasThreeOfAKind(playerHand);
        twoPair = HandFinder.hasTwoPair(playerHand);
        pair = HandFinder.hasPair(playerHand);
        
        if(straight || flush){
            ArrayList<Card> straightCards = HandFinder.getStraight(playerHand);
            ArrayList<Card> flushCards = HandFinder.getFlush(playerHand);
            
            if(straight && flush){
                
                straightFlush = HandFinder.hasFlush(new CardHand(straightCards));
                playerHand = new CardHand(straightCards);

                if(straightFlush){
                    Card hc = new CardHand(straightCards).getHighCard();
                    royalFlush = hc.getRank() == CardRank.ACE;
                    
                    if(royalFlush)
                        ret = "royalFlush";
                    else
                        ret = "straightFlush";
                
                }else if(straight){
                    playerHand = new CardHand(straightCards);
                    ret = "straight";
            
                }else{
                    playerHand = new CardHand(flushCards);
                    ret = "flush";
            }
                
            }else if(straight){
                playerHand = new CardHand(straightCards);
                ret = "straight";
            
            }else{
                playerHand = new CardHand(flushCards);
                ret = "flush";
            }
            
        }else if(fullHouse){
            playerHand = new CardHand(HandFinder.getFullHouse(playerHand));
            ret = "fullHouse";
        
        }else if(fourOfAKind){
            ArrayList<Card> fourCards = HandFinder.getFourOfAKind(playerHand);
            fourCards.forEach(c -> playerHand.removeCard(c));
            fourCards.add(playerHand.getHighCard());
            playerHand = new CardHand(fourCards);
            ret = "fourOfAKind";
        
        }else if(threeOfAKind){
            ArrayList<Card> threeCards = HandFinder.getThreeOfAKind(playerHand);
            threeCards.forEach(c -> playerHand.removeCard(c));
            threeCards.add(playerHand.getHighCard());
            playerHand.removeCard(playerHand.getHighCard());
            threeCards.add(playerHand.getHighCard());
            playerHand = new CardHand(threeCards);
            ret = "threeOfAKind";
        
        }else if(twoPair){
            ArrayList<Card> pairs = HandFinder.getPairs(playerHand);
            pairs.forEach(c -> playerHand.removeCard(c));
            pairs.add(playerHand.getHighCard());
            playerHand = new CardHand(pairs);
            ret = "twoPair";
            
        }else if(pair){
            ArrayList<Card> pairCards = HandFinder.getPairs(playerHand);
            pairCards.forEach(c -> playerHand.removeCard(c));
            
            for(int i = 0; i < 3; i++){
                Card hc = playerHand.getHighCard();
                playerHand.removeCard(hc);
                pairCards.add(hc);
            
            }
            
            playerHand = new CardHand(pairCards);
            ret = "pair";
            
        
        }else{
            playerHand.sortHand();
            ArrayList<Card> ph = playerHand.getHand();
            ph.remove(0);
            ph.remove(0);
            playerHand = new CardHand(ph);
            ret = "highCard";
        }
        
        return ret;
        
    }
    
    public void printEval(){
    
        System.out.println("Result: " + getResult());
        System.out.println("Score: " + getScore());
        
        
    }
    
    public String getResult(){
        
        if(royalFlush)
            return "Royal Flush";
        else if(straightFlush)
            return "Straight Flush";
        else if(fourOfAKind)
            return "Four of a Kind";
        else if(fullHouse)
            return "Full House";
        else if(flush)
            return "Flush";
        else if(straight)
            return "Straight";
        else if(threeOfAKind)
            return "Three of a Kind";
        else if(twoPair)
            return "Two Pair";
        else if(pair)
            return "Pair";
        else 
            return "High Card " + playerHand.getHighCard();
        
    }
    
    public int getScore(){
        
        if(royalFlush)
            return playerHand.getHashScore() + 10000;
        else if(straightFlush)
            return playerHand.getHashScore() + 9000;
        else if(fourOfAKind)
            return playerHand.getHashScore() + 8000;
        else if(fullHouse)
            return playerHand.getHashScore() + 7000;
        else if(flush)
            return playerHand.getHashScore() + 6000;
        else if(straight)
            return playerHand.getHashScore() + 5000;
        else if(threeOfAKind)
            return playerHand.getHashScore() + 4000;
        else if(twoPair)
            return playerHand.getHashScore() + 2000;
        else if(pair)
            return playerHand.getHashScore() + 1000;
        else 
            return playerHand.getHashScore();
        
    }
    
    
    
}
