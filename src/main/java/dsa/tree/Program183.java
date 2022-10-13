package dsa.tree;

import java.util.Stack;

public class Program183 {

	public static void main(String[] args) {

		Node n = new Node(1);
		n.left = new Node(3);
		n.right = new Node(2);
		postOrder(n);
		postOrderiterative(n);
		// System.out.println(toSumTree(n));
	}

	private static void postOrderiterative(Node n) {
		System.out.println();
		if (n == null)
			return;
		Stack<Node> st = new Stack<>();
		Stack<Node> q = new Stack<Node>();
		q.add(n);
		while (!q.isEmpty()) {
			Node temp = q.pop();
			if (temp.left != null) {
				q.add(temp.left);
			}
			if (temp.right != null) {
				q.add(temp.right);
			}
			st.add(temp);
		}
		while (!st.isEmpty()) {
			System.out.print(st.pop().data + " ");
		}

	}

	private static void postOrder(Node n) {
		if (n != null) {
			postOrder(n.left);
			postOrder(n.right);
			System.out.print(n.data + " ");
		}
	}

	public static void toSumTree(Node root) {

	}
}
