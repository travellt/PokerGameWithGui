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
 * 
 * @description
 * Hand is, in effect, a way of typing a Vector<Card>. Basic Vector operations are
 * overridden and Hand also provides a matched card method 
 * 
 */
public class Hand {
 
    protected Vector<Card> hand = null;

    Hand() { this.hand = new Vector<Card>(); }
    
    public void add(Card e)
    {
        hand.add(e);
    }
    
    public void setElementAt(Card c, int position)
    {
    hand.setElementAt(c, position);
    }
    
    public int size()
    { return hand.size();}
    
    
    public Card get(int position){
       return hand.get(position);
    }
     
    /**
     * The matchedCard method takes a second hand and determines
     * whether the hands contain the same card
     */
    
    
    boolean matchedCard(Hand otherHand){
        
        for(int x = this.hand.size()-1; x > 0 ;x--)
        {
        for(int y = 0; y < otherHand.size();y++)
        {   
            if(this.hand.get(x).equals(otherHand.get(y)))
                return true;
        }
        }
        return false;
    }
}
