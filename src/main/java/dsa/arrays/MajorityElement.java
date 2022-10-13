package dsa.arrays;

public class MajorityElement {

	// 1) sort and take element on n/2 position
	// 2) take hashmap and count
	// 3) Moore's algo
	public static int majorityElement(int[] nums) {
		int count = 1, res = nums[0];
		for (int i = 0; i < nums.length; i++) {
			int num = nums[i];
			if (res == num)
				++count;
			else
				--count;
			if (count == 0) {
				res = num;
				count = 1;
			}
		}
		return res;
	}

	public static void main(String[] args) {
		int[] nums = { 3, 3, 4 };
		System.out.println(majorityElement(nums));
	}
}
