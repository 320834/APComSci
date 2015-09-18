package project_1;

/**
 * Simulates opening a Letter Combination Lock(A-Z) Case Insensitive
 * @author Zedai
 *
 */
public class CombinationLock {
	private char char1, char2, char3, pos1 = '.', pos2 = '.', pos3 = '.';
	/**
	 * Initializes pass code (Chars)
	 * @param char1 1st char
	 * @param char2 2nd char
	 * @param char3 3rd char
	 */
	public CombinationLock(String char1, String char2, String char3){	//String to make Case-Insensitive
		this.char1 = char1.toUpperCase().charAt(0);
		this.char2 = char2.toUpperCase().charAt(0);
		this.char3 = char3.toUpperCase().charAt(0);
	}
	
	/**
	 * This sets the letter to the third position and moves everything down one position
	 * @param letter The letter that is turned to on the dial
	 */
	public void turn(char letter){
		pos1 = pos2;
		pos2 = pos3;
		pos3 = letter;
	}
	
	/**
	 * checks to see if what has been dialed in is the combination
	 * @return True, if it is same, false if the two are different
	 */
	public boolean check(){
		return (char1 == pos1 && char2 == pos2 && char3 == pos3);
	}
}
