package project2_5;

import java.awt.Color;

/**
 * @author Saikiran Nakka
 * Exercise P2.S. In the Java library, a color is specified by its red, green, and blue components
between ° and 255. Write a program that constructs a Color object with red,
green, and blue values of 50,100, and 150. Then apply the brighter method and
print the red, green, and blue values of the resulting color. (You won't actually see
the color-see Programming Project 2.2 on how to display the color.)
 *
 */
public class ColorChange {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Color color = new Color(50, 100, 150);
		System.out.println("R:" + color.getRed() + "\nG:" + color.getGreen() + "\nB:" + color.getBlue());
		color = color.brighter();
		System.out.println("R:" + color.getRed() + "\nG:" + color.getGreen() + "\nB:" + color.getBlue());
	}

}
