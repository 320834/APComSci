package p6_14;

public class Round {
/**
 * Exercise P6.14. Write a program that reads in two floating-point numbers and tests
whether they are the same when rounded to two decimal places. Here are two sample
runs.
 */
	private double a, b;
	public Round(double a, double b){
		this.a = a;
		this.b = b;
	}
	public boolean check(){
		if(Math.round(a*100) == Math.round(b*100)){
			return true;
		}
		else
			return false;
	}
}