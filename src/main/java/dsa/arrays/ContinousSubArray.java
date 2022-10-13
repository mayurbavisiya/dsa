package dsa.arrays;

public class ContinousSubArray {

	public static void main(String[] args) {
		int[] a = { 1, 2, 3, -2, 5 };
		System.out.println(maxSubarraySum(a, a.length));
	}

	static int maxSubarraySum(int arr[], int n) {
		int max = 0, globalMax = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			max = Math.max(arr[i], arr[i] + max);
			globalMax = Math.max(globalMax, max);
		}

		return globalMax;
	}
}
