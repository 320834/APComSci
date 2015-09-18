package project9_2;

/**
 * The ZipBar class has two functions
 * 1. It can take bar codes in the form of a string and turn it into an int zipcode
 * 2. It can take an int zipcode and turn it into a String bar code
 * 
 * @author 320951 - Saikiran Nakka, 174363 - Stephen Hitchcock
 */
public class ZipBar {
	
	/**
	 * Converts a bar code to a zip code (#####)
	 * @param bar String to be converted to ZipCode
	 * @return Bar code in zip code form (#####)
	 */
	public static String getZip(String bar){
		final int BLOCK_LENGTH = 5;
		String zip = "";
		
		for(int i = 1; i < bar.length() - BLOCK_LENGTH - 1; i += BLOCK_LENGTH)
			switch(bar.substring(i, i + 5))
			{
			case ":::||":
				zip += 1;
				break;
			case "::|:|":
				zip += 2;
				break;
			case "::||:":
				zip += 3;
				break;
			case ":|::|":
				zip += 4;
				break;
			case ":|:|:":
				zip += 5;
				break;
			case ":||::":
				zip += 6;
				break;
			case "|:::|":
				zip += 7;
				break;
			case "|::|:":
				zip += 8;
				break;
			case "|:|::":
				zip += 9;
				break;
			case "||:::":
				zip += 0;
				break;
			}
		return zip;
	}
	
	/**
	 * Converts a zip code (#####) to a bar code
	 * @param zip zip code in form (#####)
	 * @return String version of Bar Code using '|' for full bar and ':' for half bar
	 */
	public static String getBar(int zip){
		final int ZIPCODELENGTH = 5;
		String barCode = "|";
		String zipString = "" + zip;
		
		while(zipString.length() < 5)
			zipString = "0" + zipString;
		
		for(int i = 0; i < ZIPCODELENGTH; i++)
		{
			barCode += intToString(Integer.parseInt("" + zipString.charAt(i)));
		}
		barCode += intToString(getCheck(zipString)) + "|";
		return barCode;
	}
	
	/**
	 * Gets the check digit for the bar code
	 * @param zip zip code to get the check digit for
	 * @return check digit as an integer
	 */
	public static int getCheck(String zip){
		return 10 - ((Integer.parseInt(zip.substring(0, 1)) + Integer.parseInt(zip.substring(1, 2)) + Integer.parseInt(zip.substring(2, 3)) + Integer.parseInt(zip.substring(3, 4)) + Integer.parseInt(zip.substring(4))) % 10);
	}
	
	/**
	 * Converts a number to it's Bar Code counterpart
	 * @param num number to convert to bar code block
	 * @return block of bars for each individual digit
	 */
	public static String intToString(int num)
	{
		switch (num)
		{
		case 1: 
			return ":::||";
		case 2:
			return "::|:|";
		case 3:
			return "::||:";
		case 4:
			return ":|::|";
		case 5: 
			return ":|:|:";
		case 6:
			return ":||::";
		case 7:
			return "|:::|";
		case 8:
			return "|::|:";
		case 9: 
			return "|:|::";
		case 0:
			return "||:::";
		}
		return null;
	}
}