package blackjack;
 
import java.util.List;
 
public class BasicPlayer implements BlackjackPlayer{
 
        @Override
        public void playerIDs(List<String> playerIDs) {
                // TODO Auto-generated method stub
               
        }
 
        @Override
        public void initialBet(int playerIndex, double bet) {
                // TODO Auto-generated method stub
               
        }
 
        @Override
        public void initialBets(List<Double> bets) {
                // TODO Auto-generated method stub
               
        }
 
        @Override
        public void faceUpCard(Card card) {
                // TODO Auto-generated method stub
               
        }
 
        @Override
        public void shuffle() {
                // TODO Auto-generated method stub
               
        }
 
        @Override
        public void insuranceDecision(int playerIndex, List<Card> playersHand,
                        Card dealersUpCard, boolean insuredHand) {
                // TODO Auto-generated method stub
               
        }
 
        @Override
        public void insuranceResult(int playerIndex, double bet,
                        List<Card> playersHand, Card dealersUpCard, boolean insuranceBetWon) {
                // TODO Auto-generated method stub
               
        }
 
        @Override
        public void decision(int playerIndex, List<Card> playersHand,
                        Card dealersUpCard, List<PlayerAction> allowedActions,
                        PlayerAction action) {
                // TODO Auto-generated method stub
               
        }
 
        @Override
        public void result(int playerIndex, double bet, List<Card> playersHand,
                        List<Card> dealersHand, Result result) {
                // TODO Auto-generated method stub
               
        }
 
        @Override
        public String id() {
                // TODO Auto-generated method stub
                return "Sai Basic";
        }
 
        @Override
        public double bet(double minBet, double maxBet) {
                // TODO Auto-generated method stub
                return minBet;
        }
 
        @Override
        public PlayerAction act(List<Card> ownHand, Card dealerUpCard, List<PlayerAction> allowedActions) {            
                //1 = hit
                //2 = stand
                //3 = double or hit
                //4 = Surrender
                //5 = double or stand
                //6 = split
                int[][] splitPreset = {
                                {7, 7, 6, 6, 6, 6, 1, 1, 1, 1},
                                {7, 7, 6, 6, 6, 6, 1, 1, 1, 1},
                                {1, 1, 1, 7, 7, 1, 1, 1, 1, 1},
                                {7, 6, 6, 6, 6, 1, 1, 1, 1, 1},
                                {6, 6, 6, 6, 6, 6, 1, 1, 1, 1},
                                {6, 6, 6, 6, 6, 6, 6, 6, 6, 6},
                                {6, 6, 6, 6, 6, 2, 6, 6, 2, 2},
                                {6, 6, 6, 6, 6, 6, 6, 6, 6, 6},
                };
 
                if(ownHand.size() == 2 && ownHand.get(0).value() == ownHand.get(1).value()){
                        int handValue = HandUtilities.value(ownHand), index = 0, col = 0;
                        if(handValue == 4)
                                index = 0;
                        else if(handValue == 6)
                                index = 1;
                        else if(handValue == 8)
                                index = 2;
                        else if(handValue == 10)
                                return hardAct(ownHand, dealerUpCard, allowedActions);
                        else if(handValue == 12 && ownHand.get(0).value() == Value.N6)
                                index = 3;
                        else if(handValue == 14)
                                index = 4;
                        else if(handValue == 16)
                                index = 5;
                        else if(handValue == 18)
                                index = 6;
                        else if(handValue == 20)
                                return PlayerAction.STAND;
                        else if(handValue == 12){
                                if(allowedActions.contains(PlayerAction.SPLIT))
                                        return PlayerAction.SPLIT;
                                return PlayerAction.STAND;
                        }
                       
                        if(dealerUpCard.value() == Value.N2)
                                col = 0;
                        else if(dealerUpCard.value() == Value.N3)
                                col = 1;
                        else if(dealerUpCard.value() == Value.N4)
                                col = 2;
                        else if(dealerUpCard.value() == Value.N5)
                                col = 3;
                        else if(dealerUpCard.value() == Value.N6)
                                col = 4;
                        else if(dealerUpCard.value() == Value.N7)
                                col = 5;
                        else if(dealerUpCard.value() == Value.N8)
                                col = 6;
                        else if(dealerUpCard.value() == Value.N9)
                                col = 7;
                        else if(dealerUpCard.value() == Value.N10 || dealerUpCard.value() == Value.JACK || dealerUpCard.value() == Value.QUEEN || dealerUpCard.value() == Value.KING)                          
                                col = 8;
                        else if(dealerUpCard.value() == Value.ACE)
                                col = 9;
                       
                        return splitPA(splitPreset[index][col], allowedActions, ownHand, dealerUpCard);
                }
 
                if(!HandUtilities.soft(ownHand)){ //then hard
                        return hardAct(ownHand, dealerUpCard, allowedActions);
                }
                else
                        return softAct(ownHand, dealerUpCard, allowedActions);
 
        }
       
        private PlayerAction splitPA(int i, List<PlayerAction> allowedAction, List<Card> ownHand, Card dealerUpCard){
                //1 = hit
                //2 = stand
                //6 = split
                //7 split or hit
               
                if(i == 1)
                        if(allowedAction.contains(PlayerAction.HIT))
                                return PlayerAction.HIT;
                        else
                                return PlayerAction.STAND;
                else if(i == 2)
                        return PlayerAction.STAND;
                else if(i == 6)
                        if(allowedAction.contains(PlayerAction.SPLIT))
                                return PlayerAction.SPLIT;
                        else
                                return hardAct(ownHand, dealerUpCard, allowedAction);
                else if(i == 7)
                        if(allowedAction.contains(PlayerAction.SPLIT))
                                return PlayerAction.SPLIT;
                        else if(allowedAction.contains(PlayerAction.HIT))
                                return PlayerAction.HIT;
                return PlayerAction.STAND;
        }
       
        private PlayerAction hardAct(List<Card> ownHand, Card dealerUpCard, List<PlayerAction> allowedActions){
                int[][] hardPreset = {  //Can Double after Split  Can not hit on split aces
                                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                {1, 3, 3, 3, 3, 1, 1, 1, 1, 1},
                                {3, 3, 3, 3, 3, 3, 3, 3, 1, 1},
                                {3, 3, 3, 3, 3, 3, 3, 3, 3, 1},
                                {1, 1, 2, 2, 2, 1, 1, 1, 1, 1},
                                {2, 2, 2, 2, 2, 1, 1, 1, 1, 1},
                                {2, 2, 2, 2, 2, 1, 1, 1, 1, 1},
                                {2, 2, 2, 2, 2, 1, 1, 1, 4, 1},
                                {2, 2, 2, 2, 2, 1, 1, 4, 4, 4},
                                {2, 2, 2, 2, 2, 2, 2, 2, 2, 2}
                };
 
                int handValue = HandUtilities.value(ownHand), index = 0, col = 0;
                if(handValue <= 8)
                        index = 0;
                else if(handValue == 9)
                        index = 1;
                else if(handValue == 10)
                        index = 2;
                else if(handValue == 11)
                        index = 3;
                else if(handValue == 12)
                        index = 4;
                else if(handValue == 13)
                        index = 5;
                else if(handValue == 14)
                        index = 6;
                else if(handValue == 15)
                        index = 7;
                else if(handValue == 16)
                        index = 8;
                else if(handValue >= 17)
                        index = 9;
 
                if(dealerUpCard.value() == Value.N2)
                        col = 0;
                else if(dealerUpCard.value() == Value.N3)
                        col = 1;
                else if(dealerUpCard.value() == Value.N4)
                        col = 2;
                else if(dealerUpCard.value() == Value.N5)
                        col = 3;
                else if(dealerUpCard.value() == Value.N6)
                        col = 4;
                else if(dealerUpCard.value() == Value.N7)
                        col = 5;
                else if(dealerUpCard.value() == Value.N8)
                        col = 6;
                else if(dealerUpCard.value() == Value.N9)
                        col = 7;
                else if(dealerUpCard.value() == Value.N10 || dealerUpCard.value() == Value.JACK || dealerUpCard.value() == Value.QUEEN || dealerUpCard.value() == Value.KING)                          
                        col = 8;
                else if(dealerUpCard.value() == Value.ACE)
                        col = 9;
               
                return hardPA(hardPreset[index][col], allowedActions);
        }
       
