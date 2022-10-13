package dsa.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class Program191 {

	public static void main(String[] args) {
		Node n = new Node(8);
		n.left = new Node(3);
		n.right = new Node(10);

		n.left.left = new Node(1);

		n.right.left = new Node(6);
		n.right.left.left = new Node(4);
		n.right.left.right = new Node(7);

		n.right.right = new Node(14);
		n.right.right.left = new Node(13);
		System.out.println(diagonalTraverse(n));
	}

	static class QueueObj {
		Node node;
		int level;

		public QueueObj(Node node, int level) {
			this.level = level;
			this.node = node;
		}
	}

	private static ArrayList<ArrayList<Integer>> diagonalTraverse(Node node) {
		ArrayList<ArrayList<Integer>> op = new ArrayList<>();
		if (node == null)
			return op;
		Queue<QueueObj> q = new LinkedList<>();
		Map<Integer, LinkedList<Integer>> hm = new TreeMap<>();
		q.add(new QueueObj(node, 0));
		while (!q.isEmpty()) {
			QueueObj temp = q.poll();
			hm.computeIfAbsent(temp.level, k -> new LinkedList<>()).add(temp.node.data);
			if (temp.node.left != null) {
				q.add(new QueueObj(temp.node.left, temp.level - 1));
			}
			if (temp.node.right != null) {
				q.add(new QueueObj(temp.node.right, temp.level));
			}
		}

		System.out.println(hm);
		return op;
	}
}
