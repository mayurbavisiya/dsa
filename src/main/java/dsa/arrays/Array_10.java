package dsa.arrays;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;

public class Array_10 {

	public static void main(String[] args) {

		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		int[] a = { -12, 11, -13, -5, 6, -7, 5, -3, -6 };
		for (int i = 0; i < a.length; i++) {
			pq.add(a[i]);
		}

		process(a);
		System.out.println(Arrays.toString(a));
	}

	private static void process(int[] arr) {
		int j = 0, temp;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < 0) {
				if (i != j) {
					temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
				j++;
			}
		}
	}

	private static void swap(int[] a, int m, int i) {
		int temp = a[m];
		a[m] = a[i];
		a[i] = temp;
	}
}
