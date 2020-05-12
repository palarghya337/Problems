package com.problems.leetcode.easy;

public class PalindromerNumber {

	public static void main(String[] args) {
		System.out.println(isPalindrome2(121));
	}
	public static boolean isPalindrome(int x) {

		if (x < 0) return false;
		int rNumber = 0;
		int number = x;
		while (number != 0) {
			
			int r = number % 10;
			rNumber = rNumber * 10 + r;
			number = number / 10;
		}
        return rNumber == x;
    }
	public static boolean isPalindrome2(int x) {
		
		if (x < 0) return false;
		String number = String.valueOf(x);
		int len = number.length();
		int i = 0;
		int j = len -1;
		while (i < j) {
			if (number.charAt(i++) != number.charAt(j--)) {
				return false;
			}
		}
		return true;
	}
}
