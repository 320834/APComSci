package pigLatin;

import java.util.ArrayList;

public class PigLatinII {
	private ArrayList<String> splitted = new ArrayList<String>();

	/**
	 * Creates a version of the input split up into pieces
	 * @param keyWord input in english
	 */
	public PigLatinII(String keyWord) {
		splitted = splitIt(keyWord);
	}

	/**
	 * This takes the input phrase and turns it into an arraylist split up by spaces, commas, periods, question marks, exclamation marks, semicolon, colons, quotes, prantheses, and hyphens.
	 * @param englishWord phrase in english
	 * @return version of input phrase split up into pieces according to dilineators
	 */
	public static ArrayList<String> splitIt(String englishWord) {
		int pos = 0;
		ArrayList<String> splittedUp = new ArrayList<String>();
		for (int i = pos; i < englishWord.length(); i++)
			if (isDelineator(englishWord.substring(i, i+1))) {
				
				splittedUp.add(englishWord.substring(pos, i + 1));
				pos = i + 1;
			}
		splittedUp.add(englishWord.substring(pos) + " ");		//To get the very last word. The space is to avoid errors properly translating the last word into pig latin
		return splittedUp; 
	}

	/**
	 * Translates from enlish to pig latin
	 * @return pig latin translation
	 */
	public String translate() {
		String pigLatin = "";
		for (int i = 0; i < splitted.size(); i++) {
			if(splitted.get(i).length() == 1 && isDelineator(splitted.get(i)))
				pigLatin += splitted.get(i);
			else if (isVowel(splitted.get(i).charAt(0)))
				pigLatin += splitted.get(i).substring(0, splitted.get(i).length() - 1) + "yay" + splitted.get(i).charAt(splitted.get(i).length()-1);
			else if (!hasVowel(splitted.get(i)))
				pigLatin += splitted.get(i).substring(0, splitted.get(i).length() - 1) + "ay" + splitted.get(i).charAt(splitted.get(i).length()-1);
			else {
				String start = splitted.get(i).substring(0, firstVowel(splitted.get(i)));
				String end = splitted.get(i).substring(firstVowel(splitted.get(i)), splitted.get(i).length() - 1);
				if(start.charAt(0) != start.toLowerCase().charAt(0)){
					start = start.toLowerCase();
					end = end.toUpperCase().charAt(0) + end.substring(1);
				}
				pigLatin += end + start + "ay" + splitted.get(i).charAt(splitted.get(i).length() - 1);
			}
		}
		
		return pigLatin;
	}

	/**
	 * Checks to see if char is a delineator
	 * @param check char (in string form) to check for delineateor
	 * @return true if delineator, false if otherwise
	 */
	public static boolean isDelineator(String check){
		return check.charAt(0) == ' ' 
				|| check.charAt(0) == ','
				|| check.charAt(0) == '.'
				|| check.charAt(0) == '?'
				|| check.charAt(0) == '!'
				|| check.charAt(0) == ';'
				|| check.charAt(0) == ':'
				|| check.charAt(0) == '"'
				|| check.charAt(0) == '('
				|| check.charAt(0) == ')'
				|| check.charAt(0) == '-';

	}
	
	/**
	 * Checks to see where the first vowel of a word is
	 * @param word word to be checked
	 * @return index of vowel, -1 if it doesn't exist;
	 */
	public static int firstVowel(String word) {
		for (int i = 0; i < word.length(); i++) {
			if (isVowel(word.charAt(i)))
				return i;
		}
		return -1;
	}

	/**
	 * Checks to see if a word has a vowel
	 * @param test word to be checked
	 * @return true if ther is a vowel, false otherwise
	 */
	public static boolean hasVowel(String test) {
		for (int i = 0; i < test.length(); i++)
			if (isVowel(test.charAt(i)))
				return true;
		return false;
	}

	/**
	 * Checks to see if a char is a vowel
	 * @param test char to be tester
	 * @return true if is a vowel, false if not vowel
	 */
	public static boolean isVowel(char test) {
		return test == 'a' || test == 'e' || test == 'i' || test == 'o'
				|| test == 'u' || test == 'A' || test == 'E' || test == 'I'
				|| test == 'O' || test == 'U';
	}

}