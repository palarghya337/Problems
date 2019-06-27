package com.problems.hackerrank;

import com.problems.utils.Log;

/**
 * Little Bobby loves chocolate. He frequently goes to his favorite 5&10  store,
 * with Penny Auntie, to buy them. They are having a promotion at Penny Auntie. If
 * Bobby saves enough wrappers, he can turn them in for a free chocolate. For
 * example, Bobby has n=15 to spend on bars of chocolate that cost c=3 each. He
 * can turn in m=2 wrappers to receive another bar. Initially, he buys 5 bars
 * and has 5 wrappers after eating them. He turns in 4 of them, leaving him with
 * 1, for 2 more bars. After eating those two, he has 3 wrappers, turns in 2 leaving
 * him with 1 wrapper and his new bar. Once he eats that one, he has 2 wrappers
 * and turns them in for another bar. After eating that one, he only has 1 wrapper,
 * and his feast ends. Overall, he has eaten 5+2+1+1=9 bars.
 * 
 * @author apal
 *
 */
public class CupcakeIssue {

	public static void main(String[] args) {
		
		String message = "Total Cupcakes Ate: {0}";
		Log.logInfo(message, solveCupcake(new int[] {6,2,2}));
		Log.logInfo(message, solveCupcake(new int[] {8,2,2}));
		Log.logInfo(message, solveCupcake(new int[] {10,5,3}));
		Log.logInfo(message, solveCupcake(new int[] {10,2,5}));
		Log.logInfo(message, solveCupcake(new int[] {12,4,4}));
		Log.logInfo(message, solveCupcake(new int[] {15,3,2}));
	}

	private static int solveCupcake(int[] data) {
		
		int totalCupcakePrice = data[0];
		int cupcakePrice = data[1];
		int freeCupcakeFor = data[2];
		int numberOfCupcakes = totalCupcakePrice / cupcakePrice;
		int ateCupcakes = numberOfCupcakes;
		
		while (numberOfCupcakes >= freeCupcakeFor) {
			int freeCupcakes = numberOfCupcakes / freeCupcakeFor;
			ateCupcakes += freeCupcakes;
			numberOfCupcakes = freeCupcakes + numberOfCupcakes % freeCupcakeFor;
		}
		return ateCupcakes;
	}
}
