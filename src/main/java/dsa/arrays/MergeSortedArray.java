package dsa.arrays;

public class MergeSortedArray {

	public static void merge(int[] nums1, int m, int[] nums2, int n) {
		int[] finalarr = new int[nums1.length];
		int i = 0, a = 0, b = 0;
		while (a < m && b < n) {
			if (nums1[a] <= nums2[b]) {
				finalarr[i++] = nums1[a++];
			}
			if (nums1[a] > nums2[b]) {
				finalarr[i++] = nums2[b++];
			}
		}
		while (a < m) {
			finalarr[i++] = nums1[a++];
		}
		while (b < nums2.length) {
			finalarr[i++] = nums2[b++];
		}

		i = 0;
		while (i < nums1.length) {
			nums1[i] = finalarr[i++];
		}
	}

	public static void main(String[] args) {
		int[] nums1 = { 1, 2, 3, 0, 0, 0 }, nums2 = { 2, 5, 6 };
		int m = 3, n = 3;
		merge(nums1, m, nums2, n);
	}
}
