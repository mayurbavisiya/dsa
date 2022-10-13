package dsa.arrays;

public class Medianof2sortedarraysofequalsize {

	public static void main(String[] args) {
		int[] nums1 = {1,2}, nums2 = { 3,4};
		System.out.println(findMedianSortedArrays(nums1, nums2));
	}

	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		if (nums1.length > nums2.length)
			return findMedianSortedArrays(nums2, nums1);

		int n1 = nums1.length, n2 = nums2.length;
		int l = 0, h = n1;

		while (l <= h) {
			int cut1 = (l+h) >> 1;
			int cut2 = (n1 + n2 + 1) / 2 - cut1;

			int left1 = cut1 == 0 ? Integer.MIN_VALUE : nums1[cut1 - 1];
			int left2 = cut2 == 0 ? Integer.MIN_VALUE : nums2[cut2 - 1];

			int right1 = cut1 == n1 ? Integer.MAX_VALUE : nums1[cut1];
			int right2 = cut2 == n2 ? Integer.MAX_VALUE : nums2[cut2];

			if (left1 <= right1 && left2 <= right2) {
				if (n1 + n2 % 2 == 0) {
					return (double)((double) Math.max(left1, left2) + (double) Math.max(right1, right2) / 2.0);
				} else {
					return (double) Math.max(left1, left2);
				}
			} else if (left1 > right1) {
				h = cut1 - 1;
			} else {
				l = cut1 + 1;
			}
		}

		return 0.0;
	}
}
