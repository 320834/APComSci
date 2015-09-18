package p13_5;

public class Manager extends Employee{
	private String department;
	
	public Manager(String name, double salary, String dept){
		super(name, salary);
		department = dept;
	}
	
	public String getDepartment(){
		return department;
	}
	
	public String toString(){
		return "Manager[Name: " + getName() + ", Salary: $" + getSalary() + ", Department: " + getDepartment() + "]";
	}
}
