package dsa.searching;

import java.util.Arrays;

public class Program110 {

	public static void main(String[] args) {
		int[] arr = { 5, 20, 3, 2, 5, 80 };
	
		int size = arr.length, n = 78;

		System.out.println(findPair(arr, size, n));
	}

	public static boolean findPair(int arr[], int size, int n) {
		Arrays.sort(arr);
		for (int i = 0; i < arr.length; i++) {
			int x = arr[i] + n;
			if (findEle(arr, x))
				return true;
		}
		return false;
	}

	private static boolean findEle(int[] arr, int x) {

		int low = 0, high = arr.length;
		while (low < high) {
			int mid = low + (high - low) / 2;
			if (arr[mid] == x)
				return true;
			else if (arr[mid] < x) {
				low = mid + 1;
			} else
				high = mid;
		}
		return false;
	}
}
