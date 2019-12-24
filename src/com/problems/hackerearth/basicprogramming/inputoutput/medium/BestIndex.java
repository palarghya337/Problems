package com.problems.hackerearth.basicprogramming.inputoutput.medium;

import java.util.Scanner;

import com.problems.utils.Log;

/**
 * <p>You are given an array A of N elements. Now you need to choose the best index of
 * this array A. An index of the array is called best if the special sum of this
 * index is maximum across the special sum of all the other indices.</p>
 * <p>To calculate the special sum for any index i, you pick the first element that is
 * A[i] and add it to your sum. Now you pick next two elements i.e. A[i+1] and A[i+2]
 * and add both of them to your sum. Now you will pick the next 3 elements and this
 * continues till the index for which it is possible to pick the elements. For example:
 * </p>If our array contains 10 elements and you choose index to be  then your special
 * sum is denoted by - (A[3])+(A[4]+A[5])+(A[6]+A[7]+A[8]), beyond this its not possible
 * to add further elements as the index value will cross the value 10.</p>
 * <p>Find the best index and in the output print its corresponding special sum. Note
 * that there may be more than one best indices but you need to only print the maximum
 * special sum.</p>
 * <p><b>Input</b><br>
 * First line contains an integer N as input. Next line contains N space separated
 * integers denoting the elements of the array A.<br>
 * 5<br>
 * 1 3 1 2 5<br>
 * <b>Output</b><br>
 * In the output you have to print an integer that denotes the maximum special sum
 * <br>8</p>
 * @author Bittu
 *
 */
public class BestIndex {

	public static void main(String[] args) {
		
		try (Scanner scan = new Scanner(System.in)) {
			
			int arraySize = scan.nextInt();
			int[] array = new int[arraySize];
			for (int i = 0 ; i < arraySize; i ++) {
				array[i] = scan.nextInt();
			}
 			long start = System.nanoTime();
			Log.logInfo(findBestIndex(array));
 			long end = System.nanoTime();
 			Log.logInfo("Time: " + (end - start));
		} catch (Exception e) {
			Log.logInfo(e.getMessage());
		}
	}

	private static long findBestIndex(int[] array) {
		
		int arrayLength = array.length;
		long maxsum = 0;
		for (int i = 0; i < arrayLength; i++) {
			
			long locsum = locSum2(array, 1, i, i, i + 1);//locSum(array, arrayLength, i);
			maxsum = Math.max(locsum, maxsum);
	    }
		return maxsum;
	}

	private static long locSum(int[] array, int arrayLength, int i) {
		
		int y = 1;
		int x = i + y;
		int j = i;
		long locsum = 0;
		while (j != x && j < arrayLength) {
			
			locsum += array[j++];
			x += ++y;
			x = x > arrayLength ? x - y : x;
		}
		return locsum;
	}
	private static long locSum2(int[] array, int y, int i, int j, int x) {
		
		int arrayLength = array.length;
		long locsum = 0;
		if (j == x || j >= arrayLength) {
			return locsum;
		}
		x += ++y;
		x = x > arrayLength ? x - y : x;
		locsum = locSum2(array, y, i , ++j, x);
		locsum += array[j -1];
		return locsum;
	}
}
