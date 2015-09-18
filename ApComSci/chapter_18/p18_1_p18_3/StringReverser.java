package p18_1_p18_3;

public class StringReverser
{
	public static void main(String[] args)
	{
		System.out.println("Expected Result : !olleH");
		System.out.println("Recursive: " + reverse("Hello!"));
		System.out.println("Iterative: " + reverseIteratively("Hello!"));
	}
	
	public static String reverse(String toReverse)
	{
		if(toReverse.length() == 1)
			return toReverse;
		
		String a = toReverse.substring(0, 1);
		String b = reverse(toReverse.substring(1));
		
		return b + a;
	}
	
	public static String reverseIteratively(String toReverse)
	{
		String a = "";
		for(int i = toReverse.length()-1; i >=0; i--){
			a += toReverse.charAt(i);
		}
		
		return a;
	}
}