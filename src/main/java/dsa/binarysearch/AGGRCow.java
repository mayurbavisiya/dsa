package dsa.binarysearch;

import java.util.Arrays;

public class AGGRCow {

	public static void main(String[] args) {
		int[] barn = { 10, 20, 30, 40 };
		int cows = 2;
		System.out.println(maxMinDist(barn, cows));
	}

	static int maxMinDist(int[] barn, int cows) {
		Arrays.sort(barn);
		// int start = barn[0], end = barn[barn.length - 1], res = -1;
		int start = 0, end = 0, res = -1;
		for (int i = 0; i < barn.length; i++) {
			start = Math.max(start, barn[i]);
			end += barn[i];
		}
		while (start <= end) {
			int mid = start + ((end - start) / 2);
			if (valid(barn, mid, cows)) {
				res = mid;
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return res;
	}

	private static boolean valid(int[] barn, int mid, int cows) {
		int dist = 1;
		int sum = 0;
		for (int i = 0; i < barn.length; i++) {
			sum += barn[i];
			if (sum > mid) {
				dist++;
				sum = barn[i];
			}
		}
		if (dist > cows)
			return false;
		return true;
	}
}
