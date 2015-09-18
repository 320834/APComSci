package p3_11;
/**
 * Exercise P3.11. Implement a class SodaCan with methods getSurfaceAreaO and
getVo 1 ume O. In the constructor, supply the height and radius of the can.
 * @author 320951
 *
 */
public class SodaCan {
	private double height, radius;
	public SodaCan(double h, double r){
		height = h;
		radius = r;
	}
	/**
	 * Gets Surface Area of soda can.
	 * @return area surface area of soda can
	 */
	public double getSurfaceArea(){
		double area = (2*3.14*radius*height) + (2*3.14*radius*radius);
		return area;
	}
	/**
	 * Gets volume of soda can
	 * @return volume volume of soda can
	 */
	public double getVolume(){
		double volume = 3.14*radius*radius*height;
		return volume;
	}
}
