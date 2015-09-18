package blackjack_mk1;

import java.util.Scanner;

public class UI {
	private static Scanner keyboard = new Scanner(System.in);

	//true if hits
	//false if hits and busts or stands or blackjack
	public static boolean prompt(Player player, Player dealer, Shoe shoe){
		if(player.getStrength() == 21 && player.getHand().size() == 2)
			return false;
		System.out.println("Hit or Stand?");
		String choice = keyboard.nextLine();
		
		if(choice.equalsIgnoreCase("Hit")){
			player.hit(shoe);
			
			if(player.getStrength() > 21){
				System.out.println("Player hand: " + player.getHand());
				System.out.println("Player Busts");
				return false;
			}
		}
		else if(choice.equalsIgnoreCase("Stand")){
			dealersTurn(dealer, shoe);
			return false;
		}
		
		return true;
	}
	
	public static void getBet(Player player){
		System.out.println("How much will you bet? (Minimum is 5)");
		player.bet(Double.parseDouble(keyboard.nextLine()));
	}
	
	public static void reveal(Player dealer){
		System.out.println("The dealer's hand was " + dealer.getHand());
	}
	
	public static void dealersTurn(Player dealer, Shoe shoe){
		while(dealer.getStrength() < 17)
			dealer.hit(shoe);
	}
	
	public static boolean again(){
		System.out.println("Would you like to go again? (Yes/No)");
		if(keyboard.nextLine().equalsIgnoreCase("Yes"))
			return true;
		return false;
	}
	
	public static void printMoney(Player player){
		System.out.println("\nPlayer's money: " + player.getMoney());
	}
	
	public static void whoWon(Player player, Player dealer){
		if(player.getStrength() == 21 && player.getHand().size() == 2){
			player.blackjack();
			System.out.println("Player got blackjack");
		}
		else if(player.getStrength() > 21){
			player.lose();
			System.out.println("Player busted and lost");
		}
		else if(dealer.getStrength() > 21){
			player.win();
			System.out.println("Dealer busted and Player won");
		}
		else if(player.getStrength() > dealer.getStrength()){
			player.win();
			System.out.println("Player beat the dealer and won");
		}
		else if(player.getStrength() == dealer.getStrength()){
			player.push();
			System.out.println("Player and dealer tied");
		}
		else{
			player.lose();
			System.out.println("Dealer beat the Player and the Player lost");
		}
		reveal(dealer);
	}
	
	public static void displayHands(Player player, Player dealer){
		System.out.println("Player hand: " + player.getHand());
		System.out.println("Dealer hand: [" + dealer.getHand().get(0) + ", ?]");
	}
}
