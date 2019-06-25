package com.java8.practice.problems;

import java.util.Arrays;

public class ReverseArray {

	public static void main(String...strings) {
		int arr[] = {1,4,3,2};
		System.out.println(Arrays.toString(reverseArray(arr)));
	}

	private static int[] reverseArray(int[] arr) {
		int start = 0;
		int end = arr.length-1;
		do {
			arr[start] = arr[start] + arr[end];
			arr[end] = arr[start] - arr[end];
			arr[start] = arr[start] - arr[end];
			start++;
			end--;
		} while(start != end && start < end);
		
		return arr;
	}
}
