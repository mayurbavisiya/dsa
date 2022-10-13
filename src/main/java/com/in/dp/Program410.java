package com.in.dp;

import java.util.Arrays;

public class Program410 {

	public static void main(String[] args) {
		int[] S = { 1, 2, 3 };
		int m = 3, n = 4;
		System.out.println(count(S, m, n));
	}

//	public static long count(int S[], int m, int n) {
//		long count = 0;
//		long[][] dp = new long[n + 1][n + 1];
//		for (int i = 0; i < dp.length; i++) {
//			for (int j = 0; j < dp[i].length; j++) {
//				dp[i][j] = -1;
//			}
//		}
//		count = recursion(0, n, S, m, dp);
//		return count;
//	}
//
//	private static long recursion(int ind, int sum, int[] s, int n, long[][] dp) {
//		if (sum == 0) {
//			return 1;
//		}
//		if (ind < 0 || ind >= n) {
//			return 0;
//		}
//		if (dp[ind][sum] != -1)
//			return dp[ind][sum];
//
//		long left = recursion(ind, sum - s[ind], s, n, dp);
//		long right = recursion(ind + 1, sum, s, n, dp);
//
//		return dp[ind][sum] = left + right;
//	}

	public static long help(int ind, int sum, int S[], int n, long t[][]) {
		if (sum == 0) {
			return 1;
		}
		if (ind >= n || sum < 0)
			return 0;

		if (t[ind][sum] != -1)
			return t[ind][sum];

		long left = help(ind, sum - S[ind], S, n, t);
		long right = help(ind + 1, sum, S, n, t);
		return t[ind][sum] = left + right;
	}

	public static long count(int S[], int m, int n) {
		// code here.
		long t[][] = new long[m][n + 1];
		for (long val[] : t) {
			Arrays.fill(val, -1);
		}
		return help(0, n, S, m, t);
	}
}
