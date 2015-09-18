package p4_12;

public class DigitExtractor {
/**
 * Exercise P4.12. Write a program that reads in an integer and breaks it into a sequence
of individual digits in reverse order. For example, the input 16384 is displayed as
4
8
3
6
1
You may assume that the input has no more than five digits and is not negative.
 */
	private int integer, currentDigit;
	private String s;
	public DigitExtractor(int anInteger){
		integer = anInteger;
		s = ""+integer;
		currentDigit = s.length();
	}
	public int nextDigit(){
		currentDigit--;
		return Integer.parseInt(s.substring(currentDigit, currentDigit + 1));
	}
}
