package blackjack;

import java.util.List;

public class CountingPlayer extends BasicPlayer{
	private int runningCount = 0, numCards = 6 * 52;
	private double trueCount;
	
	public void faceUpCard(Card card){
		numCards --;
		
		//This Block is For Zen Count
		if(card.value().numericValue() == 7 || card.value().numericValue() == 2 || card.value().numericValue() == 3)
			runningCount++;
		else if(card.value().numericValue() == 4 || card.value().numericValue() == 5 || card.value().numericValue() == 6)
			runningCount += 2;
		else if(card.value().numericValue() == 8 || card.value().numericValue() == 9)
			runningCount += 0;
		else if(card.value().numericValue() == 10)
			runningCount -= 2;
		else if(card.value() == Value.ACE)
			runningCount -= 1;
		
		//This Block is for Hi - Lo
//		if(card.value().numericValue() <= 6 && card.value().numericValue() >= 2)
//			runningCount++;
//		else if(card.value().numericValue() == 10 || card.value() == Value.ACE)
//			runningCount--;
		
		trueCount = (runningCount / (numCards/52 + 0.5));
	}
	
	public void shuffle(){
		runningCount = 0;
		numCards = 6 * 52;
	}
	
    public String id(){
    	return "Sai Card Counter";
    }
    
	public double bet(double minBet, double maxBet) {
		//Bad Betting Strat
//		final double BET_UNIT = (maxBet - minBet)/12;
//		double bet = minBet;
//		if(trueCount <= 0)
//			bet = minBet + BET_UNIT;
//		else if(trueCount == 1)
//			bet = minBet + (BET_UNIT * 2);
//		else if(trueCount == 2)
//			bet = minBet + (BET_UNIT * 4);
//		else if(trueCount == 3)
//			bet = minBet + (BET_UNIT * 8);
//		else if(trueCount == 4)
//			bet = minBet + (BET_UNIT * 10);
//		else if(trueCount >= 5)
//			bet = minBet + (BET_UNIT * 12);
//		else if(bet > maxBet)
//			bet = maxBet;
//		return bet;
		
		if(trueCount < 4)
			return minBet;
		if(trueCount > 6)
			return maxBet;
		return (maxBet - minBet)/2;
	
	}
	
    public boolean insureHand(List<Card> ownHand, Card dealerUpCard) {
        if(trueCount >= 5)
        	return true;
        return false;
    }
    
    public PlayerAction act(List<Card> ownHand, Card dealerUpCard, List<PlayerAction> allowedActions){
    	//This Block For Ilustrious 18 Hi - Lo
//	   	if((trueCount >= 0 && HandUtilities.value(ownHand) == 16 && dealerUpCard.value().numericValue() == 10) || (trueCount >= 4 && HandUtilities.value(ownHand) == 15 && dealerUpCard.value().numericValue() == 10) || (trueCount >= 5 && HandUtilities.value(ownHand) == 20 && dealerUpCard.value().numericValue() == 5) || (trueCount >= 4 && HandUtilities.value(ownHand) == 20 && dealerUpCard.value().numericValue() == 6) || (trueCount >= 4 && HandUtilities.value(ownHand) == 10 && dealerUpCard.value().numericValue() == 10) || (trueCount >= 2 && HandUtilities.value(ownHand) == 12 && dealerUpCard.value().numericValue() == 3) || (trueCount >= 3 && HandUtilities.value(ownHand) == 12 && dealerUpCard.value().numericValue() == 2) || (trueCount >= 1 && HandUtilities.value(ownHand) == 11 && dealerUpCard.value() == Value.ACE) || (trueCount >= 1 && HandUtilities.value(ownHand) == 9 && dealerUpCard.value().numericValue() == 2) || (trueCount >= 4 && HandUtilities.value(ownHand) == 10 && dealerUpCard.value() == Value.ACE) || (trueCount >= 3 && HandUtilities.value(ownHand) == 9 && dealerUpCard.value().numericValue() == 7) || (trueCount >= 5 && HandUtilities.value(ownHand) == 16 && dealerUpCard.value().numericValue() == 9) || (trueCount >= -1 && HandUtilities.value(ownHand) == 13 && dealerUpCard.value().numericValue() == 2) || (trueCount >= 0 && HandUtilities.value(ownHand) == 12 && dealerUpCard.value().numericValue() == 4) || (trueCount >= -2 && HandUtilities.value(ownHand) == 12 && dealerUpCard.value().numericValue() == 5) || (trueCount >= -1 && HandUtilities.value(ownHand) == 12 && dealerUpCard.value().numericValue() == 6) || (trueCount >= -2 && HandUtilities.value(ownHand) == 13 && dealerUpCard.value().numericValue() == 3)){
//    		if(allowedActions.contains(PlayerAction.DOUBLE))
//    			return PlayerAction.DOUBLE;
//    		else if(allowedActions.contains(PlayerAction.SPLIT))
//    			return PlayerAction.SPLIT;
//    		else
//    			return PlayerAction.STAND;
//    	}
    	
    	return super.act(ownHand, dealerUpCard, allowedActions);
    }
}