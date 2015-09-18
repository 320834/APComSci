package r4_4;

public class IntegerOverflow {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x = Integer.MAX_VALUE;
		System.out.println(x);
		System.out.println(x + 1);
		/*
		 * No, the floating point has a lower max value.

double x = 2.45;
x = (int) x*100;		//x is not 245 but a little below 245(244.9999)

No, it would work fine.

		 */
	}

}
