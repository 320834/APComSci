package p6_18;

import java.awt.geom.Point2D;
/**
 * Simulates a Line
 * @author Zedai
 *
 */
public class Line {
	private double slope, yIntercept, verticalValue = Integer.MAX_VALUE;	//verticalValue is to tell if the line is a verticl line and what x = if it is not a vertical line it is set to MAX_VALUE
	public static final double TOLERANCE = .00001;
	
	/**
	 * Initiates Line with a point and slope
	 * @param point used to get Y-Intercept
	 * @param m slope
	 */
	public Line(Point2D.Double point, double m){
		slope = m;
		yIntercept = point.getY() - m * point.getX();
	}
	
	/**
	 * Initiates Line with two Point2D's
	 * @param point1 first coordinate point
	 * @param point2 second coordinate point
	 */
	public Line(Point2D.Double point1, Point2D.Double point2){
		slope = (point2.getY() - point1.getY())/ (point2.getX() - point1.getX());
		yIntercept = point1.getY() - slope * point1.getX();
	}
	
	/**
	 * Initializes Line in form of "y = mx + b"
	 * @param eq Line in equation
	 */
	public Line(String eq){
		slope = Double.parseDouble(eq.substring(eq.indexOf('=') + 1, eq.indexOf('x')));
		yIntercept = Double.parseDouble(eq.substring(eq.indexOf('+') + 1));
	}
	
	/**
	 * Initializes a Line, if true, in form of "x = number", if false: in form ofo "y = mx + b"
	 * @param eq Equation
	 * @param vertical If true, line is vertical, else line is not
	 */
	public Line(String eq, boolean vertical){
		if(!vertical){
			slope = Double.parseDouble(eq.substring(eq.indexOf('=') + 1, eq.indexOf('x')));
			yIntercept = Double.parseDouble(eq.substring(eq.indexOf('+') + 1));
		}
		else{			
			yIntercept = Integer.MAX_VALUE; //Because the max value is highly unlikely as a y-intercept
			slope = Integer.MAX_VALUE;
			verticalValue = Double.parseDouble(eq.substring(eq.indexOf('=') + 1));
		}
	}
	
	/**
	 * Checks to see if two Lines are parallel by comparing slopes
	 * @param other Other Line
	 * @return If true, line is parallel, if false, line is intersecting
	 */
	public boolean isParallel(Line other){
		if(Math.abs(this.slope - other.slope) <= TOLERANCE)
			return true;
		else
			return false;
	}
	
	/**
	 * Checks to see if Line is intersecting
	 * @param other Other Line
	 * @return true if Line is intersecting, False if Line is Parallel
	 */
	public boolean intersects(Line other){
		if(this.isParallel(other))
			return false;
		else
			return true;
	}
	 /**
	  * Determines if two Lines are Identical
	  * @param other Other Line
	  * @return True if Lines are same, False if Lines are different0
	  */
	public boolean equals(Line other){
		//if(this.slope == other.slope && this.yIntercept == other.yIntercept && this.verticalValue == other.verticalValue)
		if(Math.abs(this.slope-other.slope) <= TOLERANCE && Math.abs(this.yIntercept-other.yIntercept) <= TOLERANCE && this.verticalValue == other.verticalValue)
			return true;
		else
			return false;
	}
	
	/**
	 * Prints Lines slope and yIntercept
	 */
	public String toString(){
		return "Slope: "+slope+"\tY- Intercept: " + yIntercept+"\t(2.147483647E9 means undefined)";
	}
}
