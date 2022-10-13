package dsa.arrays;

import java.util.HashSet;
import java.util.Set;

public class ArraySubsetofanotherarray {

	public static String isSubset(long a1[], long a2[], long n, long m) {
		Set<Long> hs = new HashSet<Long>();
		for (int i = 0; i < a1.length; i++) {
			hs.add(a1[i]);
		}
		for (int i = 0; i < a2.length; i++) {
			if (!hs.contains(a2[i])) {
				return "No";
			}
		}
		return "Yes";
	}

	public static void main(String[] args) {
		long[] a1 = { 11, 1, 13, 21, 3, 7 }, a2 = { 11, 3, 7, 1 };
		System.out.println(isSubset(a1, a2, a1.length, a2.length));
	}
}
