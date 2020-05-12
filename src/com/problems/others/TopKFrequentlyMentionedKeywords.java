package com.problems.others;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TopKFrequentlyMentionedKeywords {

	public static void main(String[] args) {
		
		int k = 2;
		String[] keywords = {"anacell", "cetracular", "betacellular"};
		String[] reviews = {
				  "Anacell provides the best services in the city",
				  "betacellular has awesome services",
				  "Best services provided by anacell, everyone should use anacell",
		};
		
		keywords = new String[] {"anacell", "betacellular", "cetracular", "deltacellular", "eurocell"};
		reviews = new String[] {
				  "I love anacell Best services; Best services provided by anacell",
				  "betacellular has great services",
				  "deltacellular provides much better services than betacellular",
				  "cetracular is worse than anacell",
				  "Betacellular is better than deltacellular.",
		};
		System.out.println(topKFrequentKeywords(keywords, reviews, k));
	}
	public static List<String> topKFrequentKeywords(String[] keywords,
			String[] reviews, int k) {
		
		if (keywords == null) return null;
		if (keywords.length == 0) return new ArrayList<>();
		if (reviews == null) {
			Arrays.sort(keywords);
			return Arrays.stream(keywords)
					.limit(k)
					.collect(Collectors.toList());
		}
		
		Map<String, Integer> map = new HashMap<>();
		for (int i = 0; i < reviews.length; i++) {
			
			String reviewLow = reviews[i].toLowerCase();
			for (int j = 0; j < keywords.length; j++) {
				
				String key = keywords[j];
				if (reviewLow.contains(key)) {
					map.put(key, map.getOrDefault(key, 0) + 1);
				}
			}
		}
		return map.entrySet()
				.stream()
				.sorted((kv1, kv2) -> {
					int val = kv2.getValue().compareTo(kv1.getValue());
					return val == 0 ? kv1.getKey().compareTo(kv2.getKey()) : val;
				}).limit(k)
				.map(kv -> kv.getKey())
				.collect(Collectors.toList());
	}
}
