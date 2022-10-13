package dsa.tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class Program201 {

	// static int checkMirrorTree(int n, int e, int[] A, int[] B) {
	// int i = 0, j = B.length, k = 0;
	// int prevNode = B[0];
	// while (i < j) {
	// if (i % 2 == 0) {
	// if (prevNode != B[i]) {
	// prevNode = B[i];
	// i--;
	// swap(B, k, i);
	// k = i+1;
	// }
	// }
	// i++;
	// }
	// i--;
	// swap(B,k,i);
	// Stack<Integer> st = new Stack<>();
	// Queue<Integer> q = new LinkedList<>();
	//
	// for (i = 0; i < A.length; i++) {
	// st.push(A[i]);
	// q.add(B[i]);
	// if (st.size() == 2) {
	// while (!st.isEmpty()) {
	// if (st.pop() != q.poll()) {
	// return 0;
	// }
	// }
	// }
	// }
	// return 1;
	// }
	//
	// private static void swap(int[] b, int start, int end) {
	// while (start <= end) {
	// int t = b[start];
	// b[start] = b[end];
	// b[end] = t;
	// start++;
	// end--;
	// }
	// }

	public static void main(String[] args) {
		int n = 3, e = 2;
		int A[] = { 1, 2, 1, 3, 1, 4, 4, 7, 4, 8, 4, 9, 3, 6, 2, 5, 6, 10, 6, 11, 6, 12 },
				B[] = { 1, 4, 1, 3, 1, 2, 4, 9, 4, 8, 4, 7, 3, 6, 6, 12, 6, 11, 6, 10, 2, 5 };
		System.out.println(checkMirrorTree(n, e, A, B));
	}

	private static int checkMirrorTree(int n, int e, int[] a, int[] b) {
		int[] a1 = new int[a.length / 2];
		int[] a2 = new int[a.length / 2];
		int[] b1 = new int[b.length / 2];
		int[] b2 = new int[b.length / 2];

		int eindex = 0, oindex = 0;
		for (int i = 0; i < a.length; i++) {
			if (i % 2 == 0) {
				a1[eindex] = a[i];
				b1[eindex] = b[i];
				eindex++;
			} else {
				a2[oindex] = a[i];
				b2[oindex] = b[i];
				oindex++;
			}
		}

		Map<Integer, Stack<Integer>> hm1 = new HashMap<Integer, Stack<Integer>>();
		Map<Integer, Queue<Integer>> hm2 = new HashMap<Integer, Queue<Integer>>();
		for (int i = 0; i < b2.length; i++) {
			hm1.computeIfAbsent(a1[i], k -> new Stack<>()).add(a2[i]);
			hm2.computeIfAbsent(b1[i], k -> new LinkedList<Integer>()).add(b2[i]);
		}
		if (hm1.size() != hm2.size()) {
			return 0;
		}

		for (Map.Entry<Integer, Stack<Integer>> en : hm1.entrySet()) {
			if (!hm1.containsKey(en.getKey())) {
				return 0;
			} else {
				Stack<Integer> st = en.getValue();
				Queue<Integer> q = hm2.get(en.getKey());
				if(st.size() != q.size()){
					return 0;
				}
				while(!st.isEmpty() && !q.isEmpty()){
					if(st.pop() != q.poll()){
						return 0;
					}
				}
			}
		}
		return 1;
	}
}
