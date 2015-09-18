/**
 * 
 */
package montyHall;

/**
 * @author Saikiran Nakka
 * This simulates the Monty Hall Problem
 */
public class MontyHall {
	private int prizedoor;
	private boolean door1, door2, door3;
	private int stay, switched, stayWin, switchedWin, choice = 0, opened = 0;
	/**
	 *Constructor that runs the original prize door chooser 
	 */
	public MontyHall(){
		choosePrizeDoor();
	}
	/**
	 * This chooses one of the 3 doors as the prize door and sets it as true
	 */
	public void choosePrizeDoor(){
		prizedoor = (int)Math.round(Math.random() * (3 - 1) + 1);
				 if(prizedoor == 1){
					 door1 = true;
					 door2 = false;
					 door3 = false;
				 }
				 else if(prizedoor == 2){
					 door1= false;
					 door2 = true;
					 door3 = false;
				 }
				 else{
					 door1 = false;
					 door2 = false;
					 door3 = true;
				 }
	}
	/**
	 * This takes the users choice and returns the value of the door that is a goat(not prize)
	 * @param door This is the door the user chose
	 * @return opened This is the value of the door that is a goat
	 */
	public int choose(int door){
		choice = door;
		if(choice == 1){
			if(door1 == false){
				if(door2 == false)
					opened = 2;
				else
					opened = 3;
			}
			else if(door1 == true)
				if((int)Math.round(Math.random() * (2 - 1) + 1) == 1){
					opened = 2;
				}
				else 
					opened = 3;
		}
		else if(choice == 2){
			if(door2 == false){
				if(door1 == false)
					opened = 1;
				else
					opened = 3;
			}
			else if(door2 == true)
				if((int)Math.round(Math.random() * (2 - 1) + 1) == 1){
					opened = 1;
				}
				else 
					opened = 3;
		}
		else if(choice == 3){
			if(door3 == false){
				if(door2 == false)
					opened = 2;
				else
					opened = 1;
			}
			else if(door3 == true)
				if((int)Math.round(Math.random() * (2 - 1) + 1) == 1){
					opened = 2;
				}
				else 
					opened = 1;
		}
		return opened;
	}
	/**
	 * This checks if the door the user chose is the prize, if it is it adds one to the counter
	 * Then it runs the reset method.
	 */
	public boolean stay(){
		stay++;
		if(choice == prizedoor){
			stayWin++;
			reset();
			return true;
		}
		reset();
		return false;
	}
	/**
	 * This checks if the other door is prize, if so, it adds one to the switchedWin counter
	 * Then it runs the reset method
	 */
	public boolean switched(){
		switched++;
		if(choice != prizedoor){
			switchedWin++;
			reset();
			return true;
		}
		reset();
		return false;
	}
	/**
	 * This resets the users choice and opened value and chooses a new PrizeDoor
	 */
	public void reset(){
		choice = 0;
		opened = 0;
		choosePrizeDoor();
	}
	/**
	 * This returns the number of times the user decided to stay
	 * @return stay number of times the user stayed
	 */
	public int getStay(){
		return stay;
	}
	/**
	 * This returns the amount of times a stay resulted in a win
	 * @return stayWin number of times a stay won
	 */
	public int getStayWin(){
		return stayWin;
	}
	/**
	 * This returns the number of times the user chose to switch
	 * @return switched number of times the user switched
	 */
	public int getSwitched(){
		return switched;
	}
	/**
	 * This returns the number of times a switch resulted in a win
	 * @return switchedWin number of times a switch won
	 */
	public int getSwitchedWin(){
		return switchedWin;
	}
	/**
	 * Prints the doors out in their current state
	 */
	public void drawDoors(){
		if(choice == 0 && opened == 0){
			System.out.println("_______________    _______________    _______________");
			System.out.println("|             |    |             |    |              |");
			System.out.println("|             |    |             |    |              |");
			System.out.println("|             |    |             |    |              |");
			System.out.println("|      1      |    |      2      |    |      3       |");
			System.out.println("|             |    |             |    |              |");
			System.out.println("|           O |    |           O |    |            O |");
			System.out.println("|             |    |             |    |              |");
			System.out.println("|             |    |             |    |              |");
			System.out.println("|             |    |             |    |              |");
			System.out.println("_______________    _______________    _______________");
		}
		else if(opened == 0){
			if(choice == 1){
				System.out.println("_______________    _______________    _______________");
				System.out.println("|             |    |             |    |              |");
				System.out.println("|             |    |             |    |              |");
				System.out.println("|             |    |             |    |              |");
				System.out.println("|      1      |    |      2      |    |      3       |");
				System.out.println("|             |    |             |    |              |");
				System.out.println("|      C    O |    |           O |    |            O |");
				System.out.println("|             |    |             |    |              |");
				System.out.println("|             |    |             |    |              |");
				System.out.println("|             |    |             |    |              |");
				System.out.println("_______________    _______________    _______________");
			}
			else if(choice == 2){
				System.out.println("_______________    _______________    _______________");
				System.out.println("|             |    |             |    |              |");
				System.out.println("|             |    |             |    |              |");
				System.out.println("|             |    |             |    |              |");
				System.out.println("|      1      |    |      2      |    |      3       |");
				System.out.println("|             |    |             |    |              |");
				System.out.println("|           O |    |      C    O |    |            O |");
				System.out.println("|             |    |             |    |              |");
				System.out.println("|             |    |             |    |              |");
				System.out.println("|             |    |             |    |              |");
				System.out.println("_______________    _______________    _______________");
			}
			else if(choice == 3){
				System.out.println("_______________    _______________    _______________");
				System.out.println("|             |    |             |    |              |");
				System.out.println("|             |    |             |    |              |");
				System.out.println("|             |    |             |    |              |");
				System.out.println("|      1      |    |      2      |    |      3       |");
				System.out.println("|             |    |             |    |              |");
				System.out.println("|           O |    |           O |    |      C     O |");
				System.out.println("|             |    |             |    |              |");
				System.out.println("|             |    |             |    |              |");
				System.out.println("|             |    |             |    |              |");
				System.out.println("_______________    _______________    _______________");
			}
		}
		else if(opened == 1){
			if(choice == 2){
				System.out.println("_______________    _______________    _______________");
				System.out.println("|             |    |             |    |              |");
				System.out.println("|             |    |             |    |              |");
				System.out.println("|             |    |             |    |              |");
				System.out.println("|             |    |      2      |    |      3       |");
				System.out.println("|     GOAT    |    |             |    |              |");
				System.out.println("|             |    |      C    O |    |            O |");
				System.out.println("|             |    |             |    |              |");
				System.out.println("|             |    |             |    |              |");
				System.out.println("|             |    |             |    |              |");
				System.out.println("_______________    _______________    _______________");
			}
			else if(choice == 3){
				System.out.println("_______________    _______________    _______________");
				System.out.println("|             |    |             |    |              |");
				System.out.println("|             |    |             |    |              |");
				System.out.println("|             |    |             |    |              |");
				System.out.println("|             |    |      2      |    |      3       |");
				System.out.println("|     GOAT    |    |             |    |              |");
				System.out.println("|             |    |           O |    |      C     O |");
				System.out.println("|             |    |             |    |              |");
				System.out.println("|             |    |             |    |              |");
				System.out.println("|             |    |             |    |              |");
				System.out.println("_______________    _______________    _______________");
			}
		}
		else if(opened == 2){
			if(choice == 1){
				System.out.println("_______________    _______________    _______________");
				System.out.println("|             |    |             |    |              |");
				System.out.println("|             |    |             |    |              |");
				System.out.println("|             |    |             |    |              |");
				System.out.println("|      1      |    |             |    |      3       |");
				System.out.println("|             |    |     GOAT    |    |              |");
				System.out.println("|      C    O |    |             |    |            O |");
				System.out.println("|             |    |             |    |              |");
				System.out.println("|             |    |             |    |              |");
				System.out.println("|             |    |             |    |              |");
				System.out.println("_______________    _______________    _______________");
			}
			else if(choice == 3){
				System.out.println("_______________    _______________    _______________");
				System.out.println("|             |    |             |    |              |");
				System.out.println("|             |    |             |    |              |");
				System.out.println("|             |    |             |    |              |");
				System.out.println("|      1      |    |             |    |      3       |");
				System.out.println("|             |    |     GOAT    |    |              |");
				System.out.println("|           O |    |             |    |      C     O |");
				System.out.println("|             |    |             |    |              |");
				System.out.println("|             |    |             |    |              |");
				System.out.println("|             |    |             |    |              |");
				System.out.println("_______________    _______________    _______________");
			}
		}
		else if(opened == 3)
			if(choice == 1){
				System.out.println("_______________    _______________    _______________");
				System.out.println("|             |    |             |    |              |");
				System.out.println("|             |    |             |    |              |");
				System.out.println("|             |    |             |    |              |");
				System.out.println("|      1      |    |      2      |    |              |");
				System.out.println("|             |    |             |    |     GOAT     |");
				System.out.println("|      C    O |    |           O |    |              |");
				System.out.println("|             |    |             |    |              |");
				System.out.println("|             |    |             |    |              |");
				System.out.println("|             |    |             |    |              |");
				System.out.println("_______________    _______________    _______________");
			}
			else if(choice == 2){
				System.out.println("_______________    _______________    _______________");
				System.out.println("|             |    |             |    |              |");
				System.out.println("|             |    |             |    |              |");
				System.out.println("|             |    |             |    |              |");
				System.out.println("|      1      |    |      2      |    |              |");
				System.out.println("|             |    |             |    |      GOAT    |");
				System.out.println("|           O |    |      C    O |    |              |");
				System.out.println("|             |    |             |    |              |");
				System.out.println("|             |    |             |    |              |");
				System.out.println("|             |    |             |    |              |");
				System.out.println("_______________    _______________    _______________");
			}
	}
}
