package com.problems.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TopKFrequentWords {

	public static void main(String[] args) {
		
		String[] words = {"i", "love", "leetcode", "i", "love", "coding"};
		words = new String[] {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
		List<String> top = topKFrequent(words, 4);
		System.out.println(top);
	}
	public static List<String> topKFrequent(String[] words, int k) {
		
		if (words == null) return null;
		if (words.length == 0) return new ArrayList<>();
		if (words.length == 1) return Arrays.asList(words);
		Map<String, Integer> wordCount = Arrays
				.stream(words)
				.collect(Collectors
				.toMap(w -> w, w -> 1, Integer::sum));
		return wordCount.entrySet()
			.stream()
			.sorted((keySet1, keySet2) -> {
				int val = keySet2.getValue().compareTo(keySet1.getValue());
				if (val == 0) {
					return keySet1.getKey().compareTo(keySet2.getKey());
				}
				return val;
			}).limit(k)
			.map(e -> e.getKey())
			.collect(Collectors.toList());
	}
}
