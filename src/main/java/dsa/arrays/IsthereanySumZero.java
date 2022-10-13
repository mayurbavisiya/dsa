package dsa.arrays;
import java.util.HashSet;
import java.util.Set;

public class IsthereanySumZero {

	static boolean findsum(int arr[], int n) {

		if (arr == null || arr.length == 0)
			return false;

		Set<Integer> hs = new HashSet<Integer>();
		hs.add(arr[0]);
		for (int i = 1; i < arr.length; i++) {
			arr[i] = arr[i - 1] + arr[i];
			if (arr[i] == 0 || hs.contains(arr[i]))
				return true;
			hs.add(arr[i]);
		}
		return false;
	}

	public static void main(String[] args) {
		int[] arr = { 4, 2, -3, 1, 6 };
		int n = arr.length;
		System.out.println(findsum(arr, n));
	}
}
