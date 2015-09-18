package p18_9_18_10;

import java.util.ArrayList;

public class SubstringGenerator
{
	public static void main(String[] args)
	{
		System.out.println(getSubstrings("test"));
	}

	public static ArrayList<String> getSubstrings(String x){
		return getSubstrings(x, 0, x.length());
	}
	
	private static ArrayList<String> getSubstrings(String x, int start, int end)
	{
		ArrayList<String> returnArray = new ArrayList<String>();
		if(x.substring(start, end).length() == 0){
			returnArray.add(" ");
			return returnArray;
		}
		
		if(x.substring(start, end).length() == 1){
			returnArray = getSubstrings(x, start + 1, x.length());
			returnArray.add(x.substring(start, end));
			return returnArray;
		}
		
		returnArray = getSubstrings(x, start, end - 1);
		returnArray.add(x.substring(start, end));
		return returnArray;
	}
}