/**
 * 
 */
package project2_3;

import java.awt.Rectangle;

/**
 * @author Saikiran Nakka
 * This program creates a rectangle and translates it so that it would make one large rectangle
 *
 */
public class Large_Rectangle {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Rectangle small = new Rectangle(0,0,20,50);
		System.out.println("X:" + small.getX() + "\tY:" + small.getY());
		small.translate(20, 0);
		System.out.println("X:" + small.getX() + "\tY:" + small.getY());
		small.translate(0, 50);
		System.out.println("X:" + small.getX() + "\tY:" + small.getY());
		small.translate(-20, 0);
		System.out.println("X:" + small.getX() + "\tY:" + small.getY());
	}

}
