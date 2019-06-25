package com.java8.practice.problems;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class NumberShifting {

	public static void main(String[] args) {
		Random random = new Random();
		int[] processNames = random.ints(0, 20).distinct().limit(10).toArray();
		System.out.println("Before Rearrange: " + Arrays.toString(processNames));
		int indexOfProcess = 5;
		int[] rearrangedProcess = rearrangeProcess(processNames.length, indexOfProcess, processNames);
		System.out.println("After Rearrange: " + Arrays.toString(rearrangedProcess));
	}
	
	private static int[] rearrangeProcess(int numberOfProcess, int indexOfProcess, int[] processNames) {
		
		if (numberOfProcess > indexOfProcess && indexOfProcess != 0) {
			
			int temp = processNames[indexOfProcess-1];
			
			IntStream.range(1, indexOfProcess)
			.map(i -> indexOfProcess - i)
			.forEach(i -> processNames[i] = processNames[i-1]);
			
			processNames[0] = temp;
		} else if (numberOfProcess < indexOfProcess) {
			throw new RuntimeException("It is not possible");
		}
		return processNames;
	}
}
