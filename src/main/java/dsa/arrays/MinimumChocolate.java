package dsa.arrays;

import java.util.Arrays;

public class MinimumChocolate {

	public static long findMinDiff(long[] a, long n, long m) {
		Arrays.sort(a);
//		[1, 3, 4, 7, 9, 9, 12, 56]
		long packets = Integer.MAX_VALUE;
		for (int i = 0; i + m - 1< n; i++) {
			packets = Math.min(packets, a[(int) (i + m - 1)] - a[i]);
		}
		return packets;
	}

	public static void main(String[] args) {
		long[] a = {3, 4, 1, 9, 56, 7, 9, 12};
		long n = a.length, m = 5;

		System.out.println(findMinDiff(a, n, m));
	}
}
