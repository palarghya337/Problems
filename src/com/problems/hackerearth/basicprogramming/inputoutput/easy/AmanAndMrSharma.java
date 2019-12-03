package com.problems.hackerearth.basicprogramming.inputoutput.easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.problems.utils.Log;

/**
 * <p>On a distant planet far away from Earth lives a boy named Aman.
 * He loves to run everyday.But his running distance is directly
 * affected by how much horlicks his mother mixed in his milk today.
 * If his mother has mixed x grams of horlicks,then Aman will be
 * capable of running 100*x meters at most on that day.</p>
 * <p>Aman's instructor, Mr.Sharma ,is a very strict yet very caring.
 * Everyday he asks Aman to run around a circle of radius r once.
 * If Aman is able to complete the circle,he would get a toffee.</p>
 * <b>Note:Take value of pie=22/7.<b><br>
 * <p><b>CONSTRAINTS:<b><br>
 * 1<=d<105<br>
 * 1<=r<106<br>
 * 1<=x<=104<br></p>
 * <b>INPUT:</b>
 * <p>First line contains d,no. of days Aman goes to his instructor.
 * Next d lines each contain r,radius of circle and x,amount of
 * horlicks.</p>
 * <b>OUTPUT:</b>
 * <p>Print total number of toffees Aman would finally have at the
 * end of d days.</p>
 * @author Bittu
 *
 */
public class AmanAndMrSharma {

	public static void main(String[] args) {
		
		try (BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in))) {
			
			int numberOfDays = Integer.parseInt(scanner.readLine());
			int toffees = 0;
			while (numberOfDays --> 0) {
			    
				String radiusHorlicks = scanner.readLine();
				String[] radiusHorlicksArr = radiusHorlicks.split(" ");
				int radius = Integer.parseInt(radiusHorlicksArr[0]);
				int horlicksAmount = Integer.parseInt(radiusHorlicksArr[1]);
				double area = 2 * radius * (22 / 7f);
				if (area <= horlicksAmount * 100) {
					toffees++ ;
				}
			}
			Log.logInfo(toffees);
		} catch (IOException e) {
			Log.logInfo(e.getMessage());
		}
	}
}
