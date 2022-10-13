package dsa.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Program177 {

	static ArrayList<Integer> res = new ArrayList<>();

	static ArrayList<Integer> levelOrder(Node node) {
		ArrayList<Integer> al = new ArrayList<>();
		if (node == null) {
			return al;
		}

		Queue<Node> q = new LinkedList<Node>();
		q.add(node);
		while (!q.isEmpty()) {
			Node n = q.poll();
			al.add(n.data);
			if (n.left != null) {
				q.add(n.left);
			}
			if (n.right != null) {
				q.add(n.right);
			}
		}

		return al;
	}

}

class Node {
	int data;
	Node left, right;

	Node(int item) {
		data = item;
		left = right = null;
	}
}