
package montyHall;

import java.util.Scanner;

/**
 * @author 320951
 *
 */
public class SimulationTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Simulation test = new Simulation();
		Scanner keyboard = new Scanner(System.in);
		System.out.println("How many rounds do you want?");
		int rounds = Integer.parseInt(keyboard.nextLine());
		for(int i = 1; i <= rounds; i++)
			System.out.println("Round: " + i + "  " + test.nextRound());
		System.out.println(test.getStats());
		keyboard.close();
	}

}
