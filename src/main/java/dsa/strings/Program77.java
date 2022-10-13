package dsa.strings;

import java.util.Arrays;

public class Program77 {

	public static void main(String[] args) {
		System.out.println(countSPDP("aaaaa"));
	}

	static long countSPDP(String str) {
		int n = str.length(), j;
		long M = 1000000007;
		long dp[][] = new long[n][n];
		for (int l = 0; l < n; l++) {
			for (int i = 0; i < n - l; i++) {
				j = l + i;
				if (i == j) {
					dp[i][i] = 1;
				} else if (str.charAt(i) == str.charAt(j)) {
					dp[i][j] = 1 + dp[i + 1][j] + dp[i][j - 1];
				} else {
					dp[i][j] = dp[i + 1][j] + dp[i][j - 1] - dp[i + 1][j - 1];
				}
				dp[i][j] += M;
				dp[i][j] %= M;
			}
		}
		return dp[0][n - 1];
	}

	static long countPS(String str) {
		long M = 1000000007;
		long[][] dp = new long[str.length() + 1][str.length() + 1];
		for (int i = 0; i < dp.length; i++) {
			Arrays.fill(dp[i], -1);
		}
		long count = recSP(str, 0, str.length() - 1, dp);

		return count % M;
	}

	private static long recSP(String str, int i, int j, long[][] dp) {

		if (i > j || j < i) {
			return 0;
		}
		if (i == j)
			return 1;
		if (dp[i][j] != -1) {
			return dp[i][j];
		}
		if (str.charAt(i) == str.charAt(j)) {
			return dp[i][j] = 1 + recSP(str, i + 1, j, dp) + recSP(str, i, j - 1, dp);
		}
		return dp[i][j] = recSP(str, i + 1, j, dp) + recSP(str, i, j - 1, dp) - recSP(str, i + 1, j - 1, dp);
	}
}
