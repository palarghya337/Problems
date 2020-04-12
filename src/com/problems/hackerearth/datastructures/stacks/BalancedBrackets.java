package com.problems.hackerearth.datastructures.stacks;

import java.util.Scanner;

public class BalancedBrackets {

	public static void main(String[] args) {
		
		try (Scanner scan = new Scanner(System.in)) {
			
			int numberOfTestCase = Integer.parseInt(scan.nextLine());
			while (numberOfTestCase --> 0) {
				String str = scan.nextLine();
				solution(str);
			}
		}
	}

	private static void solution(String str) {
		
		int index = -1;
		int length = str.length();
		String output = "YES";
		char[] stack = new char[length];
		for (int i = 0; i < length; i++) {
			
			char chare = str.charAt(i);
			if (chare == '{' || chare == '(' || chare == '[') {
				
				stack[++index] = chare;
			} else if (chare == '}' || chare == ')'
					|| chare == ']') {
				
				if (index < 0 || chare != getOppositeChar(index--, stack)) {
					output = "NO";
					break;
				}
			}
		}
		if (stack[0] != '\u0000') {
			output = "NO";
		}
		System.out.println(output);
	}
	public static char getOppositeChar(int index, char[] stack) {
		
		char firstChar = stack[index];
		stack[index] = '\u0000';
		if (firstChar == '(') {
			return ')';
		} else if (firstChar == '{') {
			return '}';
		} else if (firstChar == '[') {
			return ']';
		} else {
			return firstChar;
		}
	}
}
