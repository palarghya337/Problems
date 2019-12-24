package com.problems.others;

public class CoinChange {

	public static void main(String[] args) {
		
		int number = 7;
		int[] coins = {1,2,4,5};
		int len = coins.length - 1;
		for (int i = len; i >= 0; i--) {
			int j = i;
			for (int k = j; k >= 0; k = j - 1) {
				
				int n = number;
				int r = n - coins[i];
				while (n != 0) {
					
					if (r >= 0) {
						 n = r;
						 System.out.print(coins[j]);
					} else {
						j--;
						System.out.print("(" + j + ")");
					}
					r = n - coins[j];
				}
				System.out.println();
			}
		}
	}

	private static void findPattern(int number, int[] coins) {
		
		int n = number;
		int i = 0;
		while (n != 0) {
			
			int r = n - coins[i];
			if (r < 0) {
				i++;
			} else {
				n = r;
				System.out.print(coins[i]);
			}
		}
	}
}
