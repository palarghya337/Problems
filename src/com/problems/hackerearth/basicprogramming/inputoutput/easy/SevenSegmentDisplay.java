package com.problems.hackerearth.basicprogramming.inputoutput.easy;

import java.util.Scanner;

import com.problems.utils.Log;

/**
 * <p>You all must have seen a seven segment display. Alice got a
 * number written in seven segment format where each segment was
 * creatted used a matchstick.</p>
 * <p>Example: If Alice gets a number 123 so basically Alice used
 * 12 matchsticks for this number.</p>
 * <p>Alice is wondering what is the numerically largest value
 * that she can generate by using at most the matchsticks that she
 * currently possess.Help Alice out by telling her that number.</p>
 * <p><b>Input Format:</b><br>
 * First line contains T (test cases).<br>
 * Next T lines contain a Number N.</p>
 * <p><b>Output Format:</b><br>
 * Print the largest possible number numerically that can be
 * generated using at max that many number of matchsticks which was
 * used to generate N.</p>
 * <p><b>Constraints</b><br>
 * 1 <= T <= 100<br>
 * 1 <= length(N) <= 100 </p>
 * <p><b>Explanation</b><br>
 * If you have 1 as your number that means you have 2 match sticks.
 * You can generate 1 using this.<br>
 * If you have 0 as your number that means you have 6 match sticks.
 * You can generate 111 using this.</p>
 * @author Bittu
 *
 */
public class SevenSegmentDisplay {

	public static void main(String[] args) {
		
		/*
		 * 1 = 2;
		 * 7 = 3;
		 * 4 = 4;
		 * 2,3,5 = 5;
		 * 0,6,9 = 6;
		 * 8 = 7;
		 **/
		try (Scanner scan = new Scanner(System.in)) {
			int numberOfTestCases = Integer.parseInt(scan.nextLine());
			while (numberOfTestCases --> 0) {
				
				String number = scan.nextLine();
				int numberOfSticks = findNumberOfMatchSticks(number);
				String highest = null;
				if (numberOfSticks % 2 == 0) {
					highest = findMaxForEven(numberOfSticks);
				} else {
					highest = findMaxForOdd(numberOfSticks);
				}
				Log.logInfo(highest);
			}
		}
	}
	private static int findNumberOfMatchSticks(String number) {
		
		int numberOfSticks = 0;
		for (int i = 0; i < number.length(); i++) {

			int r = Integer.parseInt(number.charAt(i) + "");
			if (r == 8) {
				numberOfSticks += 7;
			} else if (r == 0 || r == 6 || r == 9) {
				numberOfSticks += 6;
			} else if (r == 2 || r == 3 || r == 5) {
				numberOfSticks += 5;
			} else if (r == 4) {
				numberOfSticks += 4;
			} else if (r == 7) {
				numberOfSticks += 3;
			} else if (r == 1) {
				numberOfSticks += 2;
			}
		}
		return numberOfSticks;
	}
	private static String findMaxForEven(int numberOfSticks) {
		StringBuilder maxNumber = new StringBuilder();
		while (numberOfSticks > 0) {
			numberOfSticks = numberOfSticks - 2;
			maxNumber.append("1");
		}
		return maxNumber.toString();
	}
	private static String findMaxForOdd(int numberOfSticks) {
		
		StringBuilder highest = new StringBuilder();
		while (numberOfSticks > 0) {
			if (numberOfSticks == 3) {
				numberOfSticks = 0;
			} else {
				highest.append("1");
			}
			numberOfSticks = numberOfSticks - 2;
		}
		return "7" + highest.toString();
	}
}
