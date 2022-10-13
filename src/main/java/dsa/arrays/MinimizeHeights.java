package dsa.arrays;

import java.util.Arrays;

public class MinimizeHeights {
	public static void main(String[] args) {
		int[] arr = { 1, 5, 8, 10 };
		int n = arr.length, k = 2;
		System.out.println(getMinDiff(arr, n, k));
	}

	static int getMinDiff(int[] arr, int n, int k) {
		int min = 0, max = 0, diff = 0;
		Arrays.sort(arr);
		diff = arr[n - 1] - arr[0];
		for (int i = 1; i < n; i++) {
			if (arr[i] >= k) {
				min = Math.min(arr[0] + k, arr[i] - k);
				max = Math.max(arr[i - 1] + k, arr[n - 1] - k);
				diff = Math.min(max - min, diff);
			}
		}
		return diff;
	}
}
