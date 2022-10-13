package dsa.arrays;

import java.util.HashMap;
import java.util.Map;

public class findKthAppearElements {

	static void KthElements(int[] arr, int k) {
		int count = arr.length / k;
		int res = 0;
		Map<Integer, Integer> hm = new HashMap<Integer, Integer>();
		for (int i = 0; i < arr.length; i++) {
			hm.put(arr[i], hm.getOrDefault(arr[i], 0) + 1);
		}

		for (Map.Entry<Integer, Integer> en : hm.entrySet()) {
			if(en.getValue() > count)
				res++;
		}
		System.out.println(res);
	}

	public static void main(String[] args) {
		int[] arr = { 3, 1, 2, 2, 1, 2, 3, 3 };
		KthElements(arr, 4);
	}
}
