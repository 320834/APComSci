package r8_7;

import java.util.Arrays;
import java.util.Scanner;

public class FillArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner k = new Scanner(System.in);
		System.out.print("Enter the number of elements: ");
		double[] array = new double[k.nextInt()];
		k.nextLine();
		for(int i = 0; i < array.length; i++){
			System.out.print("Enter a term: ");
			array[i] = k.nextDouble();
			k.nextLine();
		}
		System.out.println(Arrays.toString(array));
		k.close();
	}

}
