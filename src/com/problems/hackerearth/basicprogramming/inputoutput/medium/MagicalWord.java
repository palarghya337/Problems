package com.problems.hackerearth.basicprogramming.inputoutput.medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MagicalWord {

	public static void main(String[] args) {
		
		try (BufferedReader reader = new BufferedReader(
				new InputStreamReader(System.in))) {
			
			int numberOfTestCases = Integer.parseInt(reader.readLine());
			int[] primeNumbers = {67,71,73,79,83,89,97,101,103,107,109,113};
			while (numberOfTestCases --> 0) {
				
				int wordLength = Integer.parseInt(reader.readLine());
				String word = reader.readLine();
				int  end = primeNumbers.length - 1;
				StringBuilder magicalWord = new StringBuilder();
				for (int i = 0; i < wordLength; i++) {
					
					int asciiValue = word.charAt(i);
					int number = getNearestNumber(asciiValue, primeNumbers,
							0, end);
					magicalWord.append((char) number);
				}
				System.out.println(magicalWord.toString());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	private static int getNearestNumber(int searchItem, int[] array,
			int start, int end) {
		
		int mid = (start + end) / 2;
		if (start < end) {
			if (array[mid] == searchItem) {
				return array[mid];
			} else if (array[mid] > searchItem) {
				return getNearestNumber(searchItem, array, start, mid);
			} else if (array[mid] < searchItem) {
				return getNearestNumber(searchItem, array, mid + 1, end);
			}
		}
		int low = mid - 1 == -1 ? mid : mid - 1;
		if (Math.abs(array[mid] - searchItem) >= Math.abs(array[low] - searchItem)) {
			return array[low];
		}
		return array[mid];
	}
}
