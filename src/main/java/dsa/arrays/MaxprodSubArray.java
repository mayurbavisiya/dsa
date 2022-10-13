package dsa.arrays;

public class MaxprodSubArray {

	// static long maxProduct(int[] arr, int n) {
	// if (arr == null || arr.length == 0)
	// return 0;
	// long product = 1, maxProduct = 1, minproduct = 1, minmaxprouct = 1;
	// for (int i = 0; i < arr.length; i++) {
	// product = arr[i];
	// for (int j = i + 1; j < arr.length; j++) {
	// product *= arr[j];
	// maxProduct = Math.max(product, maxProduct);
	// }
	// }
	//
	// return maxProduct;
	// }

	static long maxProduct(int[] arr, int n) {
		if (arr == null || arr.length == 0)
			return 0;
		long curmin = arr[0], curmax = arr[0], res = arr[0];

		for (int i = 1; i < arr.length; i++) {
			if (arr[i] == 0) {
				curmax = 1;
				curmax = 1;
			}
			long temp1 = curmax * arr[i];
			long temp2 = curmin * arr[i];
			curmax = Math.max(Math.max(temp1, temp2), arr[i]);
			curmin = Math.min(Math.min(temp1, temp2), arr[i]);
			res = Math.max(curmax, res);
		}

		return res;
	}

	public static void main(String[] args) {
		int[] arr = {2,3,-2,4};
		int n = arr.length;
		System.out.println(maxProduct(arr, n));
	}
}
