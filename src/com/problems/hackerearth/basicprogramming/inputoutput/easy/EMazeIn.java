package com.problems.hackerearth.basicprogramming.inputoutput.easy;

import java.util.Scanner;

import com.problems.utils.Log;

/**
 * <p> Ankit is in maze. The command center sent him a string which
 * decodes to come out from the maze. He is initially at (0, 0).
 * String contains L, R, U, D denoting left, right, up and down.
 * In each command he will traverse 1 unit distance in the
 * respective direction.</p>
 * 
 * <p> For example if he is at (2, 0) and the command is L he will
 * go to (1, 0).<br>
 * <b>Input:</b><br>
 * Input contains a single string.
 * <b>Output:</b><br>
 * Print the final point where he came out.
 * <b>Constraints:</b>
 * 1 <= |S| <= 200
 * 
 * @author Bittu
 *
 */
public class EMazeIn {

	public static void main(String[] args) {
		
		try (Scanner scanner = new Scanner(System.in)) {
			
			String input = scanner.nextLine();
			int x = 0;
			int y = 0;
			
			for (int i = 0; i < input.length(); i++) {
				
				char character = input.charAt(i);
				if (character == 'L' || character == 'l') {
					x--;
				} else if (character == 'R' || character == 'r') {
					x++;
				} else if (character == 'U' || character == 'u') {
					y++;
				} else {
					y--;
				}
			}
			Log.logInfo(x + " " +  y);
		}
	}
}
