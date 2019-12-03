package com.problems.hackerearth.basicprogramming.inputoutput.easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.problems.utils.Constants;
import com.problems.utils.Log;

/**
 * <p>You are given an array A of size N that contains integers.
 * Here, N is an even number. You are required to perform the
 * following operations:</p>
 * 
 * <p>1. Divide the array of numbers in two equal halves<br>
 * Note: Here, two equal parts of a test case are created by
 * dividing the array into two equal parts.<br>
 * 2. Take the first digit of the numbers that are available in
 * the first half of the array (first 50% of the test case)<br>
 * 3. Take the last digit of the numbers that are available in
 * the second half of the array (second 50% of the test case)<br>
 * 4. Generate a number by using the digits that have been selected
 * in the above steps</p>
 * <p>Your task is to determine whether the newly-generated
 * number is divisible by 11.</p>
 * <p><b>Input format</b><br>
 * • First line: A single integer N denoting the size of array A<br>
 * • Second line: N space-separated integers denoting the elements
 * of array A</p>
 * <p><b>Output format</b><br>
 * If the newly-generated number is divisible by 11, then print OUI.
 * Otherwise, print NON.</p>
 * <p><b>Constraints</b><br>
 * 1 <= N <= 10^5<br>
 * 1 <= A[i] <= 10^5</p>
 * @author Bittu
 *
 */
public class Divisible {

	public static void main(String[] args) {
		
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
			
			int sizeOfArray = Integer.parseInt(reader.readLine());
			String[] array = reader.readLine().split(Constants.EMPTY_SPACE);
			if (isDivisible(sizeOfArray, array)) {
			    Log.logInfo("OUI");
			} else {
				Log.logInfo("NON");
			}
		} catch (IOException e) {
			Log.logInfo(e.getMessage());
		}
	}

	private static boolean isDivisible(int sizeOfArray, String[] array) {
		
		if (sizeOfArray == array.length) {
			
			int odd = 0;
			int even = 0;
			int half = sizeOfArray >> 1;
			for (int i = 0; i < sizeOfArray; i++) {
				int first = 0;
				int last = 0;
				if (i < half) {
					first = Integer.parseInt(array[i].charAt(0)+"");
				} else {
					last = Integer.parseInt(array[i].charAt(array[i].length() - 1)+"");
				}
				if (i % 2 == 0) {
					odd += first + last;
				} else {
					even += first + last;
				}
			}
			return (odd - even) % 11 == 0;
		}
		return false;
	}
}
