/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pokergamegui;

import java.util.Collections;
import java.util.Vector;

/**
 *
 * @authors James Willby, Tom Travell & David Price-Williams, MSc PokerGame coursework 2013
 * 
 * @description
 * The HandEvaulator class is an abstract class which takes a player Hand
 * and then returns a rank from 1 - 7 dependent on the contents of the Hand. 
 * If both player hands have the same rank, HandEvaluator can also be used
 * to return a string specifying which of the two players has won.
 * 
 */

public abstract class HandEvaluator {
    
public static int assessHand(Hand hand){
	   Hand testHand = new Hand();
	   testHand.add(hand.get(0));
	   for(int k = 1; k < hand.size(); k++){
		   testHand.add(hand.get(k));
		   for(int i = k; i-1 >= 0 ;i--){
			   if (testHand.get(i).getValue() < testHand.get(i-1).getValue()){
				   Card card1 = testHand.get(i);
				   Card card2 = testHand.get(i-1);
				   testHand.setElementAt(card2, i);
				   testHand.setElementAt(card1, i-1);
			   }
		   }
	   }
   
	/**
	 * Having created the test hand, we now test against 5 helper methods
	 * which determine whether the Hand contains any of the sets of cards
	 * we are interested in. 
	 *    
	 */
	      
    if (isThereAFour(testHand)) return 6;
    if (isThereAFlush(testHand)) return 5;
    if (isThereAStraight(testHand)) return 4;
    if (isThereAThree(testHand)) return 3;
    if (isThereTwoPair(testHand)) return 2;
    if (isThereAPair(testHand)) return 1;

    return 0;
    
 }

/** Checks for a sequential list of cards*/

 static boolean isThereAStraight(Hand hand){
     
	 if (hand.get(0).getValue() == 2 
			 && hand.get(1).getValue() == 3 
			 && hand.get(2).getValue() == 4 
			 && hand.get(3).getValue() == 5 
			 && hand.get(4).getValue() == 14)
		 return true; /** This takes account of the Ace's ability to be both 1 and the highest ranked card*/
	 
	 for(int x = 0;x < hand.size()-1; x++) /** now we look for a difference of one between sequential cards*/
     {                                     
             if (hand.get(x).getValue()+1 != hand.get(x+1).getValue()) /** if difference is greater than 1, false*/
             return false; 
      }
      return true;
 }

 /** Checks to see if all the Suits are the same*/
 
 static boolean isThereAFlush(Hand hand){  
     for (int x = 1; x < hand.size();x++)
     {
         if (!hand.get(x).getSuit().equals(hand.get(x-1).getSuit()))
             return false;
     }
     return true;
 }

 /** Checks for a four*/
 
 static boolean isThereAFour(Hand hand) {
     for (int z = 0; z < hand.size(); z++){
    	 int count = 0; 
    	 for(int y = 0; y < hand.size() ; y++){
    		 if (hand.get(z).getValue() == hand.get(y).getValue())
    			 count++;
    		 if (count == 4)
    			 return true; // four of a kind
    	 }
     }   
     return false;
}

 /** Checks for a three*/
 
 static boolean isThereAThree(Hand hand) {
     
     for (int x = 0; x < hand.size();x++){
            int count = 0; 
            for(int y=0;y < hand.size();y++)
            {
                 if (hand.get(x).getValue() == hand.get(y).getValue())
                     count++;
                 if (count == 3)
                       return true; // three of a kind
            }}
     return false;
     
 }

 /** Checks for a pair*/
 
 static boolean isThereAPair(Hand hand) {

      for (int x =0; x < hand.size();x++){
            int count = 0; 
            for(int y=0;y < hand.size();y++)
            {
                 if (hand.get(x).getValue() == hand.get(y).getValue())
                     count++;
                 if (count == 2)
                       return true; // a pair
            }}
     return false;
    
 }

 /** Checks for two pair*/
 
 static boolean isThereTwoPair(Hand hand) {
     
     Hand testHand = new Hand();

     for (int x = 0; x < hand.size(); x++){
     for (int y = 0; y < hand.size(); y++){
     if (y != x && hand.get(y).getValue() == hand.get(x).getValue())
         testHand.add(hand.get(y));
     }}
     
     if (testHand.size() == 4)
     return true;
     
     else return false;        
 }
 
