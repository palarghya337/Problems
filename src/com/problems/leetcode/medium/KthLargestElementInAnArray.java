package com.problems.leetcode.medium;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class KthLargestElementInAnArray {

	public static void main(String[] args) {

		int maxSize = 10;
		Random random = new Random();
		int[] array = IntStream.generate(() -> random.nextInt(50))
				.limit(maxSize)
				.toArray();
		
		System.out.println(Arrays.toString(array));
		int largest = new KthLargestElementInAnArray()
				.findKthLargest(array, 3);
		System.out.println(largest);
	}
	public int findKthLargest(int[] array, int k) {
        
        int arraySize = 0;
		if (array != null && (arraySize = array.length) >= k) {

			buildMaxHeap(array, arraySize);
			while (k > 1) {
				
				int temp = array[0];
				array[0] = array[--arraySize];
				array[arraySize] = temp;
				heapify(array, 0, arraySize);
				k--;
			}
		}
		// System.out.println("-----------------------");
		// System.out.println(Arrays.toString(array));
		return array[0];
    }
    public void buildMaxHeap(int[] array, int arraySize) {
		
		int parentOfLastNode = (arraySize - 1) / 2;
		while (parentOfLastNode > -1) {
			
			heapify(array, parentOfLastNode, arraySize);
			parentOfLastNode--;
		}
	}
	private void heapify(int[] array, int parent,
			int arraySize) {
		
		int largest = parent;
		int right = (parent + 1) * 2;
		int left = right - 1;
		largest = getHighestElementIndex(array, arraySize, largest, left);
		largest = getHighestElementIndex(array, arraySize, largest, right);
		if (largest != parent) {
			
			swap(array, parent, largest);
			heapify(array, largest, arraySize);
		}
	}

	private int getHighestElementIndex(int[] array, int arraySize,
			int assumedLargestIndex, int currentIndex) {
		
		if (currentIndex < arraySize
				&& array[currentIndex] > array[assumedLargestIndex]) {
			return currentIndex;
		}
		return assumedLargestIndex;
	}

	private void swap(int[] array, int parentIndex,
			int childIndex) {

		int temp = array[parentIndex];
		array[parentIndex] = array[childIndex];
		array[childIndex] = temp;
	}
}
