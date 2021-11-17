import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

/**
 * Represents a standard deck of 52 poker-style playing cards
 * @author paulz
 */
public class CardDeck {
	private ArrayList<PlayingCard> deck;
	private HashSet<PlayingCard> cardsDealt;
	
	public CardDeck() {
		deck = new ArrayList<PlayingCard>();
		cardsDealt = new HashSet<PlayingCard>();
		
		for(PlayingCard.SUIT suit : PlayingCard.SUIT.values()) {
			for(PlayingCard.VALUE value: PlayingCard.VALUE.values()) {
				deck.add(new PlayingCard(suit, value));
			}
		}
	}
	
	/**
	 * Randomly permutes the order of the playing cards in the deck </br>
	 * Default number of swaps is 52.
	 */
	public void shuffle() {
		shuffle(52);
	}
	
	/**
	 * Randomly permutes the order of the playing cards in the deck, using the number of swaps specified </br>
	 * @param numberOfSwaps - the number of random swaps to make. More swaps will result in more complete shuffling
	 */
	public void shuffle(int numberOfSwaps) {
		Random rand = new Random();
		
		for(int i = 0; i < numberOfSwaps; i++) {
			int firstPosition = rand.nextInt(deck.size());
			int secondPosition = rand.nextInt(deck.size());
			
			swap(firstPosition, secondPosition);
		}
	}
	
	private void swap(int i, int j) {
		PlayingCard temp = deck.get(i);
		deck.set(i, deck.get(j));
		deck.set(j, temp);
	}
	
	/**
	 * Deals a card from the deck.
	 * @return the {@link PlayingCard} from the top of the deck, or {@link null} if no cards are left in the deck
	 */
	public PlayingCard dealOneCard() {
		if(deck.size() == 0) {
			return null;
		}
		
		PlayingCard toReturn = deck.remove(deck.size() - 1);
		cardsDealt.add(toReturn);
			
		return toReturn;
	}
	
	
	/**
	 * Provides functionality to return a card back into the deck
	 * @param card - the {@link PlayingCard} to return to the deck
	 * @return - {@link true} if card was successfully returned to the deck, {@link false} otherwise
	 */
	public boolean returnCardToDeck(PlayingCard card) {
		//Cannot return card to the deck if it was never dealt
		if(!cardsDealt.contains(card)) {
			return false;
		}
		
		cardsDealt.remove(card);
		deck.add(card);
		return true;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		String prefix = "";
		
		sb.append('[');
		for(int i = 0; i < deck.size(); i++) {
			sb.append(prefix);
			prefix = ",";
			
			sb.append(deck.get(i).toString());
		}
		
		sb.append(']');
		return sb.toString();
	}
}
