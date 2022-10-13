package dsa.strings;

public class Program69 {

	public static void main(String[] args) {
		System.out.println(editDistance("h", "abc"));
	}

	public static int editDistance(String s, String t) {

		return recMin(s, t, s.length(), t.length());
	}

	private static int recMin(String s, String t, int slen, int tlen) {

		if (slen == 0)
			return tlen;
		if (tlen == 0)
			return slen;

		if (s.charAt(slen - 1) == t.charAt(tlen - 1)) {
			return recMin(s, t, slen - 1, tlen - 1);
		} else
			return 1 + (Math.min(Math.min(recMin(s, t, slen - 1, tlen), recMin(s, t, slen, tlen - 1)),
					recMin(s, t, slen - 1, tlen - 1)));
	}

	public static int editDistanceDynamic(String s, String t) {

		int[][] dp = new int[s.length() + 1][t.length() + 1];
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[i].length; j++) {
				if (i == 0) {
					dp[i][j] = j;
				}
				if (j == 0) {
					dp[i][j] = i;
				}
			}
		}

		for (int i = 1; i <= s.length(); i++) {
			for (int j = 1; j <= t.length(); j++) {
				if (s.charAt(i - 1) == t.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1];
				} else {
					dp[i][j] = 1 + Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]);
				}

			}
		}
		return dp[s.length()][t.length()];
	}
}
