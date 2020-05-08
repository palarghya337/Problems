package com.problems.leetcode.easy;

public class ValidParentheses {

	public static void main(String[] args) {
		
		String strg = "{}";
		boolean isValidParentheses = isValidParentheses(strg);
		System.out.println(isValidParentheses);
	}

	private static boolean isValidParentheses(String strg) {
		
		// returning false if string is null
		if (strg == null) {
			return false;
		}
		int length = strg.length();
		int stackIndex = -1;
		char[] stack = new char[length];
		for (int i = 0; i < length; i++) {
			
			char current = strg.charAt(i);
			if (current == '(' || current == '{'
					|| current == '[') {
				/*
				 * If character is open parentheses or brackets
				 * then keep that in a stack.
				 **/
				stack[++stackIndex] = current;
			} else {
				/*
				 * If character is closing parentheses or brackets
				 * and there is no item in the stack that means
				 * no opening parentheses or brackets present then
				 * return false.
				 **/
				if (stackIndex == -1) {
					return false;
				}
				/*
				 * If we found items present in the stack then need
				 * to match with the first item in the stack with
				 * the current character. If stacked item is not the
				 * opening bracket of current type closing bracket,
				 * then return false otherwise don't do anything.
				 **/
				char stackPopedItem = stack[stackIndex--];
				if (current == ')') {
					if (stackPopedItem != '(') {
						return false;
					}
				} else if (current == '}') {
					if (stackPopedItem != '{') {
						return false;
					}
				} else if (current == ']') {
					if (stackPopedItem != '[') {
						return false;
					}
				}
			}
		}
		/*
		 * If we found there is/are any item present in the stack
		 * after iterating all the string characters which means
		 * there must be an closing bracket(s) missing so return
		 * false otherwise returning true.
		 **/
		if (stackIndex > -1) {
			return false;
		}
		return true;
	}
}
