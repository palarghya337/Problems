package com.problems.hackerearth.basicprogramming.inputoutput.easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.problems.utils.Log;

/**
 * <p>Rahul is a very busy persion he dont wan't to waste his time.
 * He keeps account of duration of each and every work. Now he
 * don't even get time to calculate duration of works, So your
 * job is to count the durations for each work and give it to rahul.
 * </p>
 * <b>Input:</b><br>
 * First line will be given by N number of works<br>
 * Next N line will be given SH,SM,EH and EM  each separated by
 * space(SH=starting hr, SM=starting min, EH=ending hr, EM=ending min)
 * <br><b>Output:</b><br>
 * N lines with duration HH MM(hours and minutes separated by space)
 * @author Bittu
 *
 */
public class Duration {

	public static void main(String[] args) {
		
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			
			int numberOfWorks = Integer.parseInt(br.readLine());
			while (numberOfWorks --> 0) {
				
				String inputs = br.readLine();
				String[] hourMinutes = inputs.split(" ");
				int startHours = Integer.parseInt(hourMinutes[0]);
				int endHours = Integer.parseInt(hourMinutes[2]);
				int startMinutes = Integer.parseInt(hourMinutes[1]);
				int endMinutes = Integer.parseInt(hourMinutes[3]);
				
				int diffHours = (((endHours - startHours) * 60) + (endMinutes - startMinutes)) / 60;
				int diffMinutes = (((endHours - startHours) * 60) + (endMinutes - startMinutes)) % 60;
				Log.logInfo(diffHours + " " + diffMinutes);
			}
		} catch (IOException e) {
			Log.logInfo(e.getMessage());
		}
	}
}
