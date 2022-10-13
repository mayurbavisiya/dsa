package dsa.arrays;

import java.util.Arrays;

public class SquaresofaSortedArray {

	public static void main(String[] args) {
		int[] nums = { -4, -1, 0, 3, 10 };
		System.out.println(Arrays.toString(sortedSquares(nums)));
	}

	public static int[] sortedSquares(int[] nums) {
		int[] result = new int[nums.length];
		int i = 0, j = nums.length - 1, index = j;
		while (i <= j) {
			int left = nums[i] * nums[i], right = nums[j] * nums[j];
			if (left > right) {
				result[index--] = left;
				i++;
			} else {
				result[index--] = right;
				j--;
			}
		}
		return result;
	}
}
