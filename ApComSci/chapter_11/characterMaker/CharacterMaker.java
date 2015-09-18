package characterMaker;

public interface CharacterMaker
{
	/**
	 * Returns a 10 x 10 array containing the ASCII representation of character,
	 * or null if  character is not supported.
	 * @param character the character to convert to ASCII art
	 * @return the ASCII art representation of character
	 */
	char[][] characterToAscii(char character);
	
	/**
	 * Returns true if the specified character is supported, false otherwise.
	 * @param character the character to check
	 * @return true if the specified character is supported, false otherwise.
	 */
	boolean characterSupported(char character);
	
	/**
	 * Returns the characters that this CharacterMaker can convert to ASCII art.
	 * @return an array containing the supported characters
	 */
	char[] supportedCharacters();
}
