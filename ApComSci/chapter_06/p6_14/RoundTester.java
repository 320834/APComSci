package p6_14;

import java.util.Scanner;

public class RoundTester {
	public static void main(String[] args){
	Scanner keyboard = new Scanner(System.in);
	System.out.println("Enter two doubles:");
	double a = Double.parseDouble(keyboard.nextLine());
	Round lol = new Round(a, keyboard.nextDouble());
	if(lol.check())
		System.out.println("Same when rounded to two decimal");
	else
		System.out.println("Not same when rounded to two decimal places");
	keyboard.close();
	}
}
