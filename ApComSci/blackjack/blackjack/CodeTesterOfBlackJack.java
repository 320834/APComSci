package blackjack;
 
import java.util.ArrayList;
 
public class CodeTesterOfBlackJack {
 
        public static void main(String[] args) {
                // TODO Auto-generated method stub
                ArrayList<PlayerAction> allowedActions = new ArrayList<PlayerAction>();
                allowedActions.add(PlayerAction.HIT);
                allowedActions.add(PlayerAction.STAND);
                allowedActions.add(PlayerAction.SURRENDER);
                allowedActions.add(PlayerAction.DOUBLE);
                ArrayList<Card> hand = new ArrayList<Card>();
                hand.add(new Card(Value.ACE, Suite.DIAMONDS));
                hand.add(new Card(Value.ACE, Suite.DIAMONDS));
                hand.add(new Card(Value.N6, Suite.DIAMONDS));
                BasicPlayer test = new BasicPlayer();
                System.out.println(HandUtilities.soft(hand));
                System.out.println(test.act(hand, new Card(Value.N7, Suite.CLUBS), allowedActions));
        }
 
}
