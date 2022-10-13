package dsa.arrays;

import java.util.Arrays;

public class CyclicRotate {

	public static void main(String[] args) {
		int[] a = {1,2};
		rotate(a, 2);
	}

	public static void rotate(int arr[], int n) {
		int rotate = (n > arr.length) ? n - arr.length : n;
		if(n == arr.length)
			rotate--;
		while (rotate > 0) {
			int temp = arr[0];
			for (int k = 0; k < arr.length - 1; k++) {
				arr[k] = arr[k + 1];
			}
			arr[arr.length - 1] = temp;
			rotate--;
		}
		System.out.println(Arrays.toString(arr));
	}
}
