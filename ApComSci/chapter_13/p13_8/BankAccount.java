package p13_8;

/**
   A bank account has a balance that can be changed by 
   deposits and withdrawals.
*/
public abstract class BankAccount
{  
   /**
      Constructs a bank account with a zero balance.
   */
   public BankAccount()
   {  
      balance = 0;
   }

   /**
      Constructs a bank account with a given balance.
      @param initialBalance the initial balance
   */
   public BankAccount(double initialBalance)
   {  
      balance = initialBalance;
   }
 
   /**
      Deposits money into the bank account.
      @param amount the amount to deposit
   */
   public void deposit(double amount) 
   {  
      balance = balance + amount;
   }

   /**
      Withdraws money from the bank account.
      @param amount the amount to withdraw
   */
   public void withdraw(double amount) 
   {  
      balance = balance - amount;
   }

   /**
      Gets the current balance of the bank account.
      @return the current balance
   */
   public double getBalance()
   {  
      return balance; 
   }
   
   /**
      Transfers money from the bank account to another account
      @param amount the amount to transfer
      @param other the other account
   */
   public void transfer(double amount, BankAccount other)
   {  
      withdraw(amount);
      other.deposit(amount);
   }
   
   public static void test(BankAccount account){
	   account.withdraw(24);
	   System.out.println(account.getBalance());
	   account.deposit(135);
	   System.out.println(account.getBalance());
	   account.withdraw(12);
	   System.out.println(account.getBalance());
	   account.deposit(4);
	   System.out.println(account.getBalance());
	   account.deposit(1);
	   System.out.println(account.getBalance());
	   account.endOfMonth();
	   System.out.println(account.getBalance());
   }
   
   public abstract void endOfMonth();

   private double balance; 
}
