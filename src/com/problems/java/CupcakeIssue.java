package com.problems.java;

import com.problems.utils.Log;

public class CupcakeIssue {

	public static void main(String[] args) {
		
		String message = "Total Cupcakes Ate: {0}";
		Log.logInfo(message, solveCupcake(new int[] {6,2,2}));
		Log.logInfo(message, solveCupcake(new int[] {8,2,2}));
		Log.logInfo(message, solveCupcake(new int[] {10,5,3}));
	}

	private static int solveCupcake(int[] data) {
		
		int totalCupcakePrice = data[0];
		int cupcakePrice = data[1];
		int wrapperToCupcake = data[2];
		int numberOfCupcakes = totalCupcakePrice / cupcakePrice;
		int ateCupcakes = numberOfCupcakes;
		
		while (numberOfCupcakes >= wrapperToCupcake) {
			int freeCupcakes = numberOfCupcakes / wrapperToCupcake;
			ateCupcakes += freeCupcakes;
			numberOfCupcakes = freeCupcakes + numberOfCupcakes % wrapperToCupcake;
		}
		return ateCupcakes;
	}
}
