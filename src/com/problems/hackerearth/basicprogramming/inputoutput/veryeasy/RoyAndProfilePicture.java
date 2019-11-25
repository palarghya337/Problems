package com.problems.hackerearth.basicprogramming.inputoutput.veryeasy;

import java.util.Scanner;

import com.problems.utils.Constants;
import com.problems.utils.Log;

/**
 * Roy wants to change his profile picture on Facebook. Now Facebook
 * has some restriction over the dimension of picture that we can
 * upload. Minimum dimension of the picture can be L x L, where L is
 * the length of the side of square.
 * Now Roy has N photos of various dimensions. Dimension of a photo
 * is denoted as W x H where W - width of the photo and H - Height
 * of the photo When any photo is uploaded following events may occur:
 * [1] If any of the width or height is less than L, user is prompted
 * to upload another one. Print "UPLOAD ANOTHER" in this case.
 * [2] If width and height, both are large enough and
 * (a) if the photo is already square then it is accepted. Print
 * "ACCEPTED" in this case.
 * (b) else user is prompted to crop it. Print "CROP IT" in this case.
 * (quotes are only for clarification)
 * Given L, N, W and H as input, print appropriate text as output.
 * 
 * * @author Bittu
 *
 */
public class RoyAndProfilePicture {

	public static void main(String[] args) {
		
		try (Scanner scanner = new Scanner(System.in)) {
			
			Log.logInfo("Length of Square: ");
			int lengthOfSquare = Integer.parseInt(scanner.nextLine());
			String[][] photos = fetchInputs(scanner);
			printResult(lengthOfSquare, photos);
		}
	}

	private static void printResult(int lengthOfSquare, String[][] photos) {
		
		for (int i = 0; i < photos.length; i++) {
			
			int width = Integer.parseInt(photos[i][0]);
			int hight = Integer.parseInt(photos[i][1]);
			
			if (width < lengthOfSquare || hight < lengthOfSquare) {
				Log.logInfo("UPLOAD ANOTHER");
			} else if (width == hight) {
				Log.logInfo("ACCEPTED");
			} else {
				Log.logInfo("CROP IT");
			}
		}
	}

	private static String[][] fetchInputs(Scanner scanner) {
		
		Log.logInfo("Enter number of photos to upload");
		int numberOfPhotos = Integer.parseInt(scanner.nextLine());
		int index = 0;
		String[][] photos = new String[numberOfPhotos][2];
		while (numberOfPhotos != 0) {
			
			Log.logInfo("width x hight (i.e.- 120 300)");
			String widthHightsString = scanner.nextLine();
			photos[index++] = widthHightsString.split(Constants.EMPTY_SPACE);
			numberOfPhotos--;
		}
		return photos;
	}
}
