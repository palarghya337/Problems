package com.problems.others;

import java.util.Arrays;

public class SeparateNegativeAndPositiveNumbers {

	public static void main(String[] args) {
		
		int array[] = {-5,10,-4,-6,15};
		array = new int[] {};
		array = new int[] {1,2};
		array = new int[] {1,-2};
		array = new int[] {-1,2};
		array = new int[] {-1,-2};
		array = new int[] {-5,10,4,6,-15,-6};
		System.out.println(Arrays.toString(array));
		new SeparateNegativeAndPositiveNumbers()
			.rearrangeArray2(array);
		System.out.println(Arrays.toString(array));
	}
	/**
	 * Method to re arrange the array such a way that negative
	 * should be on one side and positive should be on another
	 * side without changing the original order.
	 * 
	 * @param array
	 */
	public void rearrangeArray(int[] array) {
		
		int length = 0;
		if (array != null && (length = array.length) > 2) {
			for (int index = 0; index < length; index++) {
				
				int dupIndex = index;
				int prevIndex = dupIndex - 1;
				while (prevIndex > -1 && array[dupIndex] < 0
						&& array[prevIndex] > -1) {
					
					swap(array, dupIndex, prevIndex);
					dupIndex--;
					prevIndex--;
				}
			}
		}
	}
	public void rearrangeArray2(int[] array) {
		
		int length = 0;
		if (array != null && (length = array.length) > 2) {
			
			int negativeArrayIndex = 0;
			int positiveArrayIndex = 0;
			int[] positiveNumbers = new int[length];
			for (int index = 0; index < length; index++) {
				if (array[index] < 0) {
					array[negativeArrayIndex++] = array[index];
				} else {
					positiveNumbers[positiveArrayIndex++] = array[index];
				}
			}
			for (int index = 0; index < positiveArrayIndex; index++) {
				array[negativeArrayIndex++] = positiveNumbers[index];
			}
		}
	}
	private void swap(int[] array, int dupIndex, int prevIndex) {
		
		int temp = array[prevIndex];
		array[prevIndex] = array[dupIndex];
		array[dupIndex] = temp;
	}
}
