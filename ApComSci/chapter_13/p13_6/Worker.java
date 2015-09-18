package p13_6;

public abstract class Worker {
	private String name;
	private double salaryRate;
	
	public Worker(String n, double s){
		name = n;
		salaryRate = s;
	}
	
	public String getName(){
		return name;
	}
	
	public double getHourlySalary(){
		return salaryRate;
	}
	
	public abstract double computePay(int hours);
}
