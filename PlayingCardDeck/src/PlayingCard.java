/**
 * Represents a singular playing card in a standard poker deck
 * @author pzbarcea
 */
public class PlayingCard {
	
	/**
	 * Represents a card's suit (hearts, diamonds, clubs, and spades)
	 */
	public enum SUIT {
		HEARTS, DIAMONDS, CLUBS, SPADES;
	}
	
	/**
	 * Represents a card's face value: Ace, 2-10, Jack, Queen, King
	 */
	public enum VALUE {
		ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING;
	}
	
	/**
	 * Represents a card's color: namely red if the card is a heart or diamond, or black if it is a club or spade
	 */
	public enum COLOR { 
		RED, BLACK;
	}
	
	private SUIT cardSuit;
	private VALUE cardValue;
	private COLOR cardColor;
	
	/**
	 * 
	 * @param suit - the suit of the card to be created
	 * @param value - the face value of the card to be created
	 */
	public PlayingCard(SUIT suit, VALUE value) {
		this.cardSuit = suit;
		this.cardValue = value;
		this.cardColor = (this.cardSuit == SUIT.HEARTS || this.cardSuit == SUIT.DIAMONDS) ? COLOR.RED : COLOR.BLACK;
	}
	
	@Override
	public boolean equals(Object o) {
		if (o == this) {
            return true;
        }
		
		if (!(o instanceof PlayingCard)) {
            return false;
        }
		
		PlayingCard pc = (PlayingCard) o;
		
		return pc.cardSuit == this.cardSuit && pc.cardValue == this.cardValue;
	}
	
	@Override
	public String toString() {
		return cardValue + " of " + cardSuit;
	}
	
	@Override
	public int hashCode() {
		return cardSuit.ordinal() * VALUE.values().length + cardValue.ordinal();
	}
}
