package com.problems.hackerearth.basicprogramming.inputoutput.veryeasy;

import java.util.Objects;
import java.util.Scanner;

import com.problems.utils.Log;
 
/**
 * You are required to enter a word that consists of  and  that
 * denote the number of Zs and Os respectively. The input word
 * is considered similar to word zoo if .
 * Determine if the entered word is similar to word zoo.
 * For example, words such as zzoooo and zzzoooooo are similar
 * to word zoo but not the words such as zzooo and zzzooooo.
 * 
 * @author Bittu
 *
 */
class Zoos {
	
    public static void main(String args[] ) {
		
		try(Scanner scanner = new Scanner(System.in)) {
			
			Log.logInfo("Input: ");
			String word = scanner.nextLine();
			if (Objects.nonNull(word) && word.length() < 21) {
				
				int zCount = 0;
				int oCount = 0;
				for (int i = 0; i < word.length(); i++) {
					
					char cha = word.charAt(i);
					if ('z' ==cha) {
						zCount++;
					} else if ('o' == cha) {
						oCount++;
					}
				}
				if ((zCount * 2) == oCount) {
					Log.logInfo("Yes");
				} else {
					Log.logInfo("No");
				}
			}
		}
	
    }
}