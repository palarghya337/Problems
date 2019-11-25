package com.problems.hackerearth.basicprogramming.inputoutput.veryeasy;

import java.util.Scanner;

import com.problems.utils.Log;
/**
 * You have been given a String S consisting of uppercase and
 * lowercase English alphabets. You need to change the case of
 * each alphabet in this String. That is, all the uppercase
 * letters should be converted to lowercase and all the
 * lowercase letters should be converted to uppercase. You need
 * to then print the resultant String to output.
 * 
 * @author Bittu
 *
 */
public class ToggleString {

	public static void main(String[] args) {

		try (Scanner scanner = new Scanner(System.in)) {

			String someString = scanner.nextLine();
			StringBuilder changedString = new StringBuilder(someString);
			for (int i = 0; i < someString.length(); i++) {

				char cha = someString.charAt(i);
				if (Character.isUpperCase(cha)) {
					changedString.setCharAt(i, Character.toLowerCase(cha));
				} else {
					changedString.setCharAt(i, Character.toUpperCase(cha));
				}
			}
			Log.logInfo(changedString);
		}
	}
}
