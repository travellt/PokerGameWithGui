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
        setCards(new Hand());
    }
       
    @Override
    public void takeCard(Card cr) {
        getCards().add(cr);
    }

    @Override
    public int[] evaluateTheHand() {
        
    	int[] x = new int[0];
    	return x;   
    }
    
    @Override
    public void swapCards(int[] positions, Deck deck) {
    	
    	for (int i = 0; i < positions.length; i++){
    		getCards().setElementAt(deck.returnTheTopCard(), positions[i]);
    		}   	
    }  

    @Override
    public Hand getHand() {
       return getCards();
    }

    @Override
	public int[] CardsToArray(Vector<Card> throwCards) {
		
		return new int[0];
	}

	public Hand getCards() {
		return cards;
	}

	public void setCards(Hand cards) {
		this.cards = cards;
	}
}
