package com.problems.hackerearth.basicprogramming.inputoutput.easy;

import java.util.Scanner;

/**
 * <p>Aditya is fond of ladders. Everyday he goes through pictures
 * of ladders online but unfortunately today he ran out of ladder
 * pictures online. Write a program to print “ladder with N steps”,
 * which he can use to get his daily dose of ladder love.</p>
 * <p><b>INPUT:</b><br>
 * Input contains integer N, the number of steps in the ladder</p>
 * <p><b>OUTPUT:</b><br>
 * Print the ladder with the gap between two side rails being 3
 * spaces(“   “).<br>
 * Check the sample output for format of printing the ladder.</p>
 * <p><b>CONSTRAINTS:</b><br>
 * 1<=N<=40</p>
 * 
 * @author Bittu
 *
 */
public class Ladderophilia {

	public static void main(String[] args) {
		
		try (Scanner scanner = new Scanner(System.in)) {
			
			int number = scanner.nextInt();
// 			printLadder(number);
			printLadder2(number);
		}
	}

	private static void printLadder(int number) {
		
		int loop = (number + 1) * 2 + number;
		int v = loop;
		while(loop > 0) {
			if (v == loop--) {
				v -= 3;
			}
			for (int i = 0; i < 5; i++) {
				if (v == loop || (i == 0 || i == 4)) {
					System.out.print("*");
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}
	private static void printLadder2(int number) {
		
		String pattern = "*   *";
		System.out.println(pattern);
		for (int i = 0; i < number; i++) {
			System.out.println(pattern);
			System.out.println("*****");
			System.out.println(pattern);
		}
		System.out.println(pattern);
	}
}
