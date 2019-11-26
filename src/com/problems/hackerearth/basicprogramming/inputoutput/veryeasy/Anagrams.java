package com.problems.hackerearth.basicprogramming.inputoutput.veryeasy;

import java.util.Scanner;

import com.problems.utils.Log;

/**
 * Given two strings, a and b , that may or may not be of the same
 * length, determine the minimum number of character deletions
 * required to make a and b anagrams. Any characters can be deleted
 * from either of the strings.
 * <p><b>Input :</b><br>
 * test cases,t two strings a and b, for each test case<br>
 * <b>Output:</b><br>
 * <b>Desired O/p</b><br>
 * <b>Constraints :</b><br>
 * string lengths<=10000<br>
 * <b>Note :</b><br>
 * Anagram of a word is formed by rearranging the letters of the word.
 * <br><b>For e.g.</b> -> For the word RAM - MAR,ARM,AMR,RMA etc. are
 * few anagrams.
 * 
 * @author Bittu
 *
 */
public class Anagrams {

	public static void main(String[] args) {
		
		try (Scanner scanner = new Scanner(System.in)) {

			int testCaseNumber = Integer.parseInt(scanner.nextLine());
			while (testCaseNumber != 0) {

				String str1 = scanner.nextLine();
				String str2 = scanner.nextLine();
				/* make hash array for both string and calculate frequency
				 * of each character.
				 **/ 
				int[] countArr = new int[26];  
				// count frequency of each character in first string 
				for (int i = 0; i < str1.length() ; i++)
					countArr[str1.charAt(i) - 'a']++;
				// count frequency of each character in second string 
				for (int i = 0; i < str2.length() ; i++) 
					countArr[str2.charAt(i) -'a']--;
				// traverse count arrays to find number of characters to be removed 
				int result = 0;
				for (int i = 0; i < 26; i++) 
					result += Math.abs(countArr[i]);
				Log.logInfo(result);
				testCaseNumber--;
			}
		}
	}

}
