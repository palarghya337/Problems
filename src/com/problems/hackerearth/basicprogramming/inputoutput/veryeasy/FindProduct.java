package com.problems.hackerearth.basicprogramming.inputoutput.veryeasy;

import java.util.Scanner;

import com.problems.utils.Constants;
import com.problems.utils.Log;

/**
 * You have been given an array A of size N consisting of positive
 * integers. You need to find and print the product of all the
 * number in this array Modulo.
 * Input Format:
 * The first line contains a single integer N denoting the size of
 * the array. The next line contains N space separated integers
 * denoting the elements of the array
 * Output Format:
 * Print a single integer denoting the product of all the elements
 * of the array Modulo.
 * 
 * @author Bittu
 *
 */
class FindProduct {
    public static void main(String args[] ) throws Exception {
        
        try (Scanner scanner = new Scanner(System.in)) {
			
			int sizeOfArray = Integer.parseInt(scanner.nextLine());
			String data = scanner.nextLine();
			String[] arrayElements = data.split(Constants.EMPTY_SPACE);
			findProduct(sizeOfArray, arrayElements);
		}
    }
    private static void findProduct(int sizeOfArray, String[] arrayElements) {
		
		if (sizeOfArray != arrayElements.length) {
			
			Log.logInfo("Invalid number of elements.");
			return;
		}
		long output = 1;
		for (int i = 0; i < sizeOfArray; i++) {
			
			Integer element = Integer.parseInt(arrayElements[i]);
			output = (output * element) % 1000000007;
		}
		Log.logInfo(output);
	}
}
