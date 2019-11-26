package com.problems.hackerearth.basicprogramming.inputoutput.easy;

import java.util.Scanner;

public class FriendsRelationship {

	public static void main(String[] args) {
		
		try (Scanner scanner = new Scanner(System.in)) {
			
			int numberOfTestCases = Integer.parseInt(scanner.nextLine());
			int index = 0;
			int[] inputs = new int[numberOfTestCases];
			while (numberOfTestCases != index) {

				inputs[index++] = Integer.parseInt(scanner.nextLine());
			}
			printPattern(inputs);
		}
	}

	private static void printPattern(int[] inputs) {
		
		for (int i = 0; i < inputs.length; i++) {
			
			int number = inputs[i];
			int doubleNumber = number * 2;
			for (int j = 0; j < number; j++) {
				for (int k = 0; k < doubleNumber; k++) {
					
					if (k <= j || k >= (doubleNumber - 1 - j)) {
						System.out.print("*");
					} else {
						System.out.print("#");
					}
				}
				System.out.println();
			}
		}
	}
}
