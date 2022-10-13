package dsa.searching;

import java.util.ArrayList;

public class Program101 {

	static ArrayList<Long> find(long arr[], int n, int x) {

		long f = 0, l = 0;
		int low = 0, high = n - 1, res = -1;
		while (low <= high) {
			// Normal Binary Search Logic
			int mid = (low + high) / 2;
			if (arr[mid] > x)
				high = mid - 1;
			else if (arr[mid] < x)
				low = mid + 1;

			// If arr[mid] is same as
			// x, we update res and
			// move to the left half.
			else {
				res = mid;
				high = mid - 1;
			}
		}
		f = res;

		low = 0;
		high = n - 1;
		while (low <= high) {
			// Normal Binary Search Logic
			int mid = (low + high) / 2;
			if (arr[mid] > x)
				high = mid - 1;
			else if (arr[mid] < x)
				low = mid + 1;

			// If arr[mid] is same as
			// x, we update res and
			// move to the left half.
			else {
				res = mid;
				low = mid + 1;
			}
		}
		l = res;
		ArrayList<Long> ls = new ArrayList<>();
		ls.add(f);
		ls.add(l);
		return ls;

	}

	static ArrayList<Long> find1(long arr[], int n, int x) {
		long f = 0, l = 0;
		int low = 0, high = n, index = -1;
		while (low < high) {
			int mid = low + (high - low) / 2;
			if (arr[mid] > x) {
				high = mid - 1;
			} else if (arr[mid] < x) {
				low = mid + 1;
			} else {
				index = mid;
				high = mid - 1;			
			}
		}
		f = index;
		low = 0;
		high = n;
		while (low < high) {
			int mid = low + (high - low) / 2;
			if (arr[mid] > x) {
				high = mid - 1;
			} else if (arr[mid] < 1) {
				low = mid + 1;
			} else {
				index = mid;
				low = mid + 1;
			}
		}
		l = index;

		ArrayList<Long> ls = new ArrayList<>();
		ls.add(f);
		ls.add(l);
		return ls;
	}

	public static void main(String[] args) {
		long[] arr = { 1, 3, 5, 5, 5, 5, 7, 123, 125 };
		int n = arr.length, x = 5;
		System.out.println(find1(arr, n, x));
	}
}
