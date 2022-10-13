package dsa.arrays;

public class BestTimeToBuySellStock {

	public static void main(String[] args) {
		int[] prices = { 2, 4, 1 };
		System.out.println(maxProfit(prices));

	}

	// public static int maxProfit(int[] prices) {
	// if (prices == null) {
	// return 0;
	// }
	// int maxProfit = Integer.MIN_VALUE;
	// int min = prices[0], max = prices[0];
	// for (int i = 0; i < prices.length; i++) {
	// if (prices[i] < min) {
	// min = prices[i];
	// max = prices[i];
	// } else if (prices[i] > max) {
	// max = prices[i];
	// }
	// maxProfit = Math.max(maxProfit, max - min);
	// }
	// return maxProfit = Math.max(maxProfit, max - min);
	//
	// }

	// TC O(n)
	public static int maxProfit(int[] prices) {
		int min = prices[0], max = prices[0], globalMax = 0;
		for (int i = 1; i < prices.length; i++) {
			if (prices[i] < min) {
				globalMax = Math.max(globalMax, max - min);
				min = prices[i];
				max = prices[i];
			}
			if (prices[i] > max) {
				max = prices[i];
			}
		}

		return Math.max(globalMax, max - min);
	}

	public static int maxProfit1(int[] prices) {
		// Find minimum at each iteration and subtract that min value at each
		// element
		int min = Integer.MAX_VALUE, profit = 0;
		for (int i = 0; i < prices.length; i++) {
			min = Math.min(min, prices[i]);
			profit = Math.max(profit, prices[i] - min);
		}
		return profit;
	}

	// O(n^2)
	public static int maxProfitBF(int[] prices) {
		int profit = 0;
		for (int i = 0; i < prices.length; i++) {
			for (int j = i + 1; j < prices.length; j++) {
				if (prices[j] > prices[i]) {
					profit = Math.max(profit, prices[j] - prices[i]);
				}
			}
		}
		return profit;
	}
}
