package com.problems.hackerearth.basicprogramming.inputoutput.easy;

import java.util.Scanner;

import com.problems.utils.Constants;
import com.problems.utils.Log;

/**
 * Given two strings of equal length, you have to tell whether they
 * both strings are identical. Two strings S1 and S2 are said to be
 * identical, if any of the permutation of string S1 is equal to the
 * string S2. See Sample explanation for more details.
 * <p> Input :<br>
 * First line, contains an integer 'T' denoting no. of test cases.
 * Each test consists of a single line, containing two space
 * separated strings S1 and S2 of equal length.</p>
 * Output:<br>
 * For each test case, if any of the permutation of string S1 is
 * equal to the string S2 print YES else print NO.

 * @author Bittu
 *
 */
public class TwoStrings {

	public static void main(String[] args) {
		
		try (Scanner scanner = new Scanner(System.in)) {
			
			int index = 0;
			int numberOfTestCases = Integer.parseInt(scanner.nextLine());
			String[] inputs = new String[numberOfTestCases];
			while (numberOfTestCases != index) {
				inputs[index++] = scanner.nextLine();
			}
			showOutput(inputs);
		}
	}

	private static void showOutput(String[] inputs) {
		
		for (int i = 0; i < inputs.length; i++) {

			String[] words = inputs[i].split(Constants.EMPTY_SPACE);
			String str1 = words[0];
			String str2 = words[1];
			int[] countStrings = new int[26];
			/* Below loop is to count the number of characters
			 * and store that into countStrings array.
			 **/
			for (int j = 0; j < str1.length(); j++) {
				countStrings[str1.charAt(j) - 'a']++;
			}
			/* Below loop will decrement the count of same
			 * characters if available in str2 variable.
			 **/
			for (int j = 0; j < str2.length(); j++) {
				countStrings[str2.charAt(j) - 'a']--;
			}
			int result = 0;
			for (int j = 0; j < countStrings.length; j++) {
				result += Math.abs(countStrings[j]);
			}

			if (result == 0) {
				Log.logInfo("YES");
			} else {
				Log.logInfo("NO");
			}
		}
	}
}
