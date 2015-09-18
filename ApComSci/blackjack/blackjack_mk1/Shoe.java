package blackjack_mk1;

import java.util.ArrayList;
import java.util.Random;

public class Shoe {
	private ArrayList<Card> shoe = new ArrayList<Card>();

	public void addDeck(int num){
		for(int i = 0; i < num; i++){
			shoe.add(new Card("ACE", "SPADES"));
			shoe.add(new Card("KING", "SPADES"));
			shoe.add(new Card("QUEEN", "SPADES"));
			shoe.add(new Card("JACK", "SPADES"));
			shoe.add(new Card("10", "SPADES"));
			shoe.add(new Card("9", "SPADES"));
			shoe.add(new Card("8", "SPADES"));
			shoe.add(new Card("7", "SPADES"));
			shoe.add(new Card("6", "SPADES"));
			shoe.add(new Card("5", "SPADES"));
			shoe.add(new Card("4", "SPADES"));
			shoe.add(new Card("3", "SPADES"));
			shoe.add(new Card("2", "SPADES"));
			shoe.add(new Card("ACE", "CLUBS"));
			shoe.add(new Card("KING", "CLUBS"));
			shoe.add(new Card("QUEEN", "CLUBS"));
			shoe.add(new Card("JACK", "CLUBS"));
			shoe.add(new Card("10", "CLUBS"));
			shoe.add(new Card("9", "CLUBS"));
			shoe.add(new Card("8", "CLUBS"));
			shoe.add(new Card("7", "CLUBS"));
			shoe.add(new Card("6", "CLUBS"));
			shoe.add(new Card("5", "CLUBS"));
			shoe.add(new Card("4", "CLUBS"));
			shoe.add(new Card("3", "CLUBS"));
			shoe.add(new Card("2", "CLUBS"));
			shoe.add(new Card("ACE", "HEARTS"));
			shoe.add(new Card("KING", "HEARTS"));
			shoe.add(new Card("QUEEN", "HEARTS"));
			shoe.add(new Card("JACK", "HEARTS"));
			shoe.add(new Card("10", "HEARTS"));
			shoe.add(new Card("9", "HEARTS"));
			shoe.add(new Card("8", "HEARTS"));
			shoe.add(new Card("7", "HEARTS"));
			shoe.add(new Card("6", "HEARTS"));
			shoe.add(new Card("5", "HEARTS"));
			shoe.add(new Card("4", "HEARTS"));
			shoe.add(new Card("3", "HEARTS"));
			shoe.add(new Card("2", "HEARTS"));
			shoe.add(new Card("ACE", "DIAMONDS"));
			shoe.add(new Card("KING", "DIAMONDS"));
			shoe.add(new Card("QUEEN", "DIAMONDS"));
			shoe.add(new Card("JACK", "DIAMONDS"));
			shoe.add(new Card("10", "DIAMONDS"));
			shoe.add(new Card("9", "DIAMONDS"));
			shoe.add(new Card("8", "DIAMONDS"));
			shoe.add(new Card("7", "DIAMONDS"));
			shoe.add(new Card("6", "DIAMONDS"));
			shoe.add(new Card("5", "DIAMONDS"));
			shoe.add(new Card("4", "DIAMONDS"));
			shoe.add(new Card("3", "DIAMONDS"));
			shoe.add(new Card("2", "DIAMONDS"));
		}
	}

	public Card getCard(){
		return shoe.remove(0);
	}
	
	public int size(){
		return shoe.size();
	}
	
	public void shuffle(){
	    int index;
	    Card temp;
	    Random random = new Random();
	    for (int i = shoe.size() - 1; i >= 0; i--)
	    {
	        index = random.nextInt(i + 1);
	        temp = shoe.get(index);
	        shoe.set(index, shoe.get(i));
	        shoe.set(i, temp);
	    }
	}
}
