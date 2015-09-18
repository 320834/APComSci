package r8_3;

import java.util.Scanner;

public class MinMaxTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner k = new Scanner(System.in);
		System.out.print("Enter the number of elements: ");
		double[] array = new double[k.nextInt()];
		k.nextLine();
		for(int i = 0; i < array.length; i++){
			System.out.println("Enter a term: ");
			array[i] = k.nextDouble();
			k.nextLine();
		}
		MinMax test = new MinMax(array);
		System.out.println("Max: " + test.getMax() + "\nMin: " + test.getMin());
		k.close();
	}

}
