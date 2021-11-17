import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class myTest {

	@Test
	void test_shuffle() {
		CardDeck myDeck = new CardDeck();
		String s1 = myDeck.toString();
		
		myDeck.shuffle();
		String s2 = myDeck.toString();
		
		assertNotEquals(s1, s2);
	}
	
	@Test
	void test_shuffle2() {
		CardDeck myDeck = new CardDeck();
		String s1 = myDeck.toString();
		
		myDeck.shuffle(1000);
		String s2 = myDeck.toString();
		
		assertNotEquals(s1, s2);
	}
	
	@Test
	void deal_Card() {
		CardDeck myDeck = new CardDeck();
		PlayingCard pc = myDeck.dealOneCard();
		
		assertEquals(pc, new PlayingCard(PlayingCard.SUIT.SPADES,PlayingCard.VALUE.KING));
	}
}
