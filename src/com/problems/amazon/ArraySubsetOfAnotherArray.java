package com.problems.amazon;

public class ArraySubsetOfAnotherArray {

	public static void main(String[] args) {
		
		int[] firstArray = {1,4,4,2};
		int[] secondArray = {1,4,4};
		/*
		firstArray = new int[] {1,6,5};
		secondArray = new int[] {1,4,7,3,5,6};
		*/
		boolean isSubArray = new ArraySubsetOfAnotherArray()
				.isSubsetArray(firstArray, secondArray);
		System.out.println(isSubArray);
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
