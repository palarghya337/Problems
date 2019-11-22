package com.problems.hackerearth;

import java.util.Scanner;

import com.problems.utils.Log;

/**
 * You have been given a String S. You need to find and print
 * whether this string is a palindrome or not. If yes, print
 * "YES" (without quotes), else print "NO" (without quotes).
 * 
 * @author Bittu
 *
 */
public class PalindromicString {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			
			String someString = scanner.nextLine();
//			findPalindromicString(someString);
			findPalindromicString2(someString);
		}
	}

	private static void findPalindromicString2(String someString) {
		
		boolean isPalindrome = true;
		int stringLength = someString.length() - 1;
		for (int i = 0; i < someString.length()/2 - 1; i++) {
			
			char char1 = someString.charAt(i);
			char char2 = someString.charAt(stringLength--);
			if (char1 != char2) {
				Log.logInfo("Not palindrom string.");
				isPalindrome = false;
				break;
			}
		}
		if (isPalindrome) {
			Log.logInfo("Palindrom string.");
		}
	}
	private static void findPalindromicString(String someString) {

		StringBuilder dupString = new StringBuilder();
		for (int i = someString.length() - 1; i >= 0; i--) {
			dupString.append(someString.charAt(i));
		}
		if (someString.equals(dupString.toString())) {
			Log.logInfo("Palindrom string.");
		} else {
			Log.logInfo("Not palindrome string.");
		}
	}
}
