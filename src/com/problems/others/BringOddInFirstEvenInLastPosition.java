package com.problems.others;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class BringOddInFirstEvenInLastPosition {

	public static void main(String[] args) {
		
		Random random = new Random();
		int array[] = IntStream.generate(() -> random.nextInt(50))
				.distinct()
				.limit(10)
				.toArray();
		System.out.println(Arrays.toString(array));
		solution(array);
		System.out.println(Arrays.toString(array));
	}

	private static void solution(int[] array) {
		
		int arrayLength = array.length;
		int firstIndex = 0;
		int lastIndex = arrayLength - 1;
		int loopCount = 0;
		
		while (firstIndex < lastIndex) {
			
			boolean isOdd = array[firstIndex] % 2 != 0;
			boolean isEven = array[lastIndex] % 2 == 0;
			if (!isOdd && !isEven) {
				
				int temp = array[lastIndex];
				array[lastIndex] = array[firstIndex];
				array[firstIndex] = temp;
				firstIndex++;
				lastIndex--;
			} else {
				if (isOdd) {
					firstIndex++;
				}
				if (isEven) {
					lastIndex--;
				}
			}
			loopCount++;
		}
		System.out.println("Loop Iteration Time: " + loopCount);
	}
}
