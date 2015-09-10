import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;

public class Blackjack {
	
		 static Hand Player = new Hand (52); 
		 static Hand Dealer = new Hand (52); 
		 static Scanner scan = new Scanner (System.in); 
		
	public static void main (String [] args){
		int anotherCard = 0;
		int playAgain = 0;
		int wins = 0;
		int losses = 0;
		int ties = 0;
		
		//begin the game!
		System.out.println("Welcome to the game of BlackJack!!");	
	    System.out.println("Lets Play Blackjack!!"); 
	    
	    //game loop to repeat as long as player wishes to continue playing
	    do {
	    
	    Player.add(RandomCard());
		Player.add(RandomCard());
		DealerHand();
		System.out.println("Your hand is: ");
		System.out.println("******************************");
//		Player.sortHand();
		Player.print();
		System.out.println("******************************");
	    
		System.out.println("Enter 1 for another card or 0 to stop: ");
	    anotherCard = scan.nextInt();
		
		while (anotherCard == 1){
			Player.add(RandomCard());
			System.out.println("Your hand is: ");
			System.out.println("******************************");  	
			Player.print();
			System.out.println("******************************"); 
			System.out.println("Enter 1 for another card or 0 to stop: "); 
			anotherCard = scan.nextInt();
		}
		
		//win or loss statements
				if (Player.sumOfCards() == 21) {
					System.out.println("You got Blackjack...you win!!");
					wins++;
					}
				
				else if ((Player.sumOfCards()) > Dealer.sumOfCards() && (Player.sumOfCards() < 22)) {
					System.out.println("Your hand beats the Dealer's...you win!!");
					wins++;
					}
				
				else if ((Player.sumOfCards() < 22) && (Dealer.sumOfCards() > 21)) {
					System.out.println("Dealer bust...you win!!");
					wins++;
					}
		
				else if ((Player.sumOfCards() > 21) && (Dealer.sumOfCards() < 22)) {
					System.out.println("Bust...you lose!!");	
					losses++;
					}
				
				else if ((Dealer.sumOfCards() > Player.sumOfCards()) && (Dealer.sumOfCards() < 22)) {
					System.out.println("Dealer's hand beats yours...you lose!!");
					losses++;
				}
		
				else {
					System.out.println("It's a tie!!");
					ties++;
					}
				
				System.out.println("Dealer's final hand is ");
				System.out.println("******************************");
				Dealer.print();
				System.out.println("******************************");
				System.out.println("Your final hand is ");
				System.out.println("******************************");
				Player.print();
				System.out.println("******************************");
				System.out.println("Dealer Value: " + Dealer.sumOfCards());
				System.out.println("Your Value: " + Player.sumOfCards());
	
		
		System.out.println("Would you like to play again? (1) yes or (0) no"); 
		playAgain = scan.nextInt(); 
		Player.empty();
		Dealer.empty();
		
		
	} while (playAgain == 1);
	    
	    System.out.println("You have: " +wins+ " wins, " +losses+ " losses, and " +ties+ " ties!");
	    System.out.println("Goodbye!");
	    scan.close(); 
}
	
	//method to hold the dealer hand & determine if more cards should be dealt to dealer
	public static void DealerHand() {
		
		Dealer.add(RandomCard()); 
		Dealer.add(RandomCard());
		
		do {
			Dealer.add(RandomCard());
		}while (Dealer.sumOfCards() <= 11);
		
//		Dealer.sortHand();
		
	}
	
	//method for drawing a random card
	public static Card RandomCard(){ 
		
		Random rand = new Random ();
		int CardNum = rand.nextInt(51); 
		Card NewCard = new Card (CardNum); 
	
		return NewCard; 		
	}	
	
}
