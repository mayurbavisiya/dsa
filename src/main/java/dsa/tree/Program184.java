package dsa.tree;

import java.util.LinkedList;
import java.util.Queue;

public class Program184 {

	public static void main(String[] args) {

		Node n = new Node(1);
		n.left = new Node(2);
		n.right = new Node(3);
		preOrder(n);
		preOrderiterative(n);
		// System.out.println(toSumTree(n));

	}

	private static void preOrderiterative(Node n) {
		System.out.println();
		if (n == null)
			return;
		Queue<Node> q = new LinkedList<Node>();
		q.add(n);
		while (!q.isEmpty()) {
			Node temp = q.poll();
			System.out.print(temp.data + " ");
			if (temp.left != null) {
				q.add(temp.left);
			}
			if (temp.right != null) {
				q.add(temp.right);
			}
		}
	}

	private static void preOrder(Node n) {
		if (n != null) {
			System.out.print(n.data + " ");
			preOrder(n.left);
			preOrder(n.right);
		}
	}
}
