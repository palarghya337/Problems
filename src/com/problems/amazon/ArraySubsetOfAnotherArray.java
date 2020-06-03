package com.problems.amazon;

import java.util.Arrays;

public class ArraySubsetOfAnotherArray {

	public static void main(String[] args) {
		
		int[] mainArray = {1,4,4,2};
		int[] subArray = {1,4,2,4,2};
		
		mainArray = new int[] {1,4,7,3,5,6};
		subArray = new int[] {6,5,4};
		
		boolean isSubArray = new ArraySubsetOfAnotherArray()
				.isSubsetArray2(mainArray, subArray);
		System.out.println(isSubArray);
	}
	/**
	 * This method will take time O(n log n) where
	 * n is the large array size.
	 * @param mainArray
	 * @param subArray
	 * @return boolean
	 */
	public boolean isSubsetArray2(int[] mainArray,
			int[] subArray) {
		
		if (mainArray == null || subArray == null) {
			return false;
		}
		int mainArraySize = mainArray.length;
		int subArraySize = subArray.length;
		if (mainArraySize >= subArraySize) {
			
			// O(n log n)
			Arrays.sort(mainArray);
			// O (subArraySize log mainArraySize)
			for (int i = 0; i < subArraySize; i++) {
				
				int key = subArray[i];
				// O (log mainArraySize)
				int found = Arrays.binarySearch(mainArray, key);
				if (found == -1) {
					return false;
				}
			}
			return true;
		}
		return false;
	}
	/**
	 * Method to check whether an array is a subset of another
	 * array or not.
	 * 
	 * @param firstArray
	 * @param secondArray
	 * @return boolean returns true if subset of another array
	 * otherwise false.
	 */
	public boolean isSubsetArray(int[] firstArray,
			int[] secondArray) {
		
		if (firstArray == null || secondArray == null) {
			return false;
		}
		int firstArrayLen = firstArray.length;
		int secondArrayLen = secondArray.length;
		int count = 0;
		int actualItemCount = 0;
		if (firstArrayLen > secondArrayLen) {
			
			count = getFoundedItemCount(firstArray, secondArray,
					0, firstArrayLen - 1, secondArrayLen);
			actualItemCount = secondArrayLen;
		} else {
			
			count = getFoundedItemCount(secondArray, firstArray,
					0, secondArrayLen - 1, firstArrayLen);
			actualItemCount = firstArrayLen;
		}
		return count == actualItemCount;
	}
	/**
	 * @param firstArray will always contain more item.
	 * @param secondArray will always contain less item
	 * @param start index of the firstArray
	 * @param end index of the firstArray
	 * @return count of sub array item founded in the array.
	 */
	public int getFoundedItemCount(int[] firstArray,
			int[] secondArray, int start, int end, int secondArrayLen) {
		
		int count = 0;
		if (start < end) {
			
			int mid = (start + end) / 2;
			count += getFoundedItemCount(firstArray, secondArray,
					start, mid, secondArrayLen);
			count += getFoundedItemCount(firstArray, secondArray,
					mid + 1, end, secondArrayLen);
			return count;
		}
		return isItemAvailable(firstArray, secondArray,
				start, secondArrayLen) ? 1 : 0;
	}
	/**
	 * Method to check whether particular item is present in
	 * the array or not. If item is present then return true
	 * otherwise return false.
	 * 
	 * @param firstArray which has the more item than secondArray
	 * @param secondArray which has less item than firstArray
	 * @param index of first array to match with the item present
	 * in the second array
	 * @param secondArrayLen
	 * @return boolean
	 */
	private boolean isItemAvailable(int[] firstArray,
			int[] secondArray, int index, int secondArrayLen) {
		
		for (int i = 0; i < secondArrayLen; i++) {
			if (secondArray[i] == firstArray[index]) {
				return true;
			}
		}
		return false;
	}
}
