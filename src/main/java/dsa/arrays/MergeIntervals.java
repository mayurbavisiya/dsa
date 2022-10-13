package dsa.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class MergeIntervals {

	public static int[][] merge(int[][] intervals) {
		if (intervals == null)
			return null;
		Arrays.sort(intervals, new Comparator<int[]>() {

			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
		});

		// { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } }
		int start = intervals[0][0], end = intervals[0][1];
		ArrayList<int[]> ls = new ArrayList<int[]>();
		for (int i = 1; i < intervals.length; i++) {
			if (intervals[i][0] <= end) {
				end = Math.max(end,intervals[i][1]);
			} else {
				ls.add(new int[] { start, end });
				start = intervals[i][0];
				end = intervals[i][1];
			}
		}
		ls.add(new int[] { start, end });
		
		int[][] op = new int[ls.size()][2];

		for (int i = 0; i < ls.size(); i++) {
			op[i][0] = ls.get(i)[0];
			op[i][1] = ls.get(i)[1];
		}
		return op;
	}

	public static void main(String[] args) {
		// int[][] a = { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } };

		int[][] a = { { 1, 4 }, {2,3} };
		System.out.println(merge(a));
	}
}
