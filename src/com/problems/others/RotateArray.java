package com.problems.others;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

import com.problems.utils.Log;

public class RotateArray {

	public static void main(String[] args) {
		
		try (Scanner scan = new Scanner(System.in)) {
			
			Log.logInfo("ArraySize: ");
			int arraySize = scan.nextInt();
			int[] array = IntStream.range(1, arraySize + 1)
					.boxed().mapToInt(i -> i).toArray();
			Log.logInfo("# of Rotation:");
			int numberOfRotation = scan.nextInt();
			
			long start = System.nanoTime();
			rotate(array, numberOfRotation);
			long end = System.nanoTime();
			Log.logInfo("Time: {0}ns", (end - start));
			Log.logInfo(Arrays.toString(array));
		}
	}

	private static void rotate(int[] array, int numberOfRotation) {
		
		int copyArrIndex = 0;
		int arrayLength = array.length;
		int pasteFromIndex = arrayLength - numberOfRotation;
		int[] copyArr = new int[numberOfRotation];
		for (int i = 0; i < arrayLength; i++) {
			
			if (i < numberOfRotation) {
				copyArr[i] = array[i];
			} else {
				array[i - numberOfRotation] = array[i];
			}
			if (i >= pasteFromIndex) {
				array[i] = copyArr[copyArrIndex++];
			}
		}
	}
}
