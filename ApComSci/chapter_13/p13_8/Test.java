package p13_8;

public class Test {

	public static void main(String[] args) {
		System.out.println("SAVINGS ACCOUNT");
		BankAccount.test(new SavingsAccount(5));
		System.out.println("CHECKING ACCOUNT");
		BankAccount.test(new CheckingAccount(245));
	}

}
