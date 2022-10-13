package dsa.arrays;

public class BuyAndSellStcokTwice {

	// First variation only one transaction
	public static int maxProfitFirst(int[] arr) {
		int min = Integer.MAX_VALUE, max = 0;
		for (int i = 0; i < arr.length; i++) {
			min = Math.min(min, arr[i]);
			max = Math.max(arr[i] - min, max);
		}
		return max;
	}

	// second variation buy and sell as many times u want
	public static int maxProfitSecond(int[] arr) {
		int max = 0;
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > arr[i - 1]) {
				max += arr[i] - arr[i - 1];
			}
		}
		return max;
	}

	// Third variation buy and sell as many times u want
	public static int maxProfit(int[] arr) {
		int k = 2;
		int maxDiff = Integer.MIN_VALUE, profit = 0;
		int[][] dp = new int[k][arr.length];
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[i].length; j++) {
				if (i == 0 || j == 0) {
					dp[i][j] = 0;
//					if (j > 0)
//						maxDiff = Math.max(maxDiff, dp[i][j - 1] - arr[j]);
					continue;
				}
				maxDiff = Math.max(maxDiff, dp[i][j-1] - arr[j]);
				dp[i][j] = Math.max(dp[i][j - 1], arr[j] + maxDiff);
				profit = Math.max(profit, dp[i][j]);
			}
		}
		return profit;
	}

	public static void main(String[] args) {
		int[] arr = { 2, 4, 8, 6, 7 };
		System.out.println(maxProfit(arr));
	}
}
