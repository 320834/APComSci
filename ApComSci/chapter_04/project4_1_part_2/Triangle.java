package project4_1_part_2;
/**
 * This class creates a Triangle class that is able to calculate the lengths of sides, the angles,
 * the perimeter, and the area
 * @author Saikiran Nakka
 * @since October 9th, 2014
 */
public class Triangle {	
	private double x1, y1, x2, y2, x3, y3;
	/**
	 * This instantiates the Triangle by setting its corners.
	 * @param x1 X value of first corner.
	 * @param y1 Y value of first corner.
	 * @param x2 X value of second corner.
	 * @param y2 Y value of second corner.
	 * @param x3 X value of third corner.
	 * @param y3 Y value of third corner.
	 */
	public Triangle(double x1, double y1, double x2, double y2, double x3, double y3){
		this.x1 = x1;
		this.x2 = x2;
		this.x3 = x3;
		this.y1 = y1;
		this.y2 = y2;
		this.y3 = y3;
	}
	/**
	 * This will set a corner to a new coordinate
	 * @param corner This is a number from 1 - 3 inclusive that indicates which corner is being set.
	 * @param x This is the x value to be set.
	 * @param y This is the y value to be set.
	 */
	public void setCorner(int corner, double x, double y){
		if(corner == 1){
			x1 = x;
			y1 = y;
		}
		else
			if(corner == 2){
			x2 = x;
			y2 = y;
			}
			else
				if(corner == 2){
					x2 = x;
					y2 = y;
				}
				else
					System.out.println("Invalid Input");
	}
	/**
	 * This will return the length of the requested side.
	 * @param side This determines which side's length is to be returned (1-3 based off of the side opposite the respectively numbered corners)
	 * @return length This is the length.
	 */
	public double getLength(int side){
		if(side == 1)
			return Math.sqrt(Math.pow(x3-x2, 2) + Math.pow(y3-y2, 2));
		else
			if(side == 2)
				return Math.sqrt(Math.pow(x3-x1, 2) + Math.pow(y3-y1, 2));
			else
				if(side == 3)
					return Math.sqrt(Math.pow(x1-x2, 2) + Math.pow(y1-y2, 2));
				else
					return -1;
	}
	/**
	 * This will return the angle of the requested corner
	 * @param corner This is used to determine which corner to use (inputs are 1-3)
	 * @return angle This is the angle measurement of the requested corner.
	 */
	public double getAngle(int corner){
		if(corner == 1)
			return Math.acos(((Math.pow(this.getLength(2), 2)+ Math.pow(this.getLength(3), 2) - Math.pow(this.getLength(1), 2))/(2*this.getLength(2)*this.getLength(3))));
		else
			if(corner == 2)
				return Math.acos(((Math.pow(this.getLength(1), 2)+ Math.pow(this.getLength(3), 2) - Math.pow(this.getLength(2), 2))/(2*this.getLength(1)*this.getLength(3))));
			else
				if(corner == 3)
					return Math.acos(((Math.pow(this.getLength(1), 2)+ Math.pow(this.getLength(2), 2) - Math.pow(this.getLength(3), 2))/(2*this.getLength(1)*this.getLength(2))));
				else
					return -1;

	}
	/**
	 * This will return the perimeter.
	 * @return perimeter The perimeter of the triangle.
	 */
	public double getPerimeter(){
		return getLength(1) + getLength(2) + getLength(3);
	}
	/**
	 * This will return the area.
	 * @return area The area of the triangle.
	 */
	public double getArea(){
		double s = (getPerimeter())/2;
		return Math.sqrt(s*(s - getLength(1))*(s - getLength(2))*(s - getLength(3)));
	}
	/**
	 * This will return a table with all of the triangle's information.
	 * @return table The properly formated table of the triangle's composition.
	 */ 
//	public String getTable(){
//		
//	}
}
