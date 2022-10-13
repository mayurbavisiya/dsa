package dsa.tree;

import java.util.ArrayList;

public class Program185 {

	public static void main(String[] args) {

		Node n = new Node(1);
		n.left = new Node(2);
		n.right = new Node(3);
		n.left.left = new Node(4);
		n.left.right = new Node(5);
		n.left.left.right = new Node(8);

		n.right.left = new Node(6);
		n.right.right = new Node(7);

		// Node n = new Node(4);
		// n.left = new Node(5);
		// n.right = new Node(2);
		//
		// n.right.left = new Node(3);
		// n.right.right = new Node(1);
		//
		// n.right.left.left = new Node(6);
		// n.right.left.right = new Node(7);

		System.out.println(leftView(n));
		// iterate(n);
	}

	static ArrayList<Integer> leftView(Node root) {
		ArrayList<Integer> ls = new ArrayList<>();
		// if (root == null)
		// return ls;
		iterate(root, ls, 1);
		return ls;
	}

	static int maxLevel = 0;

	private static void iterate(Node root, ArrayList<Integer> ls, int level) {
		if (root == null)
			return;
		if (maxLevel < level) {
			ls.add(root.data);
			maxLevel = level;
		}
		iterate(root.left, ls, level + 1);
		iterate(root.right, ls, level + 1);
	}

}
