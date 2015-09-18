package pigLatin;

import java.util.Scanner;

public class Translator {
	static Scanner k = new Scanner(System.in);
	static PigLatinII translator;
	
	public static void main(String[] args) {
		System.out.println("Welcome to the Enlish - Pig Latin Translator");
		translate();
	}
	
	public static void translate(){
		System.out.println("What would you like to translate into Pig Latin?");
		translator = new PigLatinII(k.nextLine());
		System.out.println("\nPig Latin: " + translator.translate());
		System.out.println("Would you like to translate again?(y/n)");
		if(k.nextLine().equalsIgnoreCase("y"))
			translate();
		else
			System.out.println("Good-Bye");
	}
}
