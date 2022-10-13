package dsa.arrays;

public class Minimumofoperationsrequiredtomakeanarraypalindrome {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 1 };
		System.out.println(findMinOperations(arr));
	}

	public static int findMinOperations(int[] arr) {
		int count = 0;
		int i = 0, j = arr.length - 1;
		while (i <= j) {
			if (arr[i] == arr[j]) {
				i++;
				j--;
			} else if (arr[i] > arr[j]) {
				j--;
				arr[j] = arr[j] + arr[j + 1];
				count++;
			} else {
				i++;
				arr[i] = arr[i] + arr[i - 1];
				count++;
			}
		}
		return count;
	}
}
