package com.problems.leetcode.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

	public static void main(String[] args) {
	
		int nums[] = {0,4,3,0};
		int target = 0;
		int[] res = new TwoSum().twoSum(nums, target);
		System.out.println(Arrays.toString(res));
	}
	public int[] twoSum(int[] nums, int target) {
        
        int size = 0;
		int res[] = new int[2];
		if (nums == null || (size = nums.length) == 0) {
			return res;
		}
		Map<Integer, Integer> numbers = new HashMap<>(size);
		for (int i = 0; i < size; i++) {

			int val = nums[i];
			int remaining = target - val;
			Integer fIndex = numbers.get(remaining);
			if (fIndex != null && fIndex != i) {
				return new int[] {numbers.get(remaining), i};
			}
			numbers.put(val, i);
		}
		return res;
    }
}