 /** This method can be called if no overall winner can be found. It takes
  * two PokerGamePerson objects - the dealer and the player - and returns a string
  * based upon who is winning*/

public static String drawnHand(int rank,PokerGamePerson dealer,PokerGamePerson player){
	
		String dealerreturn = "dealer";
		String playerreturn = "player";
		String drawreturn = "draw";
		
        Hand dealerHand = new Hand();
        dealerHand.add(dealer.getHand().get(0));
        
        /**put both hands in ascending order*/
        
        for(int k = 1; k < dealer.getHand().size(); k++){
        	dealerHand.add(dealer.getHand().get(k));
        	for(int i = k; i-1 >= 0 ;i--){
        		if (dealerHand.get(i).getValue() < dealerHand.get(i-1).getValue()){
        			Card card1 = dealerHand.get(i);
        			Card card2 = dealerHand.get(i-1);
        			dealerHand.setElementAt(card2, i);
        			dealerHand.setElementAt(card1, i-1);
        		}
        	}
        }
    
        Hand playerHand = new Hand();
        playerHand.add(player.getHand().get(0));
        for(int k = 1; k < player.getHand().size(); k++){
        	playerHand.add(player.getHand().get(k));
        	for(int i = k; i-1 >= 0 ;i--){
        		if (playerHand.get(i).getValue() < playerHand.get(i-1).getValue()){   
        			Card card1 = playerHand.get(i);
        			Card card2 = playerHand.get(i-1);
        			playerHand.setElementAt(card2, i);
        			playerHand.setElementAt(card1, i-1);
        		}
        	}
        }
    
        switch(rank)
        {
                case 6:{ 
                     if (playerHand.get(1).getValue() > dealerHand.get(1).getValue())
                    	 return playerreturn;
                     else if (playerHand.get(1).getValue() < dealerHand.get(1).getValue())
                    	 return dealerreturn;
                     else if (playerHand.get(4).getValue() > dealerHand.get(4).getValue())
                    	 return playerreturn;
                     else if (playerHand.get(4).getValue() > dealerHand.get(4).getValue())
                    	 return dealerreturn;
                     else return drawreturn;
                    	}
                
                case 5:{
                    int playerSum = 0;
                    int dealerSum = 0;
                    for (int x = 0; x < playerHand.size();x++)
                        playerSum = playerSum + playerHand.get(x).getValue();
                    for (int x = 0; x < dealerHand.size();x++)
                        dealerSum = dealerSum + dealerHand.get(x).getValue();
                    if (playerSum > dealerSum)
                    	return playerreturn;
                    else if (playerSum < dealerSum)
                    	return dealerreturn;
                    else return drawreturn; 
                    }
                
                case 4:{ 
                	int playerSum = 0;
                    int dealerSum = 0;
                    for (int x = 0; x < playerHand.size();x++)
                        playerSum = playerSum + playerHand.get(x).getValue();
                    for (int x = 0; x < dealerHand.size();x++)
                        dealerSum = dealerSum + dealerHand.get(x).getValue();
                    if (playerSum > dealerSum)
                    	return playerreturn;
                    else if (playerSum < dealerSum)
                    	return dealerreturn;
                    else return drawreturn;
                    }
                
                case 3:{   
                    if (playerHand.get(1).getValue() > dealerHand.get(1).getValue())
                   	 	return playerreturn;
                    else if (playerHand.get(1).getValue() < dealerHand.get(1).getValue())
                   	 	return dealerreturn;
                    else if (playerHand.get(4).getValue() > dealerHand.get(4).getValue())
                    	return playerreturn;
                    else if (playerHand.get(4).getValue() < dealerHand.get(4).getValue())
                    	return dealerreturn;
                    else if (playerHand.get(3).getValue() > dealerHand.get(3).getValue())
                    	return playerreturn;
                    else if (playerHand.get(4).getValue() < dealerHand.get(4).getValue())
                    	return dealerreturn;
                    else return drawreturn;
                    	
                    }
                   	 
                case 2:{
                     int playerPairOne = 0, playerPairTwo = 0;
                     int dealerPairOne = 0, dealerPairTwo = 0;
                     
                     for (int x = 0; x <= playerHand.size()-1;x++){
                    	 for (int y = 0; y <= playerHand.size()-1;y++){
                    		 if (playerHand.get(y).getValue() == playerHand.get(x).getValue() && x != y)
                    			 playerPairOne = playerHand.get(y).getValue();
                    	 }
                    }
                     
                     for (int x = 0; x <= playerHand.size()-1;x++){
                    	 for (int y = 0; y <= playerHand.size()-1;y++){
                    		 if (playerHand.get(y).getValue() == playerHand.get(x).getValue() && x != y && playerHand.get(y).getValue() != playerPairOne)
                    			 if (playerHand.get(y).getValue() > playerPairOne){
                    				 playerPairTwo = playerPairOne;
                    				 playerPairOne = playerHand.get(y).getValue();
                    			 } 
                    			 else playerPairTwo = playerHand.get(y).getValue();  
                    	 }
                     }
                     
                     for (int x = 0; x <= dealerHand.size()-1;x++){
                     	for (int y = 0; y <= dealerHand.size()-1;y++){
                     		if (dealerHand.get(y).getValue() == dealerHand.get(x).getValue() && x != y && dealerHand.get(y).getValue() != dealerPairOne)
                     			dealerPairOne = dealerHand.get(y).getValue();  
                     	}
                     }
                     
                     for (int x = 0; x <= dealerHand.size()-1;x++){
                    	 for (int y = 0; y <= dealerHand.size()-1;y++){
                    		 if (dealerHand.get(y).getValue() == dealerHand.get(x).getValue() && x != y)
                    			 if (dealerHand.get(y).getValue() > dealerPairOne){
                    				 dealerPairTwo = dealerPairOne;
                    				 dealerPairOne = dealerHand.get(y).getValue();
                    			 } 
                    			 else dealerPairTwo = dealerHand.get(y).getValue(); 
                     	}
                    }
                     
                    
                     
                    if (playerPairOne > dealerPairOne)
                         return playerreturn;
                    else if (playerPairOne < dealerPairOne)
                         return dealerreturn;
                	else if (playerPairTwo > dealerPairTwo)
                		 return playerreturn;
                	else if (playerPairTwo < dealerPairTwo)
               		 return dealerreturn;
                	else return drawnHand(4, dealer, player);
                			
                }
                
                case 1:{
                    int dealerPair = 0;
                    int playerPair = 0;

                    for (int x = 0; x <= playerHand.size()-1 ;x++){
                   	 for (int y = 0; y <= playerHand.size()-1;y++){
                   		 if (playerHand.get(y).getValue() == playerHand.get(x).getValue() && x != y)
                   			 playerPair = playerHand.get(y).getValue();
                   	 }
                   }

                    for (int x = 0; x <= dealerHand.size()-1;x++){
                   	 for (int y = 0; y <= dealerHand.size()-1;y++){
                   		 if (dealerHand.get(y).getValue() == dealerHand.get(x).getValue() && x != y)
                   			 dealerPair = dealerHand.get(y).getValue();
                   	 }
                   }

                   if (dealerPair > playerPair)
                   	 return dealerreturn;
                   else if (dealerPair < playerPair)
                   	 return playerreturn;
                   else {

                   	Vector<Card> dealernonpairs = new Vector<Card>();
                   	Vector<Card> playernonpairs = new Vector<Card>();


	                    for (int x = 0; x <= playerHand.size()-1 ; x++){
	                       	 int count = 0;
	                       	 for (int y = 0; y <= playerHand.size()-1 ;y++){
	                       		 if (playerHand.get(y).getValue() != playerHand.get(x).getValue())
	                       			 count++;
	                       	 	if (count == 3)
	                       	 		playernonpairs.add(playerHand.get(x));
	                       	 }
	                       }


	                    for (int x = 0; x <= dealerHand.size()-1 ; x++){
	                       	 int count = 0;
	                       	 for (int y = 0; y <= dealerHand.size()-1 ;y++){
	                       		 if (dealerHand.get(y).getValue() != dealerHand.get(x).getValue())
	                       			 count++;
	                       	 	if (count == 3)
	                       	 		dealernonpairs.add(dealerHand.get(x));
	                       	 }
	                       }

	                    for (int x = 2 ; x >= 0 ; x--){
	                		if (dealernonpairs.get(x).getValue() > playernonpairs.get(x).getValue())
	                			return dealerreturn;
	                		else if (dealernonpairs.get(x).getValue() < playernonpairs.get(x).getValue())
	                			return playerreturn;
	                		}

	                    return drawreturn;
                   }
               }

                	
                case 0:{
                	
                	                		
                	for (int x = 4 ; x > 0 ; x--){
                		if (dealerHand.get(x).getValue() > playerHand.get(x).getValue())
                			return dealerreturn;
                		else if (dealerHand.get(x).getValue() < playerHand.get(x).getValue())
                			return playerreturn;
                		}
                	
                				
                	return drawreturn;  
                }
                
    
          
        }
   
     return "exception";


}}


