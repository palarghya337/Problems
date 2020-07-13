package com.problems.others;

import java.util.Arrays;

/**
 * Equilibrium index of an array is an index such that
 * the sum of elements at lower indexes is equal to the
 * sum of elements at higher indexes.
 * @author Bittu
 *
 */
public class EquilibriumIndex {

	public static void main(String[] args) {
		
		int[] array = {-7,1,5,2,-4,3,0};
		array = new int[] {1,2,3,1,3,2,1};
		System.out.println(Arrays.toString(array));
		int index = new EquilibriumIndex()
				.getEquilibriumIndex(array);
		System.out.println("Index: " + index);
	}
	/**
	 * Method to find the equilibrium index. If equilibrium
	 * index is not found then returns -1.
	 * @param array
	 * @return equilibriumIndex
	 */
	private int getEquilibriumIndex(int[] array) {
		
		int size = array.length;
		int totalSum = 0;
		for (int i = 0; i < size; i++) {
			
			totalSum += array[i];
		}
		int leftSum = 0;
		for (int i = 0; i < size; i++) {
			
			totalSum = totalSum - array[i];
			if (leftSum == totalSum) {
				return i;
			}
			leftSum += array[i];
		}
		return -1;
	}
}
