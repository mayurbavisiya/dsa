package dsa.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Program186 {

	public static void main(String[] args) {
		Node n = new Node(1);
		n.left = new Node(2);
		n.right = new Node(3);
		n.left.left = new Node(4);
		n.left.right = new Node(5);
		n.left.left.right = new Node(8);

		n.right.left = new Node(6);
		n.right.right = new Node(7);
		System.out.println(rightView(n));
	}

	static ArrayList<Integer> rightView(Node node) {
		ArrayList<ArrayList<Integer>> ls = new ArrayList<>();
		if (node == null)
			return null;
		Queue<Node> q = new LinkedList<Node>();
		q.add(node);
		while (!q.isEmpty()) {
			int n = q.size();
			ArrayList<Integer> tls = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				Node temp = q.poll();
				tls.add(temp.data);
				if (temp.left != null)
					q.add(temp.left);
				if (temp.right != null)
					q.add(temp.right);
			}
			ls.add(tls);
		}
		ArrayList<Integer> op = new ArrayList<>();
		for (ArrayList<Integer> l : ls) {
			op.add(l.get(l.size() - 1));
		}
		return op;
	}
}
