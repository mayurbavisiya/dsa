package dsa.arrays;

import java.util.HashSet;
import java.util.Set;

public class FindlongestConsecutive {

	static int findLongestConseqSubseq(int arr[], int n) {
		int seq = 0;
		Set<Integer> hs = new HashSet<Integer>();
		for (int i = 0; i < arr.length; i++) {
			hs.add(arr[i]);
		}
		for (int i = 0; i < arr.length; i++) {
			int num = arr[i];
			if (!hs.contains(num - 1)) {
				int temp = num, count = 1;
				while (hs.contains(temp + 1)) {
					temp++;
					count++;
				}
				seq = Math.max(seq, count);
			}
		}
		return seq;
	}

	public static void main(String[] args) {
		int[] arr = { 2, 6, 1, 9, 4, 5, 3 };
		int N = arr.length;
		System.out.println(findLongestConseqSubseq(arr, N));
	}
}
