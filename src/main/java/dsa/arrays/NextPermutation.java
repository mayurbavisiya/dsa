package dsa.arrays;

import java.lang.reflect.Array;
import java.util.Arrays;

public class NextPermutation {

	public static void main(String[] args) {
		// printPerm("ABC");
		int[] nums = { 1, 5, 8, 4, 7, 6, 5, 3, 1 };
		nextPermutation(nums);
	}

	public static void nextPermutation(int[] nums) {
		// find next decreasing number from end
		int index = -1;
		for (int i = nums.length - 1; i > 0; i--) {
			if (nums[i] > nums[i - 1]) {
				index = i-1;
				break;
			}
		}

		// If no such element is found that means no any greater permutation is
		// possible, Hence we can simply reverse the array to get the smallest
		// perm
		if (index < 0) {
			int i = 0, j = nums.length - 1;
			while (i <= j) {
				swap(i, j, nums);
				i++;
				j--;
			}
			return;
		}

		// Find the element from that index which has immediate max element
		int temp = Integer.MAX_VALUE, swapindx = -1;

		for (int i = index; i < nums.length; i++) {
			if (nums[i] > nums[index] && nums[index] < temp) {
				temp = nums[i];
				swapindx = i;
			}
		}
		swap(swapindx, index, nums);

		int i = index + 1, j = nums.length - 1;
		while (i <= j) {
			swap(i, j, nums);
			i++;
			j--;
		}
		System.out.println(Arrays.toString(nums));
	}

	private static void swap(int i, int j, int[] nums) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

	// To understand this question first print all permutations for a string ABC
	public static void printPerm(String str) {
		perm(str, "");
	}

	private static void perm(String str, String ans) {
		if (str.isEmpty()) {
			System.out.print(ans + " ");
			return;
		}

		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			String ros = str.substring(0, i) + str.substring(i + 1, str.length());
			perm(ros, ans + c);
		}
	}

}
