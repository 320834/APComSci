package p7_4;

/**
 * Simulates firing a cannonball with different DeltaT's, Velocities, and Angles
 * @author Zedai - Saikiran Nakka
 * @version 1.3
 */
public class Cannonball {
	
	private double vx, vy, iv, a, xPos = 0, yPos = 0, interval, time = 0;
	public static final double GRAVITY = 9.81;

	/**
	 * Initializes cannonball
	 * @param velocity - Initial velocity of cannonball
	 * @param alpha - anglee in degrees that the cannonball was fired at
	 * @param deltaT - Interval between updates using <code>nextIteration()</code>
	 */
	public Cannonball(double velocity, double alpha, double deltaT){
		interval = deltaT;
		iv = velocity;
		a = alpha;
		vx = iv * Math.cos(Math.toRadians(a));
		vy = iv * Math.sin(Math.toRadians(a));
	}
	
	public void nextIteration(){
		xPos = xPos + vx * interval;
		yPos = yPos + vy * interval;
		vy = vy - GRAVITY * interval;
		time += interval;
		
		if(yPos <= 0)
		{
			yPos =0;
		}
	}
	
	public double getX(){
		return xPos;
	}
	
	public double getY(){
		return yPos;
	}
	
	public double getTime(){
		return time;
	}
}
