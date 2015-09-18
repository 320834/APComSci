package p10_12;

public class Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Numeric.approxEqual(1, 1));
		System.out.println(Numeric.approxEqual(1, 1.00000000000000000000000000000000001));
		
		RootApproximator test = new RootApproximator(16);
		System.out.println(test.getRoot());				//x0 is not ever initialized before hand so it is Infinity breaking the Numeric class causing it to loop infinitely
		}

}
