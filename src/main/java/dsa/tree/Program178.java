package dsa.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Program178 {

	public static void main(String[] args) {
		Node n = new Node(1);
		n.left = new Node(3);
		n.right = new Node(2);
		System.out.println(reverseLevelOrder(n));
	}

	public static ArrayList<Integer> reverseLevelOrder(Node node) {

		ArrayList<Integer> al = new ArrayList<>();
		if (node == null) {
			return al;
		}

		Queue<Node> q = new LinkedList<Node>();
		q.add(node);
		while (!q.isEmpty()) {
			Node n = q.poll();
			al.add(n.data);
			if (n.right != null) {
				q.add(n.right);
			}
			if (n.left != null) {
				q.add(n.left);
			}
		}
		Collections.reverse(al);
		return al;

	}
}
