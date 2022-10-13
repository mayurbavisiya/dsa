package dsa.strings;

public class Program68 {

	public static void main(String[] args) {
		int[] nums = { 3, 2, 2 };
		int k = 4;
		System.out.println(solveWordWrap(nums, k));
	}

	// 0 1 2
	//
	// 0 [[1, 0, 1],
	// 1 [0, 4, INF],
	// 2 [0, 0, 4]]
	// public static int solveWordWrap(int[] words, int k) {
	// int[][] dp = new int[nums.length][nums.length];
	// for (int i = 0; i < nums.length; i++) {
	// dp[i][i] = k - nums[i];
	// for (int j = i + 1; j < nums.length; j++) {
	// dp[i][j] = dp[i][j - 1] - nums[j] - 1;
	// }
	// }
	// for (int i = 0; i < nums.length; i++) {
	// for (int j = i; j < nums.length; j++) {
	// if (dp[i][j] < 0) {
	// dp[i][j] = Integer.MAX_VALUE;
	// } else {
	// dp[i][j] = (int) Math.pow(dp[i][j], 2);
	// }
	// }
	// }
	//
	// int[] minCost = new int[nums.length];
	// int[] result = new int[nums.length];
	//
	// // 0 1 2 3
	// // 0 [[9, 0, 9, INF],
	// // 1 [0, 16, INF, 1],
	// // 2 [0, 0, 16, INF],
	// // 3 [0, 0, 0, 1]]
	//
	// for (int i = result.length - 1; i >= 0; i--) {
	// minCost[i] = dp[i][nums.length - 1];
	//
	// result[i] = nums.length;
	// for (int j = result.length - 1; j > i; j--) {
	// if (dp[i][j - 1] == Integer.MAX_VALUE) {
	// continue;
	// }
	// if (minCost[i] > minCost[j] + dp[i][j - 1]) {
	// minCost[i] = minCost[j] + dp[i][j - 1];
	// result[i] = j;
	// }
	// }
	// }
	//
	// return minCost[0];
	//
	public static int solveWordWrap(int[] words, int width) {

		int cost[][] = new int[words.length][words.length];

		// next 2 for loop is used to calculate cost of putting words from
		// i to j in one line. If words don't fit in one line then we put
		// Integer.MAX_VALUE there.
		for (int i = 0; i < words.length; i++) {
			cost[i][i] = width - words[i];
			for (int j = i + 1; j < words.length; j++) {
				cost[i][j] = cost[i][j - 1] - words[j] - 1;
			}
		}

		for (int i = 0; i < words.length; i++) {
			for (int j = i; j < words.length; j++) {
				if (cost[i][j] < 0) {
					cost[i][j] = Integer.MAX_VALUE;
				} else {
					cost[i][j] = (int) Math.pow(cost[i][j], 2);
				}
			}
		}

		// minCost from i to len is found by trying
		// j between i to len and checking which
		// one has min value
//		int minCost[] = new int[words.length];
//		int result[] = new int[words.length];
//		for (int i = words.length - 1; i >= 0; i--) {
//			minCost[i] = cost[i][words.length - 1];
//			result[i] = words.length;
//			for (int j = words.length - 1; j > i; j--) {
//				if (cost[i][j - 1] == Integer.MAX_VALUE) {
//					continue;
//				}
//				if (minCost[i] > minCost[j] + cost[i][j - 1]) {
//					minCost[i] = minCost[j] + cost[i][j - 1];
//					result[i] = j;
//				}
//			}
//		}
		
		int minCost[] = new int[words.length];
		int result[] = new int[words.length];
		for (int i = 1; i < result.length; i++) {
			minCost[i] = Integer.MAX_VALUE;
			result[i] = i;
			for (int j = 1; j <= i; j++) {
				if(minCost[j-1] != Integer.MAX_VALUE && cost[j][i] !=  Integer.MAX_VALUE && minCost[j-1]+cost[j][i] < minCost[i]){
					minCost[i]  =minCost[j-1]+cost[j][i] ;
					result[i] = j;
				}
			}
		}
		return minCost[0];
	}
}
