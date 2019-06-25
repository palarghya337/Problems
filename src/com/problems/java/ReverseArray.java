package com.problems.java;

import java.util.Arrays;
import java.util.Scanner;

import com.problems.utils.Log;

public class ReverseArray {

	public static void main(String...strings) {
	  
		try (Scanner scan = new Scanner(System.in)) {
		  
		  Log.logInfo("Enter data for array separated by comma('','')");
		  String arrayDataInString = scan.nextLine();
		  String[] arrayData = arrayDataInString.split(",");
		  int[] array = Arrays.stream(arrayData).mapToInt(Integer::parseInt).toArray();
		  Log.logInfo(Arrays.toString(reverseArray(array)));
		} catch (NumberFormatException e) {
		  Log.logInfo("Can not able to proceed further as you did not enter number.");
		}
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
