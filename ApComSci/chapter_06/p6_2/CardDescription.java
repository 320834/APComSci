package p6_2;

public class CardDescription {
	private String char1, char2, name, suit;
	public CardDescription(String c){
		if(c.length()== 2){
			char1 = c.substring(0,1);
			char2 = c.substring(1);
		}
		else{
			char1 = c.substring(0, 2);
			char2 = c.substring(2);
		}
	}
	public String getDescription(){
		if(char1.equalsIgnoreCase("A"))
			name = "Ace";
		else
			if(char1.equalsIgnoreCase("2"))
				name = "Two";
			else
				if(char1.equalsIgnoreCase("3"))
					name = "Three";
				else
					if(char1.equalsIgnoreCase("4"))
						name = "Four";
					else
						if(char1.equalsIgnoreCase("5"))
							name = "Five";
						else
							if(char1.equalsIgnoreCase("6"))
								name = "Six";
							else
								if(char1.equalsIgnoreCase("7"))
									name = "Seven";
								else
									if(char1.equalsIgnoreCase("8"))
										name = "Eight";
									else
										if(char1.equalsIgnoreCase("9"))
											name = "Nine";
										else
											if(char1.equalsIgnoreCase("10"))
												name = "Ten";
											else
												if(char1.equalsIgnoreCase("J"))
													name = "Jack";
												else
													if(char1.equalsIgnoreCase("Q"))
														name = "Queen";
													else
														if(char1.equalsIgnoreCase("K"))
															name = "King";
		if(char2.equalsIgnoreCase("D"))
			suit = "Diamonds";
		else
			if(char2.equalsIgnoreCase("H"))
				suit = "Hearts";
			else
				if(char2.equalsIgnoreCase("S"))
					suit = "Spades";
				else
					suit = "Clubs";
		return name + " of " + suit;
	}
}
