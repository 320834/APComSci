package r8_4;

import java.util.Scanner;

public class ReverseaArrayList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner k = new Scanner(System.in);
		String[] array = new String[10];
		for(int i =0; i < 10; i++){
			System.out.print("Enter String: ");
			array[i] = k.nextLine();
		}
		
		for(int i = 9; i >=0; i--)
			System.out.println(array[i]);
		k.close();
	}

}
