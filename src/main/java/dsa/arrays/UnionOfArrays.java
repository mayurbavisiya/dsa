package dsa.arrays;

import java.util.HashSet;
import java.util.Set;

public class UnionOfArrays {
	public static void main(String[] args) {

	}

	public static int doUnion(int a[], int n, int b[], int m) {
		Set<Integer> s = new HashSet<Integer>();
		for (int i = 0; i < a.length; i++) {
			s.add(a[i]);
		}
		for (int i = 0; i < b.length; i++) {
			s.add(b[i]);
		}
		return s.size();
	}
}
