/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pokergamegui;
import java.util.Vector;
/**
 *
 *  @authors James Willby, Tom Travell & David Price-Williams, MSc PokerGame coursework 2013
 * 
 *  @description Game creates the players, the deck, assigns players their cards and handles the creation of the GUI. 
 *  It is also responsible for determining the Winner of first round/final round using the HandEvaluator class.
 */
public class Game {
	
    protected Vector<PokerGamePerson> players;
    public PokerGUI gameGui;
    private Deck deck;
    private int playerCount = 0;
    
    /**
     * the default constructor Game() is designed to include a default value of 2 by calling a second constructor
     * and passing it 2. This has been done to get around the problem with Java method contracts not allowing for
     * the use of default values.
     */
    
    public Game()
    {
        this(2);
    }
    
    public Game(int x)
    {
       if (x > 6 || x < 2) 
        {   System.err.println ("Forbidden number of players");
            System.exit(1);
        }
       playerCount = x; 
       init();
    }
  
    public void init(){
    	deck = new Deck();
    	players = new Vector<PokerGamePerson>();
        PokerGamePersonFactory personFactory = new PokerGamePersonFactory();
        PokerGamePerson dealer = personFactory.returnPerson("dealer");
        players.add(dealer);
        
        
        for (int y = 1; y < playerCount;y++)
        {
        PokerGamePerson player = personFactory.returnPerson("player");
        players.add(player);
        }
        
        deck.shuffleTheCards();  /** shuffles deck */
        
        /** deals 5 cards to player and dealer */
        
        for (int z=0; z < 5;z++)
        {
            for (int y = players.size()-1;y >= 0;y--)
            {
            players.get(y).takeCard(deck.returnTheTopCard());
            }
        }
    	
    }
    
    public Deck getDeck(){
    	return deck;    
    }
    
    public void run(){
       
    	gameGui = new PokerGUI(this);
    	gameGui.display();
    	
    }    
    
   public String getWinner() {
	   if (HandEvaluator.assessHand(players.get(0).getHand()) > HandEvaluator.assessHand(players.get(1).getHand()))
		   return "dealer";
	   else if (HandEvaluator.assessHand(players.get(0).getHand()) < HandEvaluator.assessHand(players.get(1).getHand()))
		   return "player";
	   else return HandEvaluator.drawnHand(HandEvaluator.assessHand(players.get(0).getHand()),players.get(0),players.get(1));
   } 
 
 
    public Hand getPlayerHand(int x)
    {
        return players.get(x).getHand();
    }
    
    
    
}
