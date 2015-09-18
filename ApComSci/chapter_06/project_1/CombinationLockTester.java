package project_1;

import java.util.Scanner;

public class CombinationLockTester {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		CombinationLock lock = new CombinationLock("V", "E", "X");
		System.out.println("Enter Your Combination (One Char At A Time)");
		while(!lock.check()){
			lock.turn(keyboard.nextLine().toUpperCase().charAt(0));
			if(!lock.check())
				System.out.println("Enter A Char");
		}
		System.out.println("Your lock opens");
		keyboard.close();
	}

}
