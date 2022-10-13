package dsa.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class Program188 {

	public static void main(String[] args) {

		Node n = new Node(1);
		n.left = new Node(2);
		n.right = new Node(3);
		n.left.left = new Node(4);
		n.left.right = new Node(5);
		n.left.left.right = new Node(8);

		n.right.left = new Node(6);
		n.right.right = new Node(7);
		System.out.println(bottomView(n));

	}

	public static ArrayList<Integer> bottomView(Node root) {

		Map<Integer, LinkedList<Integer>> hm = new TreeMap<Integer, LinkedList<Integer>>();
		if (root == null)
			return null;
		Queue<QueueObj> q = new LinkedList<QueueObj>();
		q.add(new QueueObj(root, 0));
		// hm.computeIfAbsent(0, k -> new LinkedList<>()).add(node.data);
		while (!q.isEmpty()) {
			QueueObj tmpNode = q.poll();
			hm.computeIfAbsent(tmpNode.hd, k -> new LinkedList<>()).add(tmpNode.node.data);
			if (tmpNode.node.left != null) {
				q.add(new QueueObj(tmpNode.node.left, tmpNode.hd - 1));
			}
			if (tmpNode.node.right != null) {
				q.add(new QueueObj(tmpNode.node.right, tmpNode.hd + 1));
			}
		}
		System.out.println(hm);
		ArrayList<Integer> op = new ArrayList<>();
		for (Map.Entry<Integer, LinkedList<Integer>> en : hm.entrySet()) {
			op.add(en.getValue().get(en.getValue().size() - 1));
		}
		return op;

	}

	static class QueueObj {
		Node node;
		int hd;

		public QueueObj(Node node, int hd) {
			this.node = node;
			this.hd = hd;
		}
	}
}
