package dsa.arrays;

public class BestTimetoBuyandSellStock {

	public static void main(String[] args) {
		int[] prices = { 1, 2 };
		System.out.println(maxProfit(prices));
	}

	public static int maxProfit(int[] prices) {
		int min = Integer.MAX_VALUE, profit = 0;
		for (int i = 0; i < prices.length; i++) {
			min = Math.min(min, prices[i]);
			profit = Math.max(profit, prices[i] - min);
		}
		return profit;
	}
}
