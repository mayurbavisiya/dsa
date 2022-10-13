package dsa.tree;

import java.util.ArrayList;

public class Program209 {

	public static void main(String[] args) {

		Node n = new Node(1);
		n.left = new Node(2);
		n.right = new Node(3);
		n.left.left = new Node(4);
		n.right.right = new Node(5);
		// System.out.println(kthanc(n, 5, 3));
		System.out.println(lca(n, 4));
	}

	static int k = 3;

	private static boolean lca(Node root, int a) {
		if (root == null)
			return false;
		if (root.data == a) {
			return true;
		}
		if (lca(root.left, a) || lca(root.right, a)) {
			if (k > 0) {
				k--;
			}
			if (k == 0) {
				System.out.println(root.data);
				k = Integer.MIN_VALUE;
			}
			return true;
		}
		return false;
	}

	private static int kthanc(Node root, int a, int k) {
		kThAncUtil(root, a, new ArrayList<>());
		int index = 0;
		for (int i = 0; i < res.size(); i++) {
			if (res.get(i) == a) {
				index = i;
				break;
			}
		}
		if (index - k < 0) {
			return -1;
		}

		return res.get(index - k);
	}

	static ArrayList<Integer> res = new ArrayList<>();

	private static void kThAncUtil(Node root, int a, ArrayList<Integer> ls) {
		if (root == null)
			return;
		ls.add(root.data);
		kThAncUtil(root.left, a, ls);
		kThAncUtil(root.right, a, ls);
		if (root.left == null && root.right == null) {
			if (ls.contains(a)) {
				res = new ArrayList<>(ls);
			}
		}
		ls.remove(ls.size() - 1);
	}

}
