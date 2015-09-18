/**
 * 
 */
package project2_4;

import java.awt.Rectangle;

/**
 * @author Saikiran Nakka
 * This program determines the intersection of two rectangles.
 *
 */
public class Intersection {

	
	public static void main(String[] args) {
		Rectangle r = new Rectangle(0,0,50,60);
		Rectangle r2 = new Rectangle(20,20, 50, 70);
		Rectangle r3 = r.intersection(r2);
		System.out.println("r: " + r.getBounds());
		System.out.println("r2: " + r2.getBounds());
		System.out.println("r3: " + r3.getBounds());
	}

}
