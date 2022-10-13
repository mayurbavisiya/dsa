package dsa.searching;

import java.util.ArrayList;

public class Program102 {

	public static void main(String[] args) {
		int[] arr = { 15, 2, 45, 12, 7 };
		int n = arr.length;
		System.out.println(valueEqualToIndex(arr, n));
	}

	static ArrayList<Integer> valueEqualToIndex(int arr[], int n) {
		ArrayList<Integer> ls = new ArrayList<>();
		for (int i = 1; i <= arr.length; i++) {
			if (arr[i - 1] == i) {
				ls.add(i);
			}
		}
		return ls;
	}
}
