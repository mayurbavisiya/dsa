package dsa.arrays;

import java.util.Arrays;

public class CountInversion {

	public static void main(String[] args) {
		int[] arr = { 12, 11, 13, 5, 6, 7, 2 };
		int[] temp = new int[arr.length];
		mergeSort(arr, temp, 0, arr.length - 1);
		System.out.println(Arrays.toString(arr));
		System.out.println(inv);
	}

	static int inv = 0;

	static void mergeSort(int[] arr, int[] temp, int l, int h) {
		if (l < h) {
			int m = l + (h - l) / 2;
			mergeSort(arr, temp, l, m);
			mergeSort(arr, temp, m + 1, h);
			merge(arr, temp, l, m, h);
		}
	}

	private static void merge(int[] arr, int[] temp, int l, int m, int h) {
		int i = l, j = m + 1, k = l;
		while (i <= m && j <= h) {
			if (arr[i] <= arr[j]) {
				temp[k++] = arr[i++];
			} else {
				temp[k++] = arr[j++];
				inv += m - l;
			}
		}
		while (i <= m) {
			temp[k++] = arr[i++];
		}
		while (j <= h) {
			temp[k++] = arr[j++];
		}

		for (int k2 = l; k2 <= h; k2++) {
			arr[k2] = temp[k2];
		}
	}

}
