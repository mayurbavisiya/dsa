package dsa.arrays;

public class KadanesAlgo {

	static long maxSubarraySum(int arr[], int n) {
		long max = Integer.MIN_VALUE, maxatIndex = 0;
		for (int i = 0; i < n; i++) {
			maxatIndex = Math.max(maxatIndex + arr[i], arr[i]);
			max = Math.max(maxatIndex, max);
//			maxatIndex = Math.max(maxatIndex, 0);
		}
		return max;
	}

	public static void main(String[] args) {
		int[] arr = { -1, -2, -3, -4};
		int n = arr.length;
		System.out.println(maxSubarraySum(arr, n));
	}
}
