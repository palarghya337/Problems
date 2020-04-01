package com.problems.others;

public class ReverseString {

	public static void main(String[] args) {
		String s = "1jbcD%opaa12)(";
		reverse(s.toCharArray());
	}

	/**
	 * This method will reverse a string without changing
	 * the special characters position.
	 * @param character
	 */
	private static void reverse(char[] character) {
		
		if (character != null) {
			
			int i = 0;
			int j = character.length - 1;
			while (i < j) {
				
				char iThCharacter = character[i];
				char jThCharacter = character[j];
				boolean isISatisfies = Character.isLetterOrDigit(iThCharacter);
				boolean isJSatisfies = Character.isLetterOrDigit(jThCharacter);
				if (isISatisfies && isJSatisfies) {
					
					character[i] = jThCharacter;
					character[j] = iThCharacter;
					i++;
					j--;
				}
				if (!isISatisfies) {
					i++;
				}
				if (!isJSatisfies) {
					j--;
				}
			}
			System.out.println(new String(character));
		}
	}
}
