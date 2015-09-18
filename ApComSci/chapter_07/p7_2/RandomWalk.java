package p7_2;

import java.awt.geom.Point2D;

/**
 * Exercise P7.2. Random walk. Simulate the wandering of an intoxicated person in a
square street grid. Draw a grid of 10 streets horizontally and 10 streets vertically.
Represent the simulated drunkard by a dot, placed in the middle of the grid to start.
For 100 times, have the simulated drunkard randomly pick a direction (east, west,
north, south), move one block in the chosen direction, and draw the dot. After the
iterations, display the distance that the drunkard has covered. (One might expect
that on average the person might not get anywhere because the moves to different
directions cancel one another out in the long run, but in fact it can be shown with
'probability 1 that the person eventually moves outside any finite region. See, for
example, [4, Chapter 8] for more details.) Use classes for the grid and the drunkard.

You do not need to actually draw the grid, so you can omit the Grid class.
Instead, print the drunkard's coordinate location after each step. Start the drunkard at (0,0).
Bound the grid at your choice of coordinates such that the grid is a rectangle. 
The drunkard cannot move out of bounds.

 * @author 320951 - Saikiran Nakka
 *
 */
public class RandomWalk {
	private int yBound, xBound;
	private Point2D.Double point = new Point2D.Double(0, 0);
	
	/**
	 * Creates the boundaries with the top right corner of rectangle
	 * (Precondition: x and y must be positive integers)
	 * @param x x co-orinate of top right corner
	 * @param y y co-ordinate or top right corner
	 */
	public RandomWalk(int x, int y){
		yBound = y;
		xBound = x;
	}
	
	private int getRandom(){
		return (int)(Math.random()*(4) + 1);
	}
	
	/**
	 * Moves in one cardinal direction
	 * @return Point in the form "(x, y)"
	 */
	public String move(){
		if(getRandom() == 1){ //North
			if(point.getY() + 1 <= yBound)
				point.setLocation(point.getX(), point.getY() + 1);
		}
		else
			if(getRandom() == 2){//East
				if(point.getX() + 1 <= xBound)
					point.setLocation(point.getX() + 1, point.getY());
			}
			else
				if(getRandom() == 3){ //South
					if(Math.abs(point.getY() - 1) <= yBound)
						point.setLocation(point.getX(), point.getY() - 1);
				}
				else			//West
					if(Math.abs(point.getX() - 1) <= xBound)
							point.setLocation(point.getX() - 1, point.getY());
		return "(" + point.getX() + ", " + point.getY()+")";
	}
	
	/**
	 * Returns the distance from the current point to the starting point
	 * @return Distance
	 */
	public double getDistance(){
		return Math.sqrt(Math.pow(point.getX(), 2) + Math.pow(point.getY(), 2));
	}
}
