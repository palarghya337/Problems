package com.problems.hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.problems.exceptions.InvalidOperationException;
import com.problems.utils.Log;

public class Problem1 {

	public static void main(String... args) {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		try {
		  Log.logInfo("Enter string length and execution time by single space.");
			String lenthAndExecution = reader.readLine();
			if (lenthAndExecution != null) {
				
				String[] lengthAndExecutionArr = lenthAndExecution.trim().split(" ");
				int stringLength = Integer.parseInt(lengthAndExecutionArr[0]);
				int executionTime = Integer.parseInt(lengthAndExecutionArr[1]);
				Log.logInfo("Enter input string: ");
				String inputString = reader.readLine();
				if (stringLength != inputString.length()) {
					throw new InvalidOperationException("String length does not match");
				}
				inputStartEndIndex(reader, executionTime, inputString);
			}
		} catch (IOException e) {
		  Log.logInfo("Exception caught: {0}", e);
		}
	}

	private static void inputStartEndIndex(BufferedReader reader, int executionTime, String inputString)
			throws IOException {
	  Log.logInfo("Enter substring start and end index with space: ");
		for (int i = 0; i < executionTime; i++) {
			
			String startAndEndIndex = reader.readLine();
			if (startAndEndIndex == null) {
				throw new InvalidOperationException("index can not be null");
			}
			String[] startAndEndIndexArr = startAndEndIndex.trim().split(" ");
			int startIndex = Integer.parseInt(startAndEndIndexArr[0]);
			int endIndex = Integer.parseInt(startAndEndIndexArr[1]);
			solveTheProblem(inputString, startIndex, endIndex);
		}
	}

	private static void solveTheProblem(String inputString, int startIndex, int endIndex) {
		
		int count = 0;
		String subString = inputString.substring(startIndex-1, endIndex);
		if (startIndex == endIndex) {
		  Log.logInfo("Count: 1");
			return;
		}
		Log.logInfo("SubString {0} Length: {1}", subString, subString.length());
		for (int i = subString.length() - 1; i >= 0; i--) {
			for (int j = 0; j <= i; j++) {
				if (subString.charAt(j) == subString.charAt(i)) {
					count++;
				}
			}
		}
		Log.logInfo("Count: " + count);
	}
}
