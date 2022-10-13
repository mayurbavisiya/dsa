package dsa.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Program189 {

	public static void main(String[] args) {

		Node n = new Node(1);
		n.left = new Node(2);
		n.right = new Node(3);
		n.left.left = new Node(4);
		n.left.right = new Node(5);
		n.left.left.right = new Node(8);

		n.right.left = new Node(6);
		n.right.right = new Node(7);
		System.out.println(zigZagTraversal(n));

	}

	static ArrayList<Integer> zigZagTraversal(Node root) {
		ArrayList<ArrayList<Integer>> ls = new ArrayList<ArrayList<Integer>>();
		if (root == null)
			return null;
		Queue<Node> q = new LinkedList<Node>();
		q.add(root);

		while (!q.isEmpty()) {
			int n = q.size();
			ArrayList<Integer> tl = new ArrayList<Integer>();
			for (int i = 0; i < n; i++) {
				Node tmp = q.poll();
				tl.add(tmp.data);
				if (tmp.left != null)
					q.add(tmp.left);
				if (tmp.right != null)
					q.add(tmp.right);
			}
			ls.add(tl);
		}
		ArrayList<Integer> op = new ArrayList<Integer>();
		boolean left = true;
		for (ArrayList<Integer> en : ls) {
			if (left) {
				op.addAll(en);
				left = false;
			}else{
				Collections.reverse(en);
				op.addAll(en);
				left = true;
			}
		}
		return op;
	}
}
