package com.problems.hackerearth.datastructures.stacks;

import java.util.Arrays;
import java.util.Scanner;

/**
 * <p>
 * A and B are playing a game. In this game, both of them are
 * initially provided with a list of n numbers. (Both have the
 * same list but their own copy).
 * </p>
 * <p>
 * Now, they both have a different strategy to play the game.
 * A picks the element from start of his list.  picks from the
 * end of his list.<br>
 * You need to generate the result in form of an output list.
 * </p>
 * <p>
 * Method to be followed at each step to build the output list
 * is:<br>
 * 1. If the number picked by A is bigger than B then this step's
 * output is 1. B removes the number that was picked from their
 * list.<br>
 * 2. If the number picked by A is smaller than B then this
 * step's output is 2. A removes the number that was picked from
 * their list.<br>
 * 3. If both have the same number then this step's output is 0.
 * Both A and B remove the number that was picked from their
 * list. <br>
 * </p>
 * <p> This game ends when at least one of them has no more
 * elements to be picked i.e. when the list gets empty.
 * </p>
 * <p>
 * Output the built output list.
 * </p>
 * <p>
 * <b>Input Format:</b><br>
 * First line consists of a number n, size of the list provided.<br>
 * Next line consists of n numbers separated by space.
 * </p>
 * <p>
 * <b>Output Format</b><br>
 * Output the required output list.
 * </p>
 * @author Bittu
 *
 */
public class FunGameCapillary {

	public static void main(String[] args) {
		
		try (Scanner scan = new Scanner(System.in)) {
			
			int arraySize = scan.nextInt();
			int index = 0;
			int[] array = new int[arraySize];
			while (arraySize --> 0) {
				array[index++] = scan.nextInt();
			}
			String[] output = solution(array);
			System.out.println(Arrays.toString(output));
		}
	}

	private static String[] solution(int[] array) {
		
		int arrayLength = array.length;
		int startingIndex = 0;
		int endingIndex = arrayLength - 1;
		StringBuilder outputString = new StringBuilder();
		while (startingIndex < arrayLength && endingIndex > -1) {
			
			if (array[startingIndex] > array[endingIndex]) {
				outputString.append(1);
				endingIndex--;
			} else if (array[startingIndex] < array[endingIndex]) {
				outputString.append(2);
				startingIndex++;
			} else {
				outputString.append(0);
				startingIndex++;
				endingIndex--;
			}
			outputString.append(" ");
		}
		String[] outputList = outputString.toString().split(" ");
		return outputList;
	}
}
