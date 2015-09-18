package montyHall;

import java.util.Scanner;

/**
 * @author Saikiran Nakka
 * This simulates the Monty Hall Game with the user playing
 */
public class MontyHallGame {
	static Scanner keyboard = new Scanner(System.in);
	static MontyHall game = new MontyHall();
	public static void main(String[] args) {
		game();
		keyboard.close();
	}
	public static void game(){
		int i = 0;
		while(i == 0){
			game.drawDoors();
			System.out.println("What door do you want to choose");
			int o = game.choose(keyboard.nextInt());
			keyboard.nextLine();
			game.drawDoors();
			System.out.println("Door " + o + " has a goat!");
			System.out.println("Stay or Switch?(stay = 1, switch = 2)");
			if(keyboard.nextInt() == 1)
				System.out.println(game.stay());
			else
				System.out.println(game.switched());
			keyboard.nextLine();
			System.out.println("Do you want to continue?(y/n)");
			if(keyboard.nextLine().equalsIgnoreCase("y"));
			else		//exits while loop
				i = 1;
		}
		stats();		//prints statistics
	}
	/**
	 * This method prints out all of the stats from the user's game (stay, stayWin, switched, switchedWin)
	 */
	public static void stats(){
		System.out.println("Times Switched: " + game.getSwitched() + "\nTimes Won from Switching: " + game.getSwitchedWin() + "\nTimes Stayed: " + game.getStay() + "\nTimes Won from Staying: " + game.getStayWin() + "\n\nWin From Switch");
	}
}
