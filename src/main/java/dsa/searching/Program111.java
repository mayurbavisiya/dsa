package dsa.searching;

import java.util.ArrayList;
import java.util.Arrays;

public class Program111 {

	public static void main(String[] args) {
		int[] arr = { 0, 0, 2, 1, 1 };
		int k = 3;
		System.out.println(fourSum(arr, k));
	}

	static public ArrayList<ArrayList<Integer>> fourSum(int[] A, int X) {
		int n = A.length;
		ArrayList<ArrayList<Integer>> ls = new ArrayList<>();
		int l, r;

		// Sort the array in increasing order, using library
		// function for quick sort
		Arrays.sort(A);

		/*
		 * Now fix the first 2 elements one by one and find the other two
		 * elements
		 */
		for (int i = 0; i < n - 3; i++) {
			for (int j = i + 1; j < n - 2; j++) {
				// Initialize two variables as indexes of the first and last
				// elements in the remaining elements
				l = j + 1;
				r = n - 1;

				// To find the remaining two elements, move the index
				// variables (l & r) toward each other.
				while (l < r) {
					if (A[i] + A[j] + A[l] + A[r] == X) {
						ArrayList<Integer> tl = new ArrayList<>();
						tl.add(A[i]);
						tl.add(A[j]);
						tl.add(A[l]);
						tl.add(A[r]);
						ls.add(tl);
//						System.out.println(A[i] + " " + A[j] + " " + A[l] + " " + A[r]);
						l++;
						r--;
					} else if (A[i] + A[j] + A[l] + A[r] < X)
						l++;
					else // A[i] + A[j] + A[l] + A[r] > X
						r--;
				} // end of while
			} // end of inner for loop
		} // end of outer for loop
		return ls;
	}
}
