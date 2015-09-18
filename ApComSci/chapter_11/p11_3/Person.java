package p11_3;

public class Person implements Measurable{
	private double height;
	private String name;
	
	public Person(String n, int h){
		height = h;
		name = n;
	}
	
	public double getHeight(){
		return height;
	}
	
	public String getName(){
		return name;
	}
	
	public double getMeasure(){
		return getHeight();
	}
}