        private PlayerAction softAct(List<Card> ownHand, Card dealerUpCard, List<PlayerAction> allowedActions){
                int[][] softPreset = {
                                {1, 1, 1, 3, 3, 1, 1, 1, 1, 1},
                                {1, 1, 1, 3, 3, 1, 1, 1, 1, 1},
                                {1, 1, 3, 3, 3, 1, 1, 1, 1, 1},
                                {1, 1, 3, 3, 3, 1, 1, 1, 1, 1},
                                {1, 3, 3, 3, 3, 1, 1, 1, 1, 1},
                                {2, 5, 5, 5, 5, 2, 2, 1, 1, 1},
                                {2, 2, 2, 2, 2, 2, 2, 2, 2, 2}
                };
 
                int handValue = HandUtilities.value(ownHand), index = 0, col = 0;
               
                if(handValue == 13)
                        index = 0;
                else if(handValue == 14)
                        index = 1;
                else if(handValue == 15)
                        index = 2;
                else if(handValue == 16)
                        index = 3;
                else if(handValue == 17)
                        index = 4;
                else if(handValue == 18)
                        index = 5;
                else if(handValue >= 19)
                        index = 6;
               
                if(dealerUpCard.value() == Value.N2)
                        col = 0;
                else if(dealerUpCard.value() == Value.N3)
                        col = 1;
                else if(dealerUpCard.value() == Value.N4)
                        col = 2;
                else if(dealerUpCard.value() == Value.N5)
                        col = 3;
                else if(dealerUpCard.value() == Value.N6)
                        col = 4;
                else if(dealerUpCard.value() == Value.N7)
                        col = 5;
                else if(dealerUpCard.value() == Value.N8)
                        col = 6;
                else if(dealerUpCard.value() == Value.N9)
                        col = 7;
                else if(dealerUpCard.value() == Value.N10 || dealerUpCard.value() == Value.JACK || dealerUpCard.value() == Value.QUEEN || dealerUpCard.value() == Value.KING)                          
                        col = 8;
                else if(dealerUpCard.value() == Value.ACE)
                        col = 9;
 
                return softPA(softPreset[index][col], allowedActions);
        }
       
        private PlayerAction softPA(int i, List<PlayerAction> allowedAction){
                //1 = hit
                //2 = stand
                //3 = double or hit
                //5 = double or stand
               
                if(i == 1)
                        if(allowedAction.contains(PlayerAction.HIT))
                                return PlayerAction.HIT;
                        else
                                return PlayerAction.STAND;
                else if(i == 2)
                        return PlayerAction.STAND;
                else if(i == 3)
                        if(allowedAction.contains(PlayerAction.DOUBLE))
                                return PlayerAction.DOUBLE;
                        else if(allowedAction.contains(PlayerAction.HIT))
                                return PlayerAction.HIT;
                        else
                                return PlayerAction.STAND;
                else if(i == 5)
                        if(allowedAction.contains(PlayerAction.DOUBLE))
                                return PlayerAction.DOUBLE;
               
                return PlayerAction.STAND;
        }
       
        private PlayerAction hardPA(int i, List<PlayerAction> allowedAction){
                //1 = hit
                //2 = stand
                //3 = double or hit
                //4 = Surrender
 
                if(i == 1)
                        if(allowedAction.contains(PlayerAction.HIT))
                                return PlayerAction.HIT;
                        else
                                return PlayerAction.STAND;
                else if(i == 2)
                        return PlayerAction.STAND;
                else if(i == 3)
                        if(allowedAction.contains(PlayerAction.DOUBLE))
                                return PlayerAction.DOUBLE;
                        else if(allowedAction.contains(PlayerAction.HIT))
                                return PlayerAction.HIT;
                        else
                                return PlayerAction.STAND;
                else if(i == 4)
                        if(allowedAction.contains(PlayerAction.SURRENDER))
                                return PlayerAction.SURRENDER;
                        else if(allowedAction.contains(PlayerAction.HIT))
                                return PlayerAction.HIT;
                        else
                                return PlayerAction.STAND;
                else if(i == 5)
                        if(allowedAction.contains(PlayerAction.DOUBLE))
                                return PlayerAction.DOUBLE;
               
                return PlayerAction.STAND;
        }
               
        @Override
        public boolean insureHand(List<Card> ownHand, Card dealerUpCard) {
                // TODO Auto-generated method stub
                return false;
        }
}