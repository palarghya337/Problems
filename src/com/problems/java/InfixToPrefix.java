package com.problems.java;

import java.util.stream.IntStream;

import com.problems.utils.Log;

public class InfixToPrefix {

	public static void main(String... strings) {
		String infix = "{(a+b)^c/d-e}*f";
//		infix = "a-b*c+d/e-f%g";
//		infix = "(a+b)*c";
		convertInfixToPostfix(infix);
	}

	private static void convertInfixToPostfix(String infix) {
		
		char[] operatorStack = new char[infix.length()];
		StringBuilder variableStack = new StringBuilder();
		if (infix != null) {
			
			int operatorCount = 0;
			for (int index = 0; index < infix.length(); index++) {
				
				char value = infix.charAt(index);
				if (isOpeningBracket(value) || isOperator(value)) {
					
					operatorCount = appendLastOperators(operatorStack,
							variableStack, operatorCount, value);
					operatorStack[operatorCount++] = value;
				} else if (isClosingBracket(value)) {
					
					operatorCount = appendLastOperators(operatorStack,
							variableStack, operatorCount, value);
				} else {
					variableStack.append(value);
				}
			}
			int index = operatorCount - 1;
			IntStream.rangeClosed(0, index).map(i -> index - i).forEach(i -> variableStack.append(operatorStack[i]));
			Log.logInfo(variableStack.toString());
		}
	}

	private static int appendLastOperators(char[] operatorStack, StringBuilder variableStack, int operatorCount, char value) {
		
		if (operatorCount != 0) {
			
			char lastOperator = operatorStack[operatorCount - 1];
			if (!isLowOperator(lastOperator) || (isLowOperator(lastOperator)
					&& !isHeighOperator(value))) {
				
				while(operatorCount != 0) {
					lastOperator = operatorStack[--operatorCount];
					if (!isOpeningBracket(lastOperator)) {
						variableStack.append(lastOperator);
					}
				}
			}
		}
		return operatorCount;
	}
	private static boolean isOperator(char value) {
		return isLowOperator(value) || isHeighOperator(value) || value == '^';
	}
	private static boolean isHeighOperator(char value) {
		return value == '*' || value == '/' || value == '%';
	}

	private static boolean isLowOperator(char value) {
		return value == '+' || value == '-';
	}
	private static boolean isOpeningBracket(char value) {
		return value == '[' || value == '{' || value == '(';
	}
	private static boolean isClosingBracket(char value) {
		return value == ']' || value == '}' || value == ')';
	}
}
