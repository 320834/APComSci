package p18_4;

public class Finder
{
	public static void main(String[] args)
	{
	    System.out.println(find("Hello", "lo"));
	}
	
	public static boolean find(String toSearch, String toFind)
	{
		if(toSearch.length() < toFind.length())
			return false;
	  
		if(toSearch.startsWith(toFind))
	    	return true;
	    
	    return find(toSearch.substring(1), toFind);
	}
}
