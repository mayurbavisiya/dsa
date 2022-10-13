package dsa.arrays;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Commonelements {

	ArrayList<Integer> commonElementsWithSpace(int A[], int B[], int C[], int n1, int n2, int n3) {
		// code here
		ArrayList<Integer> op = new ArrayList<Integer>();
		Set<Integer> s1 = new HashSet<Integer>(), s2 = new HashSet<Integer>();
		for (int i = 0; i < A.length; i++) {
			s1.add(A[i]);
		}
		for (int i = 0; i < B.length; i++) {
			s2.add(A[i]);
		}
		for (int i = 0; i < C.length; i++) {
			if (s1.contains(C[i]) && s2.contains(C[i])) {
				op.add(C[i]);
			}
		}
		return op;
	}

	static void commonElements(int A[], int B[], int C[], int n1, int n2, int n3) {

		ArrayList<Integer> op=new ArrayList<Integer>();
		int i = 0, j = 0, k = 0;
		while (i < A.length && j < B.length && k < C.length) {
			if (A[i] == B[j] && B[j] == C[k]) {
//				System.out.print(A[i] + " ");
				op.add(A[i]);
			} 
			
			if (A[i] < B[j]) {
				i++;
			} else if (B[j] < C[k]) {
				j++;
			} else {
				k++;
			}
		}
		
		System.out.println(op);
	}

	public static void main(String[] args) {
		int ar1[] = {3,3,3};
		int ar2[] = {3,3,3};
		int ar3[] = {3,3,3};
		commonElements(ar1, ar2, ar3, ar1.length, ar2.length, ar3.length);
	}
}
