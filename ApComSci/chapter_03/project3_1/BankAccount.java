package project3_1;
/**
 * Project 3.1. In this project, you will enhance the BankAccount class and see how
abstraction and encapsulation enable evolutionary changes to software.
Begin with a simple enhancement: charging a fee for every deposit and withdrawal.
Supply a mechanism for setting the fee and modify the deposi t and wi thdraw methods
so that the fee is levied. Test your resulting class and check that the fee is computed
correctly.
Now make a more complex change. The bank will allow a fixed number of free
transactions (deposits or withdrawals) every month, and charge for transactions
exceeding the free allotment. The charge is not levied immediately but at the end of
the month.
Supply a new method deductMonthlyCharge to the BankAccount class that deducts the
monthly charge and resets the transaction count. Produce a test program that verifies
that the fees are calculated correctly over several months.
 * @author 320951
 *
 */
public class BankAccount {
	@SuppressWarnings("unused")
	private double balance, fee, free, day, charge;
	public BankAccount(){
		balance = 0;
		fee = 0;
		free = 0;
		day = 1;
		charge = 0;
	}
	public double getBalance(){
		return balance;
	}
	public void setFee(int m){
		fee = m;
	}
	public void setFreeCharges(int n){
		free = n;
	}
	public void withdraw(int m){
		balance -= m;
		//balance -= fee;
		deductMonthlyCharge();
	}
	public void deposit(int m){
		balance +=m;
		//balance -= fee;
		deductMonthlyCharge();
	}
	public double getDay(){
		return day;
	}
	public void deductMonthlyCharge(){
		day++;
		if(day >= fee)
			charge += fee;
		if(day == 30){
			balance -=charge;
			charge = 0;
			day = 1;
		}
	}
}
