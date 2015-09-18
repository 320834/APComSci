package p3_6;
/**
 * 
 * @author 320951
 *Exercise P3.6. Implement a class Car with the following properties. A car has a certain
fuel efficiency (measured in miles/gallon or liters/km-pick one) and a certain
amount of fuel in the gas tank. The efficiency is specified in the constructor, and the
initial fuel level is o. Supply a method drive that simulates driving the car for a
certain distance, reducing the fuel level in the gas tank. Also supply methods getGas,
returning the current fuel level, and addGas, to tank up. Sample usage:
Car myHybri d = new Car (49); I I 49 miles per gallon
myHybri d. addGas (20); II Tank 20 gallons
myHyb ri d . d ri ve (100); II Drive 100 miles
System. out. pri ntl n(myHybri d. getGasO); II Printfuel remaining
 */
public class Car {
	private double efficiency, fuel;
	public Car(double e){
		efficiency = e;
		fuel = 0;
	}
	/**
	 * This returns the fuel level
	 * @return fuel the fuel in gallons
	 */
	public double getGas(){
		return fuel;
	}
	/**
	 * This adds gallons to the fuel level
	 * @param gas number of gallons to be added to fuel level
	 */
	public void addGas(double gas){
		fuel += gas;
	}
	/**
	 * This simulates driving a distance and removing fuel
	 * @param distance the distance being simulated in miles
	 */
	public void drive(double distance){
		fuel -= distance/efficiency;
	}
}
