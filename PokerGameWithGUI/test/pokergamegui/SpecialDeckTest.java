package pokergamegui;

import static org.junit.Assert.*;

import org.junit.Test;

import pokergamegui.SpecialDeck;


public class SpecialDeckTest {

	@Test
	public void test() {
		TestHand myhand = new TestHand("highcard");
		
		SpecialDeck classUnderTest = new SpecialDeck(myhand);
		assertEquals("not the right size", 47, classUnderTest.cardsInDeck());
		
	}
	
	

}
