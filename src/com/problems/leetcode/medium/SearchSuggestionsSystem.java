package com.problems.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class SearchSuggestionsSystem {

	public static void main(String[] args) {
		String[] products = {"mobile","mouse","moneypot","monitor","mousepad"};
		String searchWord = "mobiles";
		
		products = new String[] {"bags","baggage","banner","box","cloths"};
		searchWord = "bags";
		
		products = new String[] {"havana"};
		searchWord = "havana";
		System.out.println(suggestedProducts2(products, searchWord));
	}
	/**
	 * Need to implement properly
	 * 
	 * @param products
	 * @param searchWord
	 * @return List<List<String>>
	 */
	public static List<List<String>> suggestedProducts2(String[] products,
			String searchWord) {
		
		if (searchWord == null || searchWord.isEmpty()) {
			return new ArrayList<>();
		}
		sort(products, 0, products.length - 1);
		int searchWordLength = searchWord.length();
		List<List<String>> sugg = new ArrayList<>();
		for (int i = 0; i < searchWordLength; i++) {
			
			int productsLength = products.length;
			String sub = searchWord.substring(0, i + 1);
			List<String> suggestion = new ArrayList<>();
			int index = search(products, sub, 0,
					productsLength - 1);
			if (index == -1) {
				
				while (sugg.size() != searchWordLength) {
					sugg.add(new ArrayList<>());
				}
				return sugg;
			}
			
			while (index > -1 && products[index].startsWith(sub)) {
				index--;
			}
			index++;
			while (suggestion.size() != 3
					&& index < productsLength
					&& products[index].startsWith(sub)) {
				suggestion.add(products[index++]);
			}
			sugg.add(suggestion);
		}
		return sugg;
	}
	private static int search(String[] products, String sub,
			int start, int end) {
		
		if (start <= end) {
			
			int mid = (start + end) / 2;
			boolean startsWithSub = products[mid].startsWith(sub);
			if (startsWithSub) {
				return mid;
			}
			
			if (products[mid].compareTo(sub) > 0) {
				return search(products, sub, start, mid);
			} else {
				return search(products, sub, mid + 1, end);
			}
		}
		return -1;
	}
	public static List<List<String>> suggestedProducts(String[] products,
			String searchWord) {
		
		if (searchWord == null || searchWord.isEmpty()) {
			return new ArrayList<>();
		}
		sort(products, 0, products.length - 1);
		List<List<String>> sugg = new ArrayList<>();
		for (int i = 0; i < searchWord.length(); i++) {
			
			String sub = searchWord.substring(0, i + 1);
			int end = products.length;
			int index = 0;
			int count = 0;
			List<String> suggestion = new ArrayList<>();
			while (index < end && count < 3) {
				if (products[index].startsWith(sub)) {
					
					suggestion.add(products[index]);
					count++;
				}
				index++;
			}
			sugg.add(suggestion);
		}
		return sugg;
	}
	private static void sort(String[] products, int i, int j) {
		
		if (i < j) {
			
			int mid = (i + j) / 2;
			sort(products, i, mid);
			sort(products, mid + 1, j);
			merge(products, i, j, mid);
		}
	}
	private static void merge(String[] products, int i,
			int j, int mid) {
		
		int s = i;
		int e = mid + 1;
		int index = 0;
		String arr[] = new String[j - i + 1];
		for (int k = i; k <= j; k++) {

			if (s > mid || (e <= j &&
					products[s].compareTo(products[e]) > 0)) {
				arr[index] = products[e++];
			} else {
				arr[index] = products[s++];
			}
			index++;
		}
		for (int k = 0; k < index; k++) {
			products[i++] = arr[k];
		}
	}
}
