package project3_1;

public class BankAccountTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BankAccount harrysChecking = new BankAccount();
	      harrysChecking.setFee(5);
	      harrysChecking.setFreeCharges(6);
		  for(int i = 1; i <= 31; i++){
			  harrysChecking.deposit(2000);
			  harrysChecking.withdraw(500);
			  System.out.println(harrysChecking.getDay());
			  System.out.println(harrysChecking.getBalance());
		  }
	}

}
