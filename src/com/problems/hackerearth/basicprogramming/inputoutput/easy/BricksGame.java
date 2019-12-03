package com.problems.hackerearth.basicprogramming.inputoutput.easy;

import java.util.Scanner;

import com.problems.utils.Log;

/**
 * <p>Patlu and Motu works in a building construction, they have to
 * put some number of bricks N from one place to another, and
 * started doing their work. They decided , they end up with a
 * fun challenge who will put the last brick.<br>
 * They to follow a simple rule, In the i'th round, Patlu puts i
 * bricks whereas Motu puts ix2 bricks.<br>
 * There are only N bricks, you need to help find the challenge
 * result to find who put the last brick.</p>
 * <b>Input:</b><br>
 * First line contains an integer N.<br>
 * <b>Output:</b><br>
 * Output "Patlu" (without the quotes) if Patlu puts the last
 * bricks ,"Motu"(without the quotes) otherwise.<br>
 * <b>Constraints:</b><br>
 * 1 <= N <= 10000
 * 
 * @author Bittu
 *
 */
public class BricksGame {

	public static void main(String[] args) {
		
		try (Scanner scanner = new Scanner(System.in)) {
			
			int number = scanner.nextInt();
			int i = 1;
			while (number > 0) {
				
				if (number <= i) {
					Log.logInfo("Patlu");
					break;
				}
				number = number - i;
				if (number <= (i * 2)) {
					Log.logInfo("Motu");
				}
				number = number - (i * 2);
				i++;
			}
		}
	}
}
