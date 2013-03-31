package pokergamegui;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import pokergamegui.Card;
import static org.junit.Assert.*;

/**
 *
 * @author jameswillby
 */
public class CardTest {
    
    public CardTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of setSuite method, of class Card.
     */
    @Test
    public void testSetSuite() {
        String expectedSuite = "Hearts";
        String actualSuite = "";
        Card instance = new Card("Clubs",3);
        instance.setSuit("Hearts");
        actualSuite = instance.getSuit();
      assertEquals("Not the same suite",actualSuite,expectedSuite);
        
    }

    /**
     * Test of setValue method, of class Card.
     */
    @Test
    public void testSetValue() {
        int expectedValue = 10;
        int actualValue;
        Card instance = new Card("Clubs",3);
        instance.setValue(10);
        actualValue = instance.getValue();
      assertEquals("Not the same suite",actualValue,expectedValue);
        
    }

    /**
     * Test of getSuite method, of class Card.
     */
    @Test
    public void testGetSuite() {
        Card instance = new Card("Hearts",10);
        String expResult = "Hearts";
        String result = instance.getSuit();
        assertEquals(expResult, result);
      
    }


    /**
     * Test of getValue method, of class Card.
     */
    @Test
    public void testGetValue() {
        Card instance = new Card("Hearts",10);
        int expResult = 10;
        int result = instance.getValue();
        assertEquals(expResult, result);
    }
}
