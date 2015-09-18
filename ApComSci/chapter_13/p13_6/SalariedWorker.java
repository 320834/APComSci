package p13_6;

public class SalariedWorker extends Worker{
	public SalariedWorker(String n, double s){
		super(n, s);
	}
	
	public double computePay(int hours){
		return 40.0 * getHourlySalary();
	}
}
