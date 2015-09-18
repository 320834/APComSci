package project9_2;

import java.util.Scanner;

/**
 * Uses scanner to take either a zip code or bar code and translate to the other type
 * 
 * It directs you to a menu with the choice of converting to Bar Code or converting to Zip Code
 * -By choosing to translate to bar code it will ask for a int ZipCode and return a String BarCode
 * -By choosing to translate to zip code it will ask for a String BarCode and return an int ZipCode
 * 
 * Lastly it will ask if you want to translate anything else if yes it returns you to the menu, No exits the program
 * 
 * @author 320951 - Saikiran Nakka, 174363 - Stephen Hitchcock
 */
public class UI {

	static Scanner keyboard = new Scanner(System.in);
	
	/**
	 * It is a menu with the choice of converting to Bar Code or converting to Zip Code
	 * -By choosing to translate to bar code it will ask for a int ZipCode and return a String BarCode
	 * -By choosing to translate to zip code it will ask for a String BarCode and return an int ZipCode
	 * 
	 * Then it asks you if you want to continue, if yes it will repeat, if no it prints "Good-Bye"
	 */
	public static void run(){
		System.out.println("Would you like Zip to Bar (\"Z\") or Bar to Zip (\"B\")");
		if(keyboard.nextLine().equalsIgnoreCase("Z")){
			System.out.print("Enter Number Zip Code: ");
			System.out.println(ZipBar.getBar(keyboard.nextInt()));
			keyboard.nextLine();
		}
		else{
			System.out.print("Enter String Bar Code: ");
			System.out.println(ZipBar.getZip(keyboard.nextLine()));
		}
		
		System.out.println("Do You Want To Continue Y/N?");
		if(keyboard.nextLine().equalsIgnoreCase("Y"))
			run();
		else
			System.out.println("Good-Bye");
	}
}
