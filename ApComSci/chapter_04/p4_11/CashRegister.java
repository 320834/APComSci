package p4_11;

/**
   A cash register totals up sales and computes change due.
*/
public class CashRegister
{
	private double change;
   /**
      Constructs a cash register with no money in it.
   */
   public CashRegister()
   {
      purchase = 0;
      payment = 0;
   }

   /**
      Records the purchase price of an item.
      @param amount the price of the purchased item
   */
   public void recordPurchase(double amount)
   {
      purchase = purchase + amount;
   }
   
   /**
      Enters the payment received from the customer.
      @param dollars the number of dollars in the payment
      @param quarters the number of quarters in the payment
      @param dimes the number of dimes in the payment
      @param nickels the number of nickels in the payment
      @param pennies the number of pennies in the payment
   */
   public void enterPayment(int dollars, int quarters, 
         int dimes, int nickels, int pennies)
   {
      payment = dollars + quarters * QUARTER_VALUE + dimes * DIME_VALUE
            + nickels * NICKEL_VALUE + pennies * PENNY_VALUE;
   }
   
   /**
      Computes the change due and resets the machine for the next customer.
      @return the change due to the customer
   */
   public int giveDollars()
   {
      change = payment - purchase;
      purchase = 0;
      payment = 0;
      int dollars = 0;
      while(change >= 1){
    	  dollars++;
    	  change--;
      }
      return dollars;
   }
   public int giveQuarters(){
	   int quarters = 0;
	      while(change >= QUARTER_VALUE){
	    	  quarters++;
	    	  change -= QUARTER_VALUE;
	      }
	      return quarters;   
   } 
   public int giveDimes(){
	   int dimes = 0;
	      while(change >= DIME_VALUE){
	    	  dimes++;
	    	  change -= DIME_VALUE;
	      }
	      return dimes;   
}  
   public int giveNickels(){
	   int nickels = 0;
	      while(change >= NICKEL_VALUE){
	    	  nickels++;
	    	  change -= NICKEL_VALUE;
	      }
	      return nickels;   
}
   public int givePennies(){
	   int pennies = 0;
	      while(change >= PENNY_VALUE){
	    	  pennies++;
	    	  change -= PENNY_VALUE;
	      }
	      return pennies;   
}
   public static final double QUARTER_VALUE = 0.25;
   public static final double DIME_VALUE = 0.1;
   public static final double NICKEL_VALUE = 0.05;
   public static final double PENNY_VALUE = 0.01;

   private double purchase;
   private double payment;
}
