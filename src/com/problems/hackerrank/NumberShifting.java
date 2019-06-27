package com.problems.hackerrank;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

import javax.management.openmbean.InvalidOpenTypeException;

import com.problems.utils.Log;

public class NumberShifting {

	public static void main(String[] args) {
		Random random = new Random();
		int[] processNames = random.ints(0, 20).distinct().limit(10).toArray();
		Log.logInfo("Before Rearrange: " + Arrays.toString(processNames));
		int indexOfProcess = 5;
		int[] rearrangedProcess = rearrangeProcess(processNames.length, indexOfProcess, processNames);
		Log.logInfo("After Rearrange: " + Arrays.toString(rearrangedProcess));
	}
	
	private static int[] rearrangeProcess(int numberOfProcess, int indexOfProcess, int[] processNames) {
		
		if (numberOfProcess > indexOfProcess && indexOfProcess != 0) {
			
			int temp = processNames[indexOfProcess-1];
			
			IntStream.range(1, indexOfProcess)
			.map(i -> indexOfProcess - i)
			.forEach(i -> processNames[i] = processNames[i-1]);
			
			processNames[0] = temp;
		} else {
			throw new InvalidOpenTypeException("Not Able to find the index.");
		}
		return processNames;
	}
}
