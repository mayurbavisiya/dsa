package dsa.arrays;

import java.util.HashMap;
import java.util.Map;

public class TripletSuminArray {

	public static boolean find3Numbers(int A[], int n, int X) {
		Map<Integer, Integer> hs = new HashMap<Integer, Integer>();
		for (int i = 0; i < A.length; i++) {
			hs.put(A[i],i);
		}
		int temp = 0;
		for (int i = 0; i < A.length; i++) {
			temp = A[i];
			for (int j = i + 1; j < A.length; j++) {
				temp += A[j];
				if (hs.containsKey(X - temp) && hs.get(X - temp) != j) {
					System.out.println(A[i] + " " + A[j] + " " + (X - temp));
					return true;
				}
				temp -= A[j];
			}
		}
		return false;
	}

	public static void main(String[] args) {
		int[] A = { 589, 343, 609, 61, 222, 759, 955, 889, 147, 691, 950, 844, 431, 621, 749, 68, 537, 784, 36, 227,
				186, 39, 854, 630, 225, 749, 924, 360, 258, 767, 945, 956, 319, 727, 412, 26, 356, 2, 550, 497, 585,
				516, 965, 343, 76, 914, 143, 197, 949, 73 };
		find3Numbers(A, A.length, 182);
	}
}
