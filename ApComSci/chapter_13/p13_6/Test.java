package p13_6;

public class Test {

	public static void main(String[] args) {
		Worker test = new SalariedWorker("Bob", 5);
		System.out.println(test.computePay(234));
		System.out.println(test.computePay(20));
		
		test = new HourlyWorker("Sam", 5);
		System.out.println(test.computePay(40));
		System.out.println(test.computePay(60));
	}

}
