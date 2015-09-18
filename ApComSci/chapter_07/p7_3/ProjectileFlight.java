package p7_3;
/**
 * Exercise P7.3. Projectile flight. Suppose a cannonball is propelled vertically into the
air with a starting velocity Va. Any calculus book will tell us that the ~osition of the
ball after t seconds is s(t) = -0.5· g' t2 + va . t, where g = 9.81 m/sec is the gravitational
force of the earth. No calculus book ever mentions why someone would
want to carry out such an obviously dangerous experiment, so we will do it in the
safety of the computer. ~
In fact, we will confirm the theorem from calculus by a simulation. In our simulation,
we will consider how the ball moves in very short time intervals b.t. In a short
time interval the velocity V is nearly constant, and we can compute the distance the
ball moves as b.s = V · M. In our program, we will simply set
double del taT = 0.01;
and update the position by
5 = 5 + v'" deltaT;
The velocity changes constantly-in fact, it is reduced by the gravitational force of
the earth. In a short time interval, v decreases by g . b.t, and we must keep the
velocity updated as
v = v - 9 * del taT;
In the next iteration the new velocity is used to update the distance.
Now run the simulation until the cannonball falls back to the earth. Get the initial
velocity as an input (100 m/sec is a good value). Update the position and velocity
100 times per second, but only print out the position every full second. Also print
out the values from the exact formula s(t) = -0.5 . g . t2 + va . t for comparison. Use
a class Cannonball .
What is the benefit of this kind of simulation when an exact formula is available?
Well, the formula from the calculus book is not exact. Actually, the gravitational
force diminishes the farther the cannonball is away from the surface of the earth.
This complicates the algebra sufficiently that it is not possible to give an exact formula
for the actual motion, but the computer simulation can simply be extended to
apply a variable gravitational force. For cannonballs, the calculus-book formula is
actually good enough, but computers are necessary to compute accurate trajectories
for higher-flying objects such as ballistic missiles.
 * @author 320951 - Saikiran Nakka
 *
 */
public class ProjectileFlight {
	@SuppressWarnings("unused")
	private double deltaT = 0.01, velocity, position = 0, time = 0 ;
	public static final double GRAVITY = 9.81;
	
	/**
	 * Initializes velocity
	 * @param v
	 */
	public ProjectileFlight(double v){
		velocity = v;
	}
	
	public void nextIteration(){
		position = position + velocity * deltaT;
		velocity = velocity - GRAVITY * deltaT;	
	}
	
	public double getPosition(){
		return position;
	}
	}
