package p4_11;

/**
   This class tests the CashRegister class.
*/
public class CashRegisterTester
{
   public static void main(String[] args)
   {
      CashRegister register = new CashRegister();

      register.recordPurchase(0.75);
      register.recordPurchase(1.50);
      register.enterPayment(2, 0, 5, 0, 0);
      System.out.print("Change=");
      System.out.println(register.giveDollars());
      System.out.println(register.giveQuarters());
      System.out.println(register.giveDimes());
      System.out.println(register.giveNickels());
      System.out.println(register.givePennies());


      register.recordPurchase(2.25);
      register.recordPurchase(19.25);
      register.enterPayment(23, 2, 0, 0, 0);
      System.out.print("Change=");
      System.out.println(register.giveDollars());
      System.out.println(register.giveQuarters());
      System.out.println(register.giveDimes());
      System.out.println(register.giveNickels());
      System.out.println(register.givePennies());   }
}
