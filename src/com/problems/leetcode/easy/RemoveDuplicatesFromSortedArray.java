package com.problems.leetcode.easy;

/**
 * Given a sorted array nums, remove the duplicates in-place
 * such that each element appear only once and return the new
 * length.
 * Do not allocate extra space for another array, you must do
 * this by modifying the input array in-place with O(1) extra
 * memory.
 */
public class RemoveDuplicatesFromSortedArray {

	public static void main(String[] args) {
		int[] nums = {0,0,1,1,1,2,2,3,3,4};
//		nums = new int[] {1};
//		nums = null;
		int len = removeDuplicates(nums);
		for (int i = 0; i < len; i++) {
			System.out.print(nums[i] + " ");
		}
	}
	public static int removeDuplicates(int[] nums) {
		
		if (nums == null || nums.length == 0) return 0;
		int numberOfIteration = nums.length - 1;
		int count = 0;
		for (int i = 0; i < numberOfIteration; i++) {
			if (nums[i] != nums[i + 1]) {
				nums[count++] = nums[i];
			}
		}
		if (count != 0 && nums[count - 1] != nums[numberOfIteration]) {
			nums[count] = nums[numberOfIteration];
		}
		return count + 1;
	}
}
