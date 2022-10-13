package dsa.arrays;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;

public class KthSmallElement {
	public static int findKthLargest(int[] nums, int k) {

		PriorityQueue<Integer> maxheap = new PriorityQueue<Integer>(Collections.reverseOrder());
		for (int i = 0; i < nums.length; i++) {
			maxheap.add(nums[i]);
			if (maxheap.size() > k) {
				maxheap.poll();
			}

		}
		return maxheap.poll();
	}

	public static void main(String[] args) {
		int[] a = { 7, 10, 4, 3, 20, 15 };
		quicksort(a, 0, a.length - 1);
		System.out.println(findKthLargest(a, 3));
	}

	private static void quicksort(int[] arr, int start, int last) {

		int i = start + 1, j = last, temp;
		if (i > j)
			return;
		while (i <= j) {
			if (arr[i] < arr[start]) {
				i++;
			}
			if (arr[j] > arr[start]) {
				j--;
			}
			if (i <= j) {
				temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}

		temp = arr[start];
		arr[start] = arr[j];
		arr[j] = temp;

		quicksort(arr, start, j - 1);
		quicksort(arr, j + 1, last);
	}

}
