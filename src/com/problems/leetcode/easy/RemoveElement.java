package com.problems.leetcode.easy;

/**
 * <p>
 * Given an array nums and a value val, remove all instances
 * of that value in-place and return the new length.
 * </p><p>
 * Do not allocate extra space for another array, you must do
 * this by modifying the input array in-place with O(1) extra
 * memory.
 * </p><p>
 * The order of elements can be changed. It doesn't matter what
 * you leave beyond the new length.
 * </p>
 */
public class RemoveElement {

	public static void main(String[] args) {
		int[] nums = {3,2,2,3};
		nums = new int[] {0,1,2,2,3,0,4,2};
		int length = removeElement(nums, 2);
		for (int i = 0; i < length; i++) {
			System.out.print(nums[i] + " ");
		}
	}
	public static int removeElement(int[] nums, int val) {
		
		if (nums == null || nums.length == 0) return 0;
		int numberOfIteration = nums.length;
		int count = 0;
		for (int i = numberOfIteration - 1; i > -1; i--) {
			if (val == nums[i]) {
				
				count++;
				int index = i;
				/*
				 * Below code is to find the proper location
				 * to swap
				 **/
				while (++index < numberOfIteration
						&& nums[index] != val);
				if (index - 1 < numberOfIteration) {
					
					nums[i] = nums[index - 1];
					nums[index -1] = val;
				}
			}
		}
		return numberOfIteration - count;
	}
}
