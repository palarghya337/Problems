package com.problems.others;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class RearrangeArrayData {

	public static void main(String[] args) {
		
		int[] array = {6, 8, 9, 3, 5, 13, 15, 18, 11};
		Random random = new Random();
		array = IntStream.generate(() -> random.nextInt(50))
				.distinct()
				.limit(10)
				.toArray();
		rearrange(array);
		System.out.println(Arrays.toString(array));
	}

	/**
	 * Need to re arrange the number in such a way where good
	 * numbers should be at first and bad numbers should be
	 * at last and ideal numbers should be in the middle.
	 * Good numbers are those which are divisible by 2 and 3
	 * Ideal numbers are those which are divisible either by 2 or 3
	 * Bad numbers are those which are not divisible by 2 or three.
	 * @param array
	 */
	private static void rearrange(int[] array) {
		
		if (array != null && array.length > 1) {
			
			Arrays.sort(array);
			int length = array.length;
			int goodIndex = 0;
			int idealIndex = 0;
			int badIndex = 0;
			int[] good = new int[length];
			int[] ideal = new int[length];
			int[] bad = new int[length];
			for (int i = 0; i < length; i++) {
				
				int item = array[i];
				boolean divByTwo = item % 2 == 0;
				boolean divByThree = item % 3 == 0;
				if (divByTwo && divByThree) {
					good[goodIndex++] = item;
				} else if (divByTwo || divByThree) {
					ideal[idealIndex++] = item;
				} else {
					bad[badIndex++] = item;
				}
			}
			int index = 0;
			while (index < length) {
				if (index < goodIndex) {
					
					array[index] = good[index];
				} else if (index < goodIndex + idealIndex) {
					
					array[index] = ideal[index - goodIndex];
				} else {
					array[index] = bad[index - (idealIndex + goodIndex)];
				}
				index++;
			}
		}
	}
}
