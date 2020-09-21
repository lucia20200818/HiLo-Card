import java.util.Random;
public class DeckOfCards {
	Card[] deck ;
	
	int used = 0;
	int cardCount = 0;// how mamny card has been created so far
	int[] rank = new int[13];
	int[] suit = new int[4];
	public DeckOfCards() {
		//array that will hold 52 cards
		//populate the array.
		deck = new Card[52];
				
		for(int i = 0; i < suit.length; i++) {
			
			for(int j = 1; j <= rank.length; j++) {
				deck[cardCount] = new Card(j,i);
				cardCount++;
			}
		}
		shuffle();
	}
	public void printCard() {
		for(int i = 0; i < deck.length; i++) {
			System.out.println(deck[i].toString());
		}
	}
	/**
	 * This method will shuffle the deck of cards
	 */
	public void shuffle() {// shuffle created deck in random order
		Card temp;
		Random rand = new Random();
		for(int i = 0; i < deck.length; i++) {
			int randNum = rand.nextInt(51);
			temp = deck[randNum];
			deck[randNum] = deck[i];
			deck[i] = temp;
		}
		System.out.println("Userd Card Count = " + used);
		used = 0;
		System.out.println("Userd Card Count after shuffle = " + used);
	}
	/**
	 * This method will "deal" the top card off the deck
	 */
	public Card dealTopCard() {
		Card card = null;
		if(used > 51) {
			card = new Card(-1, -1);
		} else {
			card = deck[used];
			used++;
		}
		
		return card;
	}
	
	
	


}
