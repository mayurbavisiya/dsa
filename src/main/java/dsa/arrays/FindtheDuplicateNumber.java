package dsa.arrays;

import java.util.Arrays;

public class FindtheDuplicateNumber {

	public static void main(String[] args) {

		int[] nums = { 1, 0, 2 };
		System.out.println(findDuplicate(nums));
	}

	public static int findDuplicate(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			int temp = Math.abs(nums[i]);
			if (nums[temp] < 0) {
				return temp;
			}
			nums[temp] = -nums[temp];
		}
		return -1;
	}

	// nLogn
	public int findDuplicateNlogn(int[] nums) {
		Arrays.sort(nums);
		for (int i = 0; i < nums.length - 1; i++) {
			if (nums[i] == nums[i + 1]) {
				return nums[i];
			}
		}
		return -1;
	}
}
