package com.problems.others;

import java.util.Arrays;
import java.util.stream.IntStream;

public class BuildPalindromicString {

	public static void main(String[] args) {
		
		String str = "lhjaldfjlncninaourkvn";
//		str = "aabbcc";
		System.out.println(buildLongestPalindrome(str));
	}
	/**
	 * If string is <b><i>adskassda</i></b> then this method
	 * will return <b><i>adsasda</i></b>
	 * @param str
	 * @return
	 */
	private static String buildLongestPalindrome(String str) {
		
		if (str == null || str.isEmpty()) {
			return null;
		}
		/*
		 * Below I am getting character array from the string
		 * and trying to sort that array so that we can create
		 * sorted palindrome.
		 **/
		char[] charArray = str.toCharArray();
		Arrays.sort(charArray);
		int charCount = 0;
		char midChar = 0;
		char prevChar = charArray[0];
		StringBuilder palindromicString = new StringBuilder();
		/*
		 * Below we are iterating over the sorter character array
		 * and creating palidromic string. Also I am building a
		 * string with those characters which does not repeat or
		 * repeated odd times. This will help to get the first
		 * sorted character to add in the palindromic string.
		 **/
		for (char c: charArray) {
			if (prevChar != c) {
				
				midChar = populateAndGetMidCharacter(midChar,
						palindromicString, charCount, prevChar);
				prevChar = c;
				charCount = 0;
			}
			charCount++;
		}
		/*
		 * In case of last character which we have calculated
		 * in the previous for loop, we need to insert that
		 * in the middle of a palindromic string.
		 **/
		midChar = populateAndGetMidCharacter(midChar,
				palindromicString, charCount, prevChar);
		if (midChar != 0) {
			int offset = getMidIndex(palindromicString);
			palindromicString.insert(offset, midChar);
		}
		return palindromicString.toString();
	}
	/**
	 * Method to populate the selected character into the
	 * middle of a palindromic string and returns the
	 * selected character if that character count is odd
	 * and midChar variable is empty.
	 * 
	 * @param midChar
	 * @param palindromicString
	 * @param charCount
	 * @param selectedChar
	 * @return midChar
	 */
	private static char populateAndGetMidCharacter(char midChar,
			StringBuilder palindromicString, int charCount,
			char selectedChar) {
		
		if (charCount % 2 != 0) {
			charCount--;
			if (midChar == 0) {
				midChar = selectedChar;
			}
		}
		int offset = getMidIndex(palindromicString);
		IntStream.range(0, charCount)
			.forEach(i -> palindromicString.insert(offset, selectedChar));
		return midChar;
	}
	private static int getMidIndex(StringBuilder builder) {
		int mid = 0;
		int size = builder.length();
		if (size > 0) {
			mid = size / 2;
		}
		return mid;
	}
}
