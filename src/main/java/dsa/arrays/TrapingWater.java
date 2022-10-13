package dsa.arrays;

public class TrapingWater {

	static long trappingWater(int arr[], int n) {
		int[] left = new int[arr.length];
		int[] right = new int[arr.length];
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < left.length; i++) {
			max = Math.max(max, arr[i]);
			left[i] = Math.max(max, arr[i]);
		}

		max = Integer.MIN_VALUE;
		for (int i = right.length - 1; i >= 0; i--) {
			max = Math.max(max, arr[i]);
			right[i] = Math.max(max, arr[i]);
		}

		int trapWater = 0;
		for (int i = 0; i < arr.length; i++) {
			trapWater += Math.min(left[i], right[i]) - arr[i];
		}
		return trapWater;
	}

	public static void main(String[] args) {
		
		System.out.println("mayur".substring(1));
		int[] arr = { 3, 0, 0, 2, 0, 4 };
		int n = arr.length;
		System.out.println(trappingWater(arr, n));
	}
}
