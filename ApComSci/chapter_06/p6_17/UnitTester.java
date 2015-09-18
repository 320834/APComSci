package p6_17;

import java.util.Scanner;

public class UnitTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner k = new Scanner(System.in);
		System.out.println("What are you converting from: (use abreviations like : in, ft, mi, mm, cm, m, km)");
		String from = k.nextLine();
		System.out.println("What are you converting to:");
		String to = k.nextLine();
		System.out.println("What is the value in " + from+ ": ");
		double value = k.nextDouble();
		UnitConversion con = new UnitConversion(from, to, value);
		System.out.println(value + " in " + from +" is " + con.calculate() + " in " + to);
		k.close();
	}

}
