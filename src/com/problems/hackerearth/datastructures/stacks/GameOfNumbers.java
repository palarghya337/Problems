package com.problems.hackerearth.datastructures.stacks;

import java.util.Arrays;
import java.util.Scanner;

/**
 * <p>
 * You are given an array A of N integers. Now, two functions
 * F(X) and G(X) are defined:
 * </p>
 * <p>
 * F(X): This is the smallest number Z such that X < Z <= N
 * and A[X] < A[Z] 
 * </p>
 * <p>
 * G(X): This is the smallest number Z such that X < Z <= N
 * and A[X] > A[Z] 
 * </p>
 * <p>
 * Now, you need to find for each index i of this array G(F(i)),
 * where 1 <= i <= N. If such a number does not exist, for a
 * particular index i, output -1 as its answer. If such a number
 * does exist, output A[G(F(i))]
 * </p>
 * <p>
 * <b>Input:</b><br>
 * The first line contains a single integer N denoting the size
 * of array A. Each of the next N lines contains a single integer,
 * where the integer on the ith line denotes A[i].
 * </p>
 * <p>
 * <b>Output:</b><br>
 * Print N space separated integers on a single line, where the
 * integer denotes A[G(F(i))] or 1, if G(F(i)) does not exist.
 * </p>
 * <p>
 * <b>Constraints:</b><br>
 * 1 <= N <=30000<br>
 * 0 <= A[i] <= 10^18
 * </p>
 * <p>
 * <b>Explanation</b><br>
 * <table>
 * <tr>
 * <th> Next Greater</th>
 * <th> Next Smaller</th>
 * </tr>
 * <tr><td>3 --> 7</td><td>7 -->1</td></tr>
 * <tr><td>7 --> 8</td><td>8 -->4</td></tr>
 * <tr><td>1 --> 7</td><td>7 --> 4</td></tr>
 * <tr><td>7 --> 8</td><td>8 --> 4</td></tr>
 * <tr><td>8 --> -1</td><td>-1 --> -1</td></tr>
 * <tr><td>4 --> 5</td><td>5 --> 2</td></tr>
 * <tr><td>5 --> -1</td><td>-1 --> -1</td></tr>
 * <tr><td>2 --> -1</td><td>-1 --> -1</td></tr>
 * </table>
 * </p>
 * @author Bittu
 *
 */
public class GameOfNumbers {

	public static void main(String[] args) {
		
		try (Scanner scan = new Scanner(System.in)) {
			
			int sizeOfArray = Integer.parseInt(scan.nextLine());
			String[] strArr = scan.nextLine().split(" ");
			int[] array = Arrays.stream(strArr)
					.mapToInt(Integer::parseInt)
					.toArray();
			if (sizeOfArray != array.length) {
				System.out.println("Input array elements is more than array size.");
			}
			solveProblem(array);
		}
	}
	private static void solveProblem(int[] array) {
		
		int length = array.length;
		for (int i = 0; i < length; i++) {
			
			boolean isFirstConditionCheck = true;
			int selectedIndex = i;
			int finalNumber = -1;
			for (int j = i + 1; j < length; j++) {
				
				if (isFirstConditionCheck
						&& array[selectedIndex] < array[j]) {
					
					selectedIndex = j;
					isFirstConditionCheck = false;
				} else if (!isFirstConditionCheck
						&& array[selectedIndex] > array[j]) {
					
					finalNumber = array[j];
					break;
				}
			}
			
			System.out.print(finalNumber + " ");
		}
	}
}
