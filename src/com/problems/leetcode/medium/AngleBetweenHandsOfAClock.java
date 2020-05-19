package com.problems.leetcode.medium;

public class AngleBetweenHandsOfAClock {

	public static void main(String[] args) {
		
		int hour = 3;
		int minutes = 15;
		double angle = new AngleBetweenHandsOfAClock()
				.angleClock(hour, minutes);
		System.out.println(angle);
	}
	public double angleClock(int hour, int minutes) {
        
        int perHourHourHand = 30;
        int perMinuteMinuteHand = 6;
        double perMinuteHourHand = 0.5;
        
        double degreeForMinuteHand = minutes * perMinuteMinuteHand;
        hour = hour == 12 ? 0 : hour;
        double degreeForHourHand = (perHourHourHand * hour) + (perMinuteHourHand * minutes);
        double finalDegrees = Math.abs(degreeForMinuteHand - degreeForHourHand);
        return finalDegrees > 180 ? 360 - finalDegrees : finalDegrees;
    }
}
