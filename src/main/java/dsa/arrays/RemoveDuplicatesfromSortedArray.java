package dsa.arrays;

public class RemoveDuplicatesfromSortedArray {
	public static int removeDuplicates(int[] nums) {
		if (nums.length <= 1)
			return 1;
		int i = 0, j = nums.length - 1;
		for (int j2 = 0; j2 < nums.length; j2++) {
			int temp = nums[i];
			while (j2 < nums.length && temp == nums[j2]) {
				j2++;
			}
			if (j2 < nums.length) {
				i++;
				nums[i] = nums[j2];
			}
		}

		return i + 1;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 1 };
		System.out.println(removeDuplicates(nums));
	}
}
