package dsa.arrays;

import java.util.Arrays;

public class SortAnArraywitj012 {
	public static void main(String[] args) {
		int[] a = { 0, 2, 1, 2, 0 };
		sort012(a, a.length);
	}

	public static void sort012(int a[], int n) {
		int noOf1 = 0, noOf2 = 0, noOf0 = 0;
		for (int i = 0; i < a.length; i++) {
			if (a[i] == 0)
				noOf0++;
			else if (a[i] == 1)
				noOf1++;
			else if (a[i] == 2)
				noOf2++;
		}
		int index = 0;
		for (int i = 0; i < noOf0; i++) {
			a[index++] = 0;
		}
		for (int i = 0; i < noOf1; i++) {
			a[index++] = 1;
		}
		for (int i = 0; i < noOf2; i++) {
			a[index++] = 2;
		}
		System.out.println(Arrays.toString(a));
	}
}
