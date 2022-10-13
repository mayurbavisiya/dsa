package dsa.arrays;

import java.util.Arrays;

public class Merge2SortArray {

	public static void main(String[] args) {
		int[] arr1 = { 1, 3, 5, 7 }, arr2 = { 0, 2, 6, 8, 9 };
		int m = arr1.length, n = arr2.length;
		merge(arr1, arr2, m, n);
	}

	public static void merge(int arr1[], int arr2[], int m, int n) {

		int i = m - 1, j = 0;
		while (i >= 0 && j < n) {
			if (arr1[i] > arr2[j]) {
				int temp = arr1[i];
				arr1[i] = arr2[j];
				arr2[j] = temp;
			}
			i--;
			j++;
		}
		Arrays.sort(arr1);
		Arrays.sort(arr2);

	}
}
