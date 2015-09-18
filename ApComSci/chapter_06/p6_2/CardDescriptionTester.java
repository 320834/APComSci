package p6_2;

import java.util.Scanner;

public class CardDescriptionTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner k = new Scanner(System.in);
		System.out.println("Enter the card notation:");
		CardDescription asdf = new CardDescription(k.nextLine());
		System.out.println(asdf.getDescription());
		k.close();
	}

}
