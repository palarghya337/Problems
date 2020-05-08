package com.problems.leetcode.easy;

public class ReverseInteger {

	public static void main(String[] args) {
		System.out.println(reverse(-2147483648));
	}
	public static int reverse(int x) {
        
        long rNum = 0;
        while (x != 0) {
            
            int mod = x % 10;
            rNum = rNum * 10 + mod;
            if (rNum > Integer.MAX_VALUE
            		|| rNum < Integer.MIN_VALUE) {
            	return 0;
            }
            x = x / 10;
        }
        return (int) rNum;
    }
}
