package com.in.dp;

import java.util.Arrays;

public class Program411 {

	public static void main(String[] args) {
		int n = 3, W = 4;
		int values[] = { 1, 2, 3 }, weight[] = { 4, 5, 1 };
		System.out.println(knapSack(W, weight, values, n));
	}

	static int knapSack(int W, int wt[], int val[], int n) {
		int vLen = val.length;
		int[][] dp = new int[vLen + 1][W + 1];

		// i -> represents index of wt[] / val[]
		// j -> represents index of capacity (W)
		for (int i = 1; i <= vLen; i++) {
			for (int j = 1; j <= W; j++) {
				// If weight of ith item is greater than current knapsack
				// capacity (j)
				if (wt[i - 1] > j)
					dp[i][j] = dp[i - 1][j];
				// If weight of ith item is less than or equal to current
				// knapsack capacity (j), then
				// the max profit is going to be max of -
				// 1. Whatever max weight we calculated until now for the same
				// knapsack capacity (j) for previous item (i-1)
				// 2. Adding the current profit to the calculated max profit for
				// remaining knapsack capacity (j - wt[i])
				else
					dp[i][j] = Math.max(dp[i - 1][j], val[i - 1] + dp[i - 1][j - wt[i - 1]]);
			}
		}
		return dp[vLen][W];
	}

	static int knapSack11(int w, int wt[], int val[], int n) {
		int maxVal = 0;
		int[][] dp = new int[n][w + 1];
		for (int[] a : dp) {
			Arrays.fill(a, -1);
		}
		maxVal = knapscakUtil(0, w, wt, val, dp, n);
		return maxVal;
	}

	private static int knapscakUtil(int ind, int w, int[] wt, int[] val, int[][] dp, int n) {
		if (ind >= n)
			return 0;
		if (w <= 0)
			return 0;
		if (dp[ind][w] != -1)
			return dp[ind][w];
		if (wt[ind] <= w) {
			int left = val[ind] + knapscakUtil(ind + 1, w - wt[ind], wt, val, dp, n);
			int right = knapscakUtil(ind + 1, w, wt, val, dp, n);
			return dp[ind][w] = Math.max(left, right);
		} else {
			return dp[ind][w] = knapscakUtil(ind + 1, w, wt, val, dp, n);
		}
	}

}
