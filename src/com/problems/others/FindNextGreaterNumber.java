package com.problems.others;

import java.util.Arrays;

public class FindNextGreaterNumber {

	public static void main(String[] args) {
		FindNextGreaterNumber obj = new FindNextGreaterNumber();
		int number = 4765;
		System.out.println(number);
		System.out.println(obj.findNextGreaterNumber(number));
		
	}
	/**
	 * Method to find the next number of a number by using the
	 * same digits given in the number.
	 * @param number
	 * @return
	 */
	public int findNextGreaterNumber(int number) {
		
		String empty = " ";
		String numberString = empty;
		while (number != 0) {
			
			int remainder = number % 10;
			number = number / 10;
			numberString = numberString
					.replace(empty, empty + remainder);
		}
		char[] numberArrCh = numberString.trim()
				.toCharArray();
		int index = -1;
		int size = numberArrCh.length;
		/*
		 * Bellow I am trying to find the digit which is
		 * smaller than the previously traversed digit.
		 * if found any then copy that index in the "index"
		 * variable.
		 **/
		for (int i = size - 1; i > 0; i--) {
			if (numberArrCh[i] > numberArrCh[i - 1]) {
				index = i - 1;
				break;
			}
		}
		/*
		 * If I do not find any digit which is smaller than
		 * the previously traversed digit then return -1.
		 **/
		if (index == -1) {
			return index;
		}
		/*
		 * Here I am trying to find the smallest digit which
		 * is greater than the above found index digit.
		 **/
		int small = index + 1;
		for (int i = small; i < size; i++) {
			if (numberArrCh[index] < numberArrCh[i] && 
					numberArrCh[small] > numberArrCh[i]) {
				small = i;
			}
		}
		char temp = numberArrCh[small];
		numberArrCh[small] = numberArrCh[index];
		numberArrCh[index] = temp;
		Arrays.sort(numberArrCh, index + 1, numberArrCh.length);
		return Integer.valueOf(new String(numberArrCh));
	}
}
