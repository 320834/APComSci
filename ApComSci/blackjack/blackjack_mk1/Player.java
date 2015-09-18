package blackjack_mk1;

import java.util.ArrayList;

public class Player {
	private ArrayList<Card> hand  = new ArrayList<Card>();
	private double money = 0, bet = 0;
	
	public Player(double m){
		money = m;
	}
	
	public void bet(double b){
		final int MINIMUM_BET = 5;
		if(b >= MINIMUM_BET)
			bet = b;
		else
			bet = 5;
	}
	
	public void blackjack(){
		money += (1.5) * bet;
	}
	
	public void lose(){
		money -= bet;
	}
	
	public double getMoney(){
		return money;
	}
	
	public void win(){
		money += bet;
	}
	
	public void resetHand(){
		hand = new ArrayList<Card>();
	}
	public void push(){
		//nothing happeneds
	}
	
	public void deal(Shoe shoe){
		hand = new ArrayList<Card>();
		hit(shoe);
		hit(shoe);
	}
	
	public void hit(Shoe shoe){
		hand.add(shoe.getCard());
	}
	
	public ArrayList<Card> getHand(){
		return hand;
	}
		
	public int getStrength(){
		int numberOfAces = 0, sum = 0;
		for(Card card : hand){
			sum += card.numberValue();
			if(card.numberValue() == 11)
				numberOfAces++;
		}
		while(numberOfAces > 0 && sum > 21){
			sum -= 10;
			numberOfAces--;
		}
		
		return sum;
	}
}