/**
 * 
 */

/**
 * @author pad
 *
 */
public class Card {

	//Rank and suit of the card.
	int rank = 0;
	int suit = 0;
	
	
	public Card() {
		// TODO Auto-generated constructor stub
	}//Card()
	
	public Card(int r, int s){
		rank = r;
		suit = s;
		
	}//Card()

	public boolean rankIsLessThan(Card c){
		boolean rankIsLess = false;
		
		if(rank < c.getRank()){
			rankIsLess = true;
		}//if
		
		return rankIsLess;
		
	}//rankIsLessThan()
	
	public boolean rankIsGreaterThan(Card c){
		boolean rankIsGreater = false;
	
		if(rank > c.getRank()){
			rankIsGreater = true;
		}//if
		
		return rankIsGreater;
		
	}//rankIsGreaterThan()
	
	public boolean rankIsEqualTo(Card c){
		boolean rankIsEqualTo = false;
		
		if(rank == c.getRank()){
			rankIsEqualTo = true;
		}
		else{
			rankIsEqualTo = false;
		}
			
		return rankIsEqualTo;
		
	}//rankIsEqualTo()
	
	
	public String toString(){
		
		String cardSuit = "";
		String cardRank = "";
		String cardString;
		
		int cs = getSuit();
		int cr = getRank();
		
		//Just debugging...
		//System.out.println("To string: cs is " + cs + " cr is " + cr);
		
		
		switch (cs){
		case 0:
			cardSuit = "hearts";
			break;
		case 1:
			cardSuit = "diamonds";
			break;
		case 2:
			cardSuit = "clubs";
			break;
		case 3:
			cardSuit = "spades";
			break;
		default:
			cardSuit = "n/a";
			break;
			
		}//switch suit
		
		
		switch(cr){
		case 1:
			cardRank = "ace";
			break;
		case 2:
			cardRank = "2";
			break;
		case 3:
			cardRank = "3";
			break;
		case 4:
			cardRank = "4";
			break;
		case 5:
			cardRank = "5";
			break;
		case 6:
			cardRank = "6";
			break;
		case 7:
			cardRank = "7";
			break;
		case 8:
			cardRank = "8";
			break;
		case 9:
			cardRank = "9";
			break;
		case 10:
			cardRank = "10";
			break;
		case 11:
			cardRank = "jack";
			break;
		case 12:
			cardRank = "queen";
			break;
		case 13:
			cardRank = "king";
			break;
		default:
			cardRank = "n/a";
			break;
		}//switch rank
		
		cardString = cardRank + "_of_" + cardSuit;
				
		return cardString;
		}//toString()
	
	
	public int getRank(){
		return rank;
	}//getRank()
	
	public int getSuit(){
		return suit;		
	}//getSuit()
	
	
	
}//class