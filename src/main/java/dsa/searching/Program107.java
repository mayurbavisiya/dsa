package dsa.searching;

import java.util.Arrays;

public class Program107 {

	public static void main(String[] args) {
		int[] arr = { 13, 33, 43, 16, 25, 19, 23, 31, 29, 35, 10, 2, 32, 11, 47, 15, 34, 46, 30, 26, 41, 18, 5, 17, 37,
				39, 6, 4, 20, 27, 9, 3, 8, 40, 24, 44, 14, 36, 7, 38, 12, 1, 42, 12, 28, 22, 45 };

		int n = arr.length;
		System.out.println(Arrays.toString(findTwoElement(arr, n)));
	}

	static int[] findTwoElement(int arr[], int n) {
		int i;
		int re = 0, mi = 0;
		for (i = 0; i < n; i++) {
			int abs_val = Math.abs(arr[i]);
			if (arr[abs_val - 1] > 0)
				arr[abs_val - 1] = -arr[abs_val - 1];
			else
				re = abs_val;
		}

		for (i = 0; i < n; i++) {
			if (arr[i] > 0)
				mi = i + 1;
		}
		return new int[] { re, mi };
	}
}
