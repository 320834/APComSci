package p7_4;

import java.util.Scanner;

public class CannonballTester {

	public static void main(String[] args) {
		boolean done = false;
		Scanner k = new Scanner(System.in);
		System.out.print("Angle: ");
		double angle = Double.parseDouble(k.nextLine());
		System.out.print("Velocity: ");
		double velocity = Double.parseDouble(k.nextLine());
		Cannonball ball = new Cannonball(velocity, angle, .01);
		System.out.println("Time: 0\nHorizontal: 0\nVertical: 0\n");
		while(!done){
			for(int i = 1; i <= 100; i++){
				ball.nextIteration();
				if(ball.getY() <= 0){
					done = true;
					break;
				}
			}
			System.out.println("Time: " + ball.getTime() + "\nHorizontal: " + ball.getX() + "\nVertical: " + ball.getY() + "\n");
		}
		k.close();
	}
}
