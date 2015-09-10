import java.util.Arrays;


public class Hand {
	
	Card cards[] = null;
	private final int MAX_CAP = 52;
	public int cap = 0;
	
	//creates new hand array 
	public Hand(int cap) {
		cards = new Card[cap];
	}
	
	//adds a new card to the hand
	public void add(Card c) {
		if (cap < (MAX_CAP)) {
			cards[cap] = c;
			cap++;
			}
			
			else
				System.out.println("Can't add card.  Hand is full!");	
		}
	
	//computes & returns the sum of cards in a hand
	public int sumOfCards() {		
		int sum = 0;				
		for (int i = 0; i < cap; i++) {			
			if(cards[i] != (null)){ 			
			sum = sum + cards[i].value();
			}
		}
		
		return sum;		
	}	
	
	//alternate calculation of cards in a hand
	public int sumOfCards(int aceVal, int faceVal) {
		int sumCards = 0; 
		int Val =0; 
		for (int i = 0; i < cap; i++){
			if(cards[i] != (null)){
			}	
			else if(Val == 10){ 
			  Val = faceVal; 
			}
			else{
				Val = aceVal; 
			}
			sumCards = sumCards + cards[i].value() + Val; 		
		}		
		return sumCards;
	}
	
	//prints the cards in a hand
	public void print() {
		int emptyhand = 0;
		for (int i = 0; i < cap; i++) {
			if (cards[i] == null) {
				emptyhand ++;
			}
	
			else
				System.out.println(cards[i].toString());
		}	
		
		if (emptyhand == cap) {
			System.out.println("Hand is empty!");
		}
	}
	
	//sorts the cards in a hand by value
	public void sortHand() {
		Arrays.sort(cards);
		}
		
	
	//empties the cards in a hand in order to start a new game
	public void empty() {
		for (int i = 0; i < cap; i++) {
			cards[i] = null;
		}	
	}
	
	//main method for testing the methods created
	public static void main (String [] args) {
		
		Card card1 = new Card(1);
		Card card2 = new Card(2);
		Hand hand1 = new Hand(2);
		
		//testing the add method
		//should result in creating a hand of cards
		hand1.add(card1);
		hand1.add(card2);
		
		//testing the sumOfCards method
		//should display the sum of the cards in our temp hand
		System.out.println("sumOfCards " + hand1.sumOfCards());
		
		//testing the sumOfCards method[aceVal & faceVal overload]
		//should display new sum based on the updated values aceVal & faceVal
		System.out.println("sumOfCards overload " + hand1.sumOfCards(15, 10));
		
		//testing the print method
		//should print the cards in our temp hand
		hand1.print();
		
		//testing the sortHand method
		//should print the cards in our temp hand, sorted based on values
		hand1.sortHand();
		hand1.print();
		
		//testing the empty method
		//should clear our temp hand
		hand1.empty();
		hand1.print();
	}
}
