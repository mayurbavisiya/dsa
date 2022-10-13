package dsa.strings;

public class Program63 {

	public static void main(String[] args) {
		System.out.println(longestPalindrom("kjqlrzzfmlvyoshiktodnsjjp"));
	}

	public static String longestPalindrom(String s) {
		if (s == null || s.isEmpty()) {
			return "";
		}
		int maxLength = 0, startIndex = 0, lastIndex = 0;

		int[][] dp = new int[s.length()][s.length()];
		boolean flag = false;
		for (int i = 0; i < dp.length; i++) {

			dp[i][i] = 1;
			if (!flag) {
				startIndex = i;
				lastIndex = i + 1;
				maxLength = 1;
				flag = true;
			}
		}

		flag = false;
		for (int i = 0; i < dp.length - 1; i++) {
			if (s.charAt(i) == s.charAt(i + 1)) {
				dp[i][i + 1] = 1;
				if (!flag) {
					startIndex = i;
					lastIndex = i + 1 + 1;
					maxLength = 2;
					flag = true;
				}
			}
		}

		for (int i = 0; i < s.length(); i++) {
			for (int j = 0, k = 1 + i; j < dp.length && k < dp.length; j++, k++) {
				if (s.charAt(j) == s.charAt(k) && dp[j + 1][k - 1] == 1) {
					dp[j][k] = 1;

					if (k - j + 1 > maxLength) {
						startIndex = j;
						lastIndex = k + 1;
						maxLength = k - j + 1;
					}
				}
			}
		}
		return s.substring(startIndex, lastIndex);
	}
}
