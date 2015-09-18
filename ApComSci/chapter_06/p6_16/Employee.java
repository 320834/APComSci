package p6_16;

import java.util.Scanner;

public class Employee {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner k = new Scanner(System.in);
		System.out.println("Enter name:");
		String name = k.nextLine();
		System.out.println("Enter hours:");
		double hours = Double.parseDouble(k.nextLine());
		System.out.println("Enter wage:");
		Paycheck ployee = new Paycheck(hours, name, Double.parseDouble(k.nextLine()));
		System.out.println(ployee.getName()+"'s pay is " + ployee.calculate());
		k.close();
	}

}
