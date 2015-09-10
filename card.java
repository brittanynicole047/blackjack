/**
 * A simple playing card represented as a number from 
	0 to 51, inclusive.
	Numbers 0-12 are mapped to the clubs (Ace... King)
	Numbers 13-25 are mapped to diamonds (Ace... King)
	Numbers 26-38 are mapped to hearts (Ace... King)
	Numbers 39-51 are mapped to spades(Ace... King). 
**/
public class Card implements Comparable <Card>{
		
	static final String[] SUITS = {"Clubs", "Diamonds", "Hearts", "Spades"};
	static final String[] FACES = {"Ace", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"};
	private int representation; // the number between 0-51 which represents this card
	
	/**
	 * Constructor: initializes a new card with value of num passed in
		pre: num in [0,51]
		post: self has the given number 
	**/
	public Card(int num)
	{	
		if(num<0 || num > 51)
		{
			System.out.println("Invalid Card Construction");
			System.out.println("A Card should be constructed using an integer from 0 to 51.");
			System.out.println("Constructing this card with a value of 0.");
		
			representation = 0;
		}
		else
		{
			representation = num;
		}
	}
	/**
	 * Returns the suit of this card as a string  from SUITS[]
	 * @return
	 **/
	public String suit()
	{

		int index = representation / 13;
		return SUITS[index];
	}
	
	/**
	 * Returns the face value of this card as a string from FACES[]
	 * @return
	 */
	public String face()
	{
				
		int index = representation % 13;
		return FACES[index];
	}
	
	/**
	 * Returns the number value of this card a value from 1-13
	 * @return
	 */
	public int value()
	{
		int index = representation % 13;
		return index + 1; 
	}
		
	public int getRepresentation(){
		return representation;
	}
	
	public String toString()
	{
		/*Return a string representation of this card*/
		
		return face() + " of " + suit() + " (value =  " + value() + ")";	
	}
	
	public int compareTo (Card anotherCard) {
		if (anotherCard.getRepresentation() < representation) {
			return -1;
		}
		
		else if (anotherCard.getRepresentation() == representation) {
			return 0;
		}
		
		else
			return 1;
	}
	
	//A main function to test the Card Class
	public static void main(String [] args)
	{
		Card [] deck = new Card[52];
		for(int num = 0; num < deck.length; num++)
		{
			deck[num] = new Card(num);
		}
		//Test:
		// should print all clubs in order (ace - king)
		// then all diamonds, then all hearts and then all spades
	
		Card anotherCard = new Card(1);
		
		System.out.println(anotherCard.compareTo(anotherCard));
		for(Card c : deck)  
		{
			System.out.println(c);
			
		}
	}
	
}

	
	
	
