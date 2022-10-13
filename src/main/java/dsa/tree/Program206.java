package dsa.tree;

import java.util.ArrayList;
import java.util.List;

public class Program206 {

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(3);
		root.right = new Node(-1);

		root.left.left = new Node(2);
		root.left.right = new Node(1);
		root.left.right.left = new Node(1);

		root.right.right = new Node(5);
		root.right.left = new Node(4);

		root.right.right.right = new Node(6);

		root.right.left.left = new Node(1);
		root.right.left.right = new Node(2);

		printAllPath(root);
	}

	static int k = 5;
	static ArrayList<Integer> op = new ArrayList<>();

	public static void printAllPath(Node root) {
		List<ArrayList<Integer>> ls = new ArrayList<>();

		printAllPathUtil(root, ls, new ArrayList<>());
//		System.out.println(ls);
	}

	private static void printAllPathUtil(Node root, List<ArrayList<Integer>> res, ArrayList<Integer> ls) {
		if (root == null) {
			return;
		}
		ls.add(root.data);
		printAllPathUtil(root.left, res, ls);
		printAllPathUtil(root.right, res, ls);

		int sum = 0;
		for (int i = ls.size() - 1; i >= 0; i--) {
			sum += ls.get(i);
			if (sum == k) {
				printlist(ls, i);
			}
		}

		ls.remove(ls.size() - 1);
	}

	private static void printlist(ArrayList<Integer> ls, int i) {
		for (int j = i; j < ls.size(); j++) {
			System.out.print(ls.get(j) + " ");
		}
		System.out.println();
	}

	// private static void printAllPathUtil(Node root, List<ArrayList<Integer>>
	// res, ArrayList<Integer> ls) {
	// if (root == null) {
	// return;
	// }
	// if (root.data == k) {
	// op.add(root.data);
	// }
	// ls.add(root.data);
	// if (root.left != null) {
	// printAllPathUtil(root.left, res, ls);
	// }
	// if (root.right != null) {
	// printAllPathUtil(root.right, res, ls);
	// }
	// if (root.left == null && root.right == null) {
	// res.add(new ArrayList<>(ls));
	// }
	// ls.remove(ls.size() - 1);
	// }
}
