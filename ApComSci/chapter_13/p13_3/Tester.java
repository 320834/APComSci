package p13_3;

import java.util.Scanner;

public class Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Square sq;
		Scanner s = new Scanner(System.in);
		System.out.println("CenterX: ");
		int x = Integer.parseInt(s.nextLine());
		System.out.println("CenterY: ");
		int y = Integer.parseInt(s.nextLine());
		System.out.println("Side: ");
		int si = Integer.parseInt(s.nextLine());
		sq = new Square(x, y, si);
		System.out.println(sq);
		System.out.println("Area: " + sq.getArea());
		s.close();
	}

}
