package dsa.arrays;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {

	public static void main(String[] args) {
		int[] nums = { 2, 7, 11, 15 };
		int target = 9;
		System.out.println(Arrays.toString(twoSum(nums, target)));
	}

	public static int[] twoSum(int[] nums, int target) {
		HashMap<Integer, Integer> hs = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (hs.containsKey(target - nums[i])) {
				return new int[] { hs.get(target - nums[i]), i };
			} else
				hs.put(nums[i], i);
		}

		return null;
	}
}
