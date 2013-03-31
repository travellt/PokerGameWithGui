package pokergamegui;

import java.util.Vector;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author James Willby, Tom Travell & David Price-Williams, MSc PokerGame coursework 2013
 * 
 * @description
 * 
 * The PokerGamePerson provides a common interface for the creation of the players of the game,
 * providing the neccesary method stubs.
 * 
 */
public interface PokerGamePerson {
  
	/**
	 * This method allows the PokerGamePerson to take a card
	 */
	
     public void takeCard(Card cr);
     
     /**
      * This method asks the PokerGamePerson to evaluate their current hand
      * and return an array of int for the positions they wish to change.
      */
     
     public int[] evaluateTheHand();
     
     /**
      * returns the players hand
      */
     
     public Hand getHand();
     
     /**
      * This method works in conjunction with the int array returned from evaluateTheHand().
      * The player is passed an instance of the Deck and replaces the cards at the indicated positions
      */
     public void swapCards(int[] positions, Deck deck);
     
     /**
      * Takes a Vector of Card and returns an array of int. This array is based on the position of the cards
      * in the vector within the player or dealer Hand.
      */
     
     public int[] CardsToArray(Vector<Card> throwCards);
}
