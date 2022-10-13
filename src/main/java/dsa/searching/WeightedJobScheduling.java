package dsa.searching;

import java.util.Arrays;
import java.util.Comparator;

public class WeightedJobScheduling {

	public static void main(String[] args) {
		int[][] job = { {70,80,500},{ 1, 2, 50 }, { 3, 5, 20 }, { 6, 19, 100 }, { 2, 100, 200 } };

		Arrays.sort(job, new Comparator<int[]>() {
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
		});

		// { { 1, 2, 50 }, { 2, 100, 200 }, { 3, 5, 20 }, { 6, 19, 100 },{70,80,50} };
		int end1 = 0, end2 = 0, temp1 = 0, sum = 0, temp2 = 0, max = 0;
		for (int i = 0; i < job.length; i++) {
			end1 = job[i][1];
			end2 = job[i][1];
			temp1 = job[i][2];
			temp2 = job[i][2];
			for (int j = i + 1; j < job.length; j++) {
				if (job[j][0] >= end1) {
					temp1 += job[j][2];
					end1 = job[j][1];
				} else if (job[j][0] >= end2) {
					temp2 += job[j][2];
					end2 = job[j][1];
				}
				max = Math.max(temp2, temp1);
				sum = Math.max(sum, max);
			}
		}
		System.out.println(sum);
	}
}
