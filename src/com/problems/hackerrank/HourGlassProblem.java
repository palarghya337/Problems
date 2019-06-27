package com.problems.hackerrank;

import java.util.Arrays;

import com.problems.utils.Log;

/**
 * Given a  2D Array, : <br>

1 1 1 0 0 0<br>
0 1 0 0 0 0<br>
1 1 1 0 0 0<br>
0 0 0 0 0 0<br>
0 0 0 0 0 0<br>
0 0 0 0 0 0<br>

We define an hourglass in  to be a subset of values with indices falling in this pattern in 's graphical representation:<br>

a b c<br>
&nbsp d<br>
e f g<br>
There are  hourglasses in , and an hourglass sum is the sum of an hourglass' values. Calculate the hourglass sum for every hourglass in , then print the maximum hourglass sum.

For example, given the 2D array:

-9 -9 -9  1 1 1 
 0 -9  0  4 3 2
-9 -9 -9  1 2 3
 0  0  8  6 6 0
 0  0  0 -2 0 0
 0  0  1  2 4 0
We calculate the following  hourglass values:

-63, -34, -9, 12, 
-10, 0, 28, 23, 
-27, -11, -2, 10, 
9, 17, 25, 18
Our highest hourglass value is  from the hourglass:

0 4 3
&nbsp1
8 6 6
Note: If you have already solved the Java domain's Java 2D Array challenge, you may wish to skip this challenge.<br>

Function Description<br>

Complete the function hourglassSum in the editor below. It should return an integer, the maximum hourglass sum in the array.<br>

hourglassSum has the following parameter(s):<br>

arr: an array of integers<br>
Input Format<br>

Each of the  lines of inputs  contains  space-separated integers .<br>

Constraints

Output Format

Print the largest (maximum) hourglass sum found in .

Sample Input

1 1 1 0 0 0
0 1 0 0 0 0
1 1 1 0 0 0
0 0 2 4 4 0
0 0 0 2 0 0
0 0 1 2 4 0
Sample Output

19
Explanation

 contains the following hourglasses:

image

The hourglass with the maximum sum () is:

2 4 4
  2
1 2 4
*/
public class HourGlassProblem {

	public static void main(String... string) {
		int arr[][] = {{-9,-9,-9,1,1,1},{0,-9,0,4,3,2},{-9,-9,-9,1,2,3},{0,0,8,6,6,0},{0,0,0,-2,0,0},{0,0,1,2,4,0}};
		int arr2[][] = {{1,1,1,0,0,0},{0,1,0,0,0,0},{1,1,1,0,0,0},{0,0,2,4,4,0},{0,0,0,2,0,0},{0,0,1,2,4,0}};
		Log.logInfo("Heighest Number: " + solveProblem(arr));
		Log.logInfo("Heighest Number: " + solveProblem(arr2));
	}
	private static int solveProblem(int arr[][]) {
		int resultLength = (arr.length -2)*(arr.length -2);
		int result[] = new int[resultLength];
		int resultCount = 0;
		for (int i = 0; i < arr.length - 2; i ++) {
			for (int j = 0; j < arr[i].length - 2; j++) {
				result[resultCount++] = hourGlassSum(arr, i, j);
			}
		}
		Log.logInfo("Sum of sub arrays: {0}", Arrays.toString(result));
		return Arrays.stream(result).max().getAsInt();
	}
	private static int hourGlassSum(int[][] arr, int i, int j) {
		int addition = 0;
		for (int k = i; k < i+3; k++) {
			for (int l = j; l < j+3; l++) {
				if (k == i+1) {
					if (l == j+1) {
						addition += arr[k][l];
					}
				} else {
					addition += arr[k][l];
				}
			}
		}
		return addition;
	}
}
