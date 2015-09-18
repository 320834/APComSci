package p7_3;

import java.util.Scanner;

public class CannonballTester {
/**
 * @author 320951 - Saikiran Nakka
 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner k = new Scanner(System.in);
		@SuppressWarnings("unused")
		double time = 0;
		System.out.print("Enter the initial velcocity: ");
		double initialVelocity = Double.parseDouble(k.nextLine());
		ProjectileFlight ball = new ProjectileFlight(initialVelocity);
		int count = 0;
		System.out.println("Time: 0\nExpected: 0.0\nActual: 0.0");
		boolean zero = false;
		do{
			for(int i = 1; i <= 100; i++){
				ball.nextIteration();
				if(ball.getPosition() <= 0)
					zero = true;
			}
			if(zero)
				break;
			count++;
			double expected = -0.5 * ProjectileFlight.GRAVITY * Math.pow(count, 2) + initialVelocity * count;
			System.out.println("Time: " + count + "\nExpected: " + expected + "\nActual: " + ball.getPosition() + "\n");
		} while(ball.getPosition() > 0);
		
		k.close();
	}
}
