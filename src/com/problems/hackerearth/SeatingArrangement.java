package com.problems.hackerearth;

import java.util.Scanner;

import com.problems.utils.Constants;
import com.problems.utils.Log;

/**
 * Akash and Vishal are quite fond of travelling. They mostly travel
 * by railways. They were travelling in a train one day and they got
 * interested in the seating arrangement of their compartment. The
 * compartment looked something like -
 * WS- 6, 7, 18, 19, 30
 * MS- 5, 8, 17, 20, 29
 * AS- 4, 9, 16, 21, 28
 * 
 * AS- 3, 10, 15, 22, 27
 * MS- 2, 11, 14, 23, 26
 * WS- 1, 12, 13, 24, 25
 * 
 * So they got interested to know the seat number facing them and
 * the seat type facing them. The seats are denoted as follows :
 * Window Seat : WS
 * Middle Seat : MS
 * Aisle Seat : AS
 * You will be given a seat number, find out the seat number facing
 * you and the seat type, i.e. WS, MS or AS.
 * @author Bittu
 *
 */
public class SeatingArrangement {

	public static void main(String[] args) {
		
		try (Scanner scanner = new Scanner(System.in)) {
			// 11, 9, 7, 5, 3, 1
			// WS- 1,6,7,12,13,18,19,24,25 (ODD+5, EVEN+1)
			// MS- 2,5,8,11,14,17,20,23,26 (+3)
			// AS- 3,4,9,10,15,16,21,22,27 (ODD+1, EVEN+5)
			Log.logInfo("Enter number of Tests to run: ");
			int numberOfTest = scanner.nextInt();
			while (numberOfTest != 0) {
				
				Log.logInfo("Enter the seat number: ");
				int seatNumber = scanner.nextInt();
				boolean isEvenSeatNumber = seatNumber % 2 == 0;
				int compartment = Math.incrementExact((seatNumber - 1) / 12);
				int endSeatOfComp = (compartment * 12);
				int startSeatOfComp = endSeatOfComp - 11;
				int distance = endSeatOfComp - seatNumber;
				String result = Constants.EMPTY_STRING;

				if ((isEvenSeatNumber && seatNumber % 3 == 0)
						|| (!isEvenSeatNumber && (seatNumber + 5) % 3 == 0)) {

					result = findWindowSeatNumber(seatNumber, isEvenSeatNumber,
							endSeatOfComp, startSeatOfComp, distance);
				} else if ((isEvenSeatNumber && (seatNumber + 5) % 3 == 0)
						|| (!isEvenSeatNumber && seatNumber % 3 == 0)){

					result = findAisleSeatNumber(seatNumber, isEvenSeatNumber, distance);
				} else {

					result = findMiddleSeatNumber(seatNumber, isEvenSeatNumber,
							startSeatOfComp, distance);
				}
				Log.logInfo(result);
				numberOfTest--;
			}
		}
	}
 
	private static String findMiddleSeatNumber(int seatNumber,
			boolean isEvenSeatNumber, int startSeatOfComp,
			int distance) {
		
		String result;
		if (isEvenSeatNumber && distance == 10) {
			result = (seatNumber + 9) + Constants.EMPTY_STRING;
		} else if (isEvenSeatNumber && distance == 4) {
			result = (seatNumber - 3) + Constants.EMPTY_STRING;
		} else if (!isEvenSeatNumber && distance == 1) {
			result = (startSeatOfComp + distance ) + Constants.EMPTY_STRING;
		} else {
			result = (seatNumber + 3) + Constants.EMPTY_STRING;
		}
		return result + " MS";
	}
 
	private static String findAisleSeatNumber(int seatNumber,
			boolean isEvenSeatNumber, int distance) {
		
		String result;
		if (isEvenSeatNumber && distance == 8) {
			result = (seatNumber + 5) + Constants.EMPTY_STRING;
		} else if (isEvenSeatNumber && distance == 2) {
			result = (seatNumber -7) + Constants.EMPTY_STRING;
		} else if (!isEvenSeatNumber && distance == 9) {
			result = (seatNumber + 7) + Constants.EMPTY_STRING;
		} else {
			result = (seatNumber - 5) + Constants.EMPTY_STRING;
		}
		return result + " AS";
	}
 
	private static String findWindowSeatNumber(int seatNumber,
			boolean isEvenSeatNumber, int endSeatOfComp,
			int startSeatOfComp, int distance) {
		
		String result;
		if (isEvenSeatNumber && distance == 6) {
			result = (seatNumber + 1) + Constants.EMPTY_STRING;
		} else if (!isEvenSeatNumber && distance == 5){
			result = (seatNumber - 1) + Constants.EMPTY_STRING;
		} else if (isEvenSeatNumber && distance == 0) {
			result = startSeatOfComp + Constants.EMPTY_STRING;
		} else {
			result = endSeatOfComp + Constants.EMPTY_STRING;
		}
		return result + " WS";
	}
}
