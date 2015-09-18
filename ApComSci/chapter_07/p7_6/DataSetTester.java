package p7_6;

import java.util.Scanner;

public class DataSetTester {
/**
 * This takes in user input and prints Mean & Standard Deviation
 * @param args
 */
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		DataSet set = new DataSet();
		System.out.println("How many numbers do you want to enter?");
		int count = Integer.parseInt(keyboard.nextLine());
		for(int i = 0; i < count; i++){
			System.out.println("Enter a number...");
			set.add(Integer.parseInt(keyboard.nextLine()));
		}
		System.out.println("Count: " + count + "\nMean: " + set.getMean()+"\nStandard Deviation: " + set.getStandardDeviation());
		keyboard.close();
	}
}
