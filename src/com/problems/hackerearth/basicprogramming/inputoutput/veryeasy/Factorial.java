package com.problems.hackerearth.basicprogramming.inputoutput.veryeasy;

import java.util.Scanner;

import com.problems.utils.Log;

/**
 * You have been given a positive integer N. You need to find
 * and print the Factorial of this number. The Factorial of a
 * positive integer N refers to the product of all number in
 * the range from 1 to N.
 * 
 * @author Bittu
 *
 */
public class Factorial {

	public static void main(String[] args) {
		
		try (Scanner scanner = new Scanner(System.in)) {
			
			Log.logInfo("Enter the number to find the factorial:");
			int number = scanner.nextInt();
			int factorial = 1;
			for (int i = 2; i <= number; i++ ) {
				factorial *= i;
			}
			Log.logInfo("Factorial of {0} is {1}", number, factorial);
		}
	}
}
