package dsa.strings;

import java.util.Arrays;

public class Program64 {

	public static void main(String[] args) {
		System.out.println(findLongestCommonSubSeqDP("psnw", "vozsh"));
	}

	public static int findLongestCommonSubSeqDP(String a, String b) {

		int[][] dp = new int[a.length() + 1][b.length() + 1];

		for (int i = 0; i < dp.length; i++)
			for (int j = 0; j < dp[i].length; j++)
				if (i == 0 || j == 0)
					dp[i][j] = 0;

		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[i].length; j++) {
				if (a.charAt(i - 1) == b.charAt(j - 1)) {
					dp[i][j] = 1 + dp[i-1][j-1];
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}

		return dp[a.length()][b.length()];
	}

	public static int findLongestCommonSubSeq(String a, String b) {

		int[][] dp = new int[a.length() + 1][b.length() + 1];
		for (int[] row : dp)
			Arrays.fill(row, -1);
		return findSeq(a, b, a.length(), b.length(), dp);
	}

	private static int findSeq(String a, String b, int i, int j, int[][] dp) {
		if (dp[i][j] != -1) {
			return dp[i][j];
		}
		if (i == 0 || j == 0) {
			return 0;
		} else {
			if (a.charAt(i - 1) == b.charAt(j - 1) && i != j) {
				dp[i][j] = 1 + findSeq(a, b, i - 1, j - 1, dp);
			} else {
				dp[i][j] = Math.max(findSeq(a, b, i - 1, j, dp), findSeq(a, b, i, j - 1, dp));
			}
		}
		return dp[i][j];

	}
}
