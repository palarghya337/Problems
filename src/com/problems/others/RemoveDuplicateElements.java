package com.problems.others;

import java.util.stream.IntStream;

public class RemoveDuplicateElements {

	public static void main(String[] args) {
		
		int []array = {1,2,1,3,2,3};
		removeDuplicates(array);
	}

	private static void removeDuplicates(int[] array) {
		
		int high = array[0];
		for (int i = 0; i < array.length; i++) {
			if (high < array[i]) {
				high = array[i];
			}
		}
		int[] temp = new int[high + 1];
		int[] newArrray = new int[array.length];
		int j = 0;
		for (int i = 0; i < array.length; i++) {
			if (temp[array[i]] == 0) {
				
				temp[array[i]] = 1;
				newArrray[j++] = array[i];
			}
		}
		
		IntStream.range(0, newArrray.length)
			.forEach(i -> System.out.print(newArrray[i] + " "));
	}
}
