package dsa.strings;

import java.util.ArrayList;
import java.util.List;

public class Program70 {

	static List<Integer> nextPermutation(int n, int nums[]) {
		// find next decreasing number from end
		List<Integer> ls = new ArrayList<Integer>();
		int index = -1;
		for (int i = nums.length - 1; i > 0; i--) {
			if (nums[i] > nums[i - 1]) {
				index = i - 1;
				break;
			}
		}

		// If there is no such index simply swap the entire array
		if (index < 0) {
			int i = 0, j = nums.length - 1;
			while (i <= j) {
				swap(i, j, nums);
				i++;
				j--;
			}
			for (int j2 = 0; j2 < nums.length; j2++) {
				ls.add(nums[j2]);
			}
			return ls;
		}

		// Else find the immediate next number from index+1 to end
		int temp = Integer.MAX_VALUE, swapindx = -1;

		for (int i = index + 1; i < nums.length; i++) {
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
		for (int j2 = 0; j2 < nums.length; j2++) {
			ls.add(nums[j2]);
		}
		return ls;
	}

	private static void swap(int i, int j, int[] nums) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

	public static void main(String[] args) {
		int[] arr = { 62, 92, 96, 43, 28, 37, 92, 5, 3, 54, 93, 83, 22 };
		int n = arr.length;
		System.out.println(nextPermutation(n, arr));
	}
}
