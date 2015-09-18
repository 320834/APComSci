package montyHall;

public class Simulation {
	private MontyHall game = new MontyHall();
	private int doorChosen, doorOpened;
	/**
	 * Initializes Simulation
	 * 
	 */
	public Simulation(){	
	}
	
	/**
	 * Info for each round
	 * @return The Door Chosen, the Door Opened, Stayed/Switched, and Won/Lost
	 */
	public String nextRound(){
		doorChosen = getRandom(3, 1);
		doorOpened = game.choose(doorChosen);
		if(getRandom(2, 1) == 1)
			if(game.stay())
				return "Door Chosen: " + doorChosen + "\tDoor Opened: " + doorOpened + "\tStayed, Won";
			else
				return "Door Chosen: " + doorChosen + "\tDoor Opened: " + doorOpened + "\tStayed, Lost";
		else
			if(game.switched())
				return "Door Chosen: " + doorChosen + "\tDoor Opened: " + doorOpened + "\tSwitched, Won";
			else				
				return "Door Chosen: " + doorChosen + "\tDoor Opened: " + doorOpened + "\tSwitched, Lost";
	}
	
	/**
	 * Returns final stats
	 * @return Final stats include number of switches and stays and number of wins for each
	 */
	public String getStats(){
		return "Times Switched: " + game.getSwitched() + "\nTimes Won from Switching: " + game.getSwitchedWin() + "\nTimes Stayed: " + game.getStay() + "\nTimes Won from Staying: " + game.getStayWin() + "\nPercent Win for Staying: " + 100.0 * game.getStayWin()/game.getStay() + "%\nPercent Win for Switching: " + 100.0 * game.getSwitchedWin()/game.getSwitched() + "%";
	}
	
	/**
	 * Given the min and max, it gives a random int
	 * @param max Max number (inclusive)
	 * @param min Min number (inclusive)
	 * @return Random number in the range
	 */
	public static int getRandom(int max, int min){
		return (min - 1) + (int) (Math.random() * (max - (min - 1)) + 1);
	}
}
