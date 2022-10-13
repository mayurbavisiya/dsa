package dsa.strings;

import java.util.HashMap;
import java.util.Map;

public class Program84 {

	static String secFrequent(String arr[], int N) {
		Map<String, Integer> hm = new HashMap<String, Integer>();
		for (int i = 0; i < arr.length; i++) {
			hm.put(arr[i], hm.getOrDefault(arr[i], 0) + 1);
		}

		int max = Integer.MIN_VALUE, secMax = Integer.MIN_VALUE;
		String ans = "";
		for (Map.Entry<String, Integer> en : hm.entrySet()) {

			if (en.getValue() > max) {
				max = en.getValue();
			}
		}

		for (Map.Entry<String, Integer> en : hm.entrySet()) {
			if (en.getValue() > secMax && en.getValue() < max) {
				secMax = en.getValue();
				ans = en.getKey();
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		String[] arr = { "ghi", "ghi", "aaa", "ghi", "ghi", "ghi", "ghi" };
		int N = 0;

		System.out.println(secFrequent(arr, N));
	}
}
