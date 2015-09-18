package p6_16;
/**
 * Exercise P6.16. Write a program that reads in the name and hourly wage of an
employee. Then ask how many hours the employee worked in the past week. Be
sure to accept fractional hours. Compute the pay. Any overtime work (over 40
hours per week) is paid at 150 percent of the regular wage. Solve this problem by
implementing a class Paycheck.
 * @author 320951
 *
 */
public class Paycheck {
	private double hours, wage;
	private String name;
	public Paycheck(double work, String name, double hourlyWage){
		hours = work;
		this.name = name;
		wage = hourlyWage;
	}
	/**
	 * calculates pay
	 * @return The pay
	 */
	public double calculate(){
		if(hours > 40)
			return ((hours - 40)*(wage*1.5)) + (40 * wage);
		else 
			return hours*wage;
	}
	/**
	 * returns employee name
	 * @return name employee name
	 */
	public String getName(){
		return name;
	}
}
