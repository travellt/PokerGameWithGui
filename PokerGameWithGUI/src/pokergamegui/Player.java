/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pokergamegui;
import java.util.Vector;
/**
 *
 * @authors James Willby, Tom Travell & David Price-Williams, MSc PokerGame coursework 2013
 *  
 * @description The Player is the representation of the user's hand. Player implements the PokerGamePerson method stubs,
 * however with much of the decisions 
 */
class Player implements PokerGamePerson {

    private Hand cards = null;    
    
    public Player()
    {
        cards = new Hand();
    }
       
    @Override
    public void takeCard(Card cr) {
        cards.add(cr);
    }

    @Override
    public int[] evaluateTheHand() {
        
    	int[] x = new int[0];
    	return x;   
    }
    
    @Override
    public void swapCards(int[] positions, Deck deck) {
    	
    	for (int i = 0; i < positions.length; i++){
    		cards.setElementAt(deck.returnTheTopCard(), positions[i]);
    		}   	
    }  

    @Override
    public Hand getHand() {
       return cards;
    }

    @Override
	public int[] CardsToArray(Vector<Card> throwCards) {
		
		return new int[0];
	}
}
