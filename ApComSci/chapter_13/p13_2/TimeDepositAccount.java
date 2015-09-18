package p13_2;

public class TimeDepositAccount extends SavingsAccount{
	private int maturityPeriod;
	public static final double WITHRAWL_PENALTY = 15;
	
	public TimeDepositAccount(double iR, int mP, double balance){
		super(iR);
		deposit(balance);
		maturityPeriod = mP;
	}
	
	public void addInterest(){
		maturityPeriod--;
		super.addInterest();
	}
	
	public void withdraw(double money){
		if(maturityPeriod > 0)
			super.withdraw(money + WITHRAWL_PENALTY);
		else
			super.withdraw(money);
	}
}
