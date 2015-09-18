package blackjack_mk1;

public class Game {
	
	public static void main(String[] args) {
		Shoe shoe = new Shoe();
		shoe.addDeck(6);
		shoe.shuffle();
		Player player = new Player(10000), dealer = new Player(0);
		
		do{
			cycle(player, dealer, shoe);
			player.resetHand();
			dealer.resetHand();

			if(shoe.size()/312.0 < .25){
				shoe = new Shoe();
				shoe.addDeck(6);
				shoe.shuffle();
			}
		}while (UI.again());
		UI.printMoney(player);
	}
	
	public static void cycle(Player player, Player dealer, Shoe shoe){
		UI.printMoney(player);
		UI.getBet(player);
		
		player.hit(shoe);
		player.hit(shoe);
		dealer.hit(shoe);
		dealer.hit(shoe);
		UI.displayHands(player, dealer);
		while(UI.prompt(player, dealer, shoe)){
			UI.displayHands(player, dealer);
		}
		UI.whoWon(player, dealer);

	}
}