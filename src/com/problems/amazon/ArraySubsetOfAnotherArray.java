package com.problems.amazon;

public class ArraySubsetOfAnotherArray {

	public static void main(String[] args) {
		
		int[] firstArray = {10, 5, 2, 23, 19};//{1,6,5,4};//{1,4,7,3,5,6};
		int[] secondArray = {19, 5, 3};//{1,4,7,3,5,6};//{1,6,5};
		boolean isSubArray = new ArraySubsetOfAnotherArray()
				.isSubsetArray(firstArray, secondArray);
		System.out.println(isSubArray);
	}
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
					0, firstArrayLen - 1);
			actualItemCount = secondArrayLen;
		} else {
			count = getFoundedItemCount(secondArray, firstArray,
					0, secondArrayLen - 1);
			actualItemCount = firstArrayLen;
		}
		return count == actualItemCount;
	}
	public int getFoundedItemCount(int[] firstArray,
			int[] secondArray, int start, int end) {
		
		int count = 0;
		int secondArrayLen = secondArray.length;
		if (start < end) {
			int mid = (start + end) / 2;
			count += getFoundedItemCount(firstArray, secondArray,
					start, mid);
			if (secondArrayLen == count) {
				return count;
			}
			count += getFoundedItemCount(firstArray, secondArray,
					mid + 1, end);
			return count;
		}
		return isItemAvailable(firstArray, secondArray, start)
				? 1 : 0;
	}
	private boolean isItemAvailable(int[] firstArray,
			int[] secondArray, int start) {
		
		for (int i = 0; i < secondArray.length; i++) {
			if (secondArray[i] == firstArray[start]) {
				return true;
			}
		}
		return false;
	}
}
