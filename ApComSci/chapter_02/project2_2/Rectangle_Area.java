/**
 * 
 */
package project2_2;

import java.awt.Rectangle;
import java.util.Scanner;

/**
 * @author Saikiran Nakka
 * This method creates a Rectangel class and prints the area
 *
 */
public class Rectangle_Area {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("What is the height of your rectangle?");
		int h = Integer.parseInt(keyboard.nextLine());
		System.out.println("What is the width of your rectangle?");
		int w = Integer.parseInt(keyboard.nextLine());
		Rectangle box = new Rectangle(w, h);
		System.out.println("The area of the rectangle is " + (box.getWidth()*box.getHeight()));
		keyboard.close();
	}

}
