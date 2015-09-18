package blackjack_mk1;

public class Card {
	private String suit;
	private String value;
	
	public Card(String v, String s){
		suit = s;
		value = v;
	}
	
	public String getValue(){
		return value;
	}
	
	public String getSuit(){
		return suit;
	}
	
	public String toString(){
		return value + " of " + suit;
	}
	
	public int numberValue(){
		if(value.equalsIgnoreCase("ACE"))
			return 11;
		else 
			try {
				return Integer.parseInt(value);
			} catch (NumberFormatException e) {
				return 10;
			}
	}
}
