package r8_10;

import java.util.Arrays;

public class UnfilledArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = new int[20];
		array[0] = 1;
		array[1] = 4;
		array[2] = 9;
		
		System.out.println(Arrays.toString(array));			//The rest of the array is filled with zeroes
	}

}
