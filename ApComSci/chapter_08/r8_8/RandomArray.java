package r8_8;

import java.util.Arrays;

public class RandomArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = new int[10];
		for(int i = 0; i < 10; i++)
			array[i] = getRandom();
		System.out.println(Arrays.toString(array));
	}
	
	public static int getRandom(){
		return (int)(Math.random() * ((100) + 1));
	}
}
