package p6_4;

import java.util.Scanner;

public class SmallLargeTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double x, y, z;
		Scanner k = new Scanner(System.in);
		System.out.println("Please Enter Three Numbers");
		x = k.nextDouble();
		k.nextLine();
		y = k.nextDouble();
		k.nextLine();
		z=k.nextDouble();
		k.nextLine();
		SmallLarge test = new SmallLarge(x,y, z);
		System.out.println("The Inputs In Sorted Order\n" + test.getSort());
		k.close();
	}

}
