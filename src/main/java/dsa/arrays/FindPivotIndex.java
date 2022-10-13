package dsa.arrays;

public class FindPivotIndex {

	public static void main(String[] args) {
		int[] nums = { 1, 7, 3, 6, 5, 6 };
		System.out.println(pivotIndex(nums));
	}

	public static int pivotIndex(int[] nums) {
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
		}
		int left = 0;
		for (int i = 0; i < nums.length; i++) {
			if (sum - nums[i] - left == left) {
				return i;
			}
			left += nums[i];
		}
		return 0;
	}
}
