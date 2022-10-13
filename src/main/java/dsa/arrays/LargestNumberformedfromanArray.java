package dsa.arrays;

import java.util.Arrays;
import java.util.Comparator;

public class LargestNumberformedfromanArray {

	public static void main(String[] args) {
		String[] arr = { "3", "30", "34", "5", "9" };
		System.out.println(printLargest(arr));
	}

	static String printLargest(String[] arr) {
		Arrays.sort(arr, new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				String xy = s1 + s2;
				String yx = s2 + s1;
				return yx.compareTo(xy);
						
			}
		});
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < arr.length; i++) {
			sb.append(arr[i]);
		}
		return sb.toString();
	}
}
