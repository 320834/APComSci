package p3_4;
/**
 * Exercise P3.4. Implement a class Employee. An employee has a name (a string) and a
salary (a double). Write a default constructor, a constructor with two parameters
(name and salary), and methods to return the name and salary. Write a small program
that tests your class.
 * @author 320951
 *
 */
public class Employee {
	private String name;
	private double salary;
	public Employee(){
		name = null;
		salary = 0;
	}
	public Employee(String n, double s){
		name = n;
		salary = s;
	}
	public String getName() {
		return name;
	}
	public double getSalary() {
		return salary;
	}
}
