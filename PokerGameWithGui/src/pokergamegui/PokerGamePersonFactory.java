/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pokergamegui;

/**
 *
 * @authors James Willby, Tom Travell & David Price-Williams, MSc PokerGame coursework 2013
 * 
 * @description
 * The PokerGameFactory is part of a factory pattern to return the correct type of PokerGamePerson.
 * It contains only one public method: returnPerson().
 * 
 */
public class PokerGamePersonFactory {
    
public PokerGamePerson returnPerson(String person){ /** returns a class implementing PokerGamePerson */
       
switch(person){ /** here we call private factory methods based on the supplied string */

    case "dealer" : return getNewDealer(); 
    case "player" : return getNewPlayer();
    default: return null;
}}

    private Dealer getNewDealer() 
    { return new Dealer();}
    
    private Player getNewPlayer()
    { return new Player();}
    
    
}

