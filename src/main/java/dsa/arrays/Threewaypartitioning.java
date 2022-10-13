package dsa.arrays;

public class Threewaypartitioning {

	public static void threeWayPartition(int arr[], int a, int b) {

		int l = 0, r = arr.length - 1;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < l) {
				swap(arr, arr[i], arr[l]);
				l++;
			} else if(arr[i] > b){
				swap(arr, arr[i], arr[r]);
				r--;
			}
		}
	}

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void main(String[] args) {
		int[] array = {1, 2, 3, 3, 4 };
		int a = 1, b = 2;
		threeWayPartition(array, a, b);
	}
}
