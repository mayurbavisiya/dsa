package dsa.searching;

public class Program103 {

	public static void main(String[] args) {
		int[] nums = { 4, 5, 6, 7, 0, 1, 2 };
		int target = 0;
		System.out.println(search(nums, target));
	}

	public static int search(int[] nums, int target) {
		if (nums.length == 0) {
			return -1;
		}

		return binarySearch(nums, 0, nums.length - 1, target);

	}

	public static int binarySearch(int[] nums, int start, int end, int target) {

		if (start == end && nums[start] != target) {
			return -1;
		}
		int middle = start + (end - start) / 2;
		if (nums[middle] == target) {
			return middle;
		}
		int left = -1;
		int right = -1;
		if (middle - 1 >= start) {
			left = binarySearch(nums, start, middle - 1, target);
		}
		if (middle + 1 <= end) {
			right = binarySearch(nums, middle + 1, end, target);
		}
		return Math.max(left, right);
	}
}
