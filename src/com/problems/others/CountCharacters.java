package com.problems.others;

public class CountCharacters {

	public static void main(String[] args) {
		String str = "arghya";
		printCharacterCount(str);
	}

	private static void printCharacterCount(String str) {
		
		if (str == null || str.isEmpty()) return;
		int len = str.length();
		int array[] = new int[26];
		for (int i =0; i < len; i++) {
		    
		    int index = 'z' - str.charAt(i);
		    array[index]++;
		}
		for (int i =0; i < len; i++) {
		    
		    char ch = str.charAt(i);
		    int count = array['z' - ch];
		    System.out.println("Character:" + ch + " Count: " + count);
		}
	}
}
