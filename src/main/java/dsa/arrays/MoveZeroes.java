package dsa.arrays;

import java.util.Arrays;

public class MoveZeroes {

	public static void main(String[] args) {
		int[] nums = { 0, 1, 0, 3, 12 };
		moveZeroes(nums);
	}

	public static void moveZeroes(int[] nums) {
		int i = 0, j = 0;
		while (i < nums.length) {
			if (nums[i] != 0) {
				nums[j] = nums[i];
				j++;
			}
			i++;
		}
		while(j < nums.length){
			nums[j++] = 0;
		}
		System.out.println(Arrays.toString(nums));
	}
}
