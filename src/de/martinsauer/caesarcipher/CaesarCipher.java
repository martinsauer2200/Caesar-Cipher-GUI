package de.martinsauer.caesarcipher;

public class CaesarCipher {
	
	private String charList = "abcdefghijklmnopqrstuvwxyz1234567890ABCDEFGHIJKLMNOPQRSTUVWXYZ .,:;!?()";
	
	/**
	 * Encrypt a string by shifting through a list of characters.
	 * 
	 * @param decryptedText
	 * @param shiftValue number of characters to shift
	 * @return encrypted text
	 */
	public String encrypt(String decryptedText, int shiftValue) {
		String encryptedText = "";
		for (int i = 0; i <= decryptedText.length()-1; i++) {
			encryptedText += shift(decryptedText.charAt(i), shiftValue);
		}
		return encryptedText;
	}
	
	/**
	 * Decrypt a string by shifting through a list of characters.
	 * 
	 * @param encryptedText
	 * @param shiftValue number of characters to shift
	 * @return decrypted text
	 */
	public String decrypt(String encryptedText, int shiftValue) {
		String decryptedText = "";
		for (int i = 0; i <= encryptedText.length()-1; i++) {
			decryptedText += shift(encryptedText.charAt(i), shiftValue);
		}
		return decryptedText;
	}
	
	/**
	 * Function to realize the shifting.
	 * 
	 * @param character
	 * @param shiftValue
	 * @return character after shifting
	 */
	private char shift(char character, int shiftValue) {
		int index = charList.indexOf(character);
		index += shiftValue; 
		if (index > charList.length()-1) {
			index -= charList.length();
		}
		if (index < 0) {
			index += charList.length();
		}
		return charList.charAt(index);
	}
}