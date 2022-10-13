package dsa.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class Program192 {

	public static void main(String[] args) {

		Node n = new Node(1);
		n.left = new Node(2);
		n.right = new Node(3);
		n.left.left = new Node(4);
		n.left.right = new Node(5);
		n.left.right.left = new Node(8);
		n.left.right.right = new Node(9);

		n.right.left = new Node(6);
		n.right.right = new Node(7);
		// n.left.left = new Node(1);
		//
		// n.right.left = new Node(6);
		// n.right.left.left = new Node(4);
		// n.right.left.right = new Node(7);
		//
		// n.right.right = new Node(14);
		// n.right.right.left = new Node(13);

		// postorder(n);
		printBoundary(n);
		// System.out.println(printBoundary(n));
	}

	ArrayList<Integer> boundary(Node node) {
		return null;
	}

	static ArrayList<Integer> printBoundary(Node node) {

		ArrayList<Integer> left = leftView(node);
		System.out.println(left);
		ArrayList<Integer> right = rightView(node);
		System.out.println(right);
		ArrayList<Integer> botmaview = bottomView(node);
		System.out.println(botmaview);
		ArrayList<Integer> op = new ArrayList<>();
		op.addAll(left);
		op.addAll(botmaview);
		op.addAll(right);
		System.out.println(op);
		return op;
	}

	private static ArrayList<Integer> bottomView(Node node) {
		Map<Integer, LinkedList<Integer>> hm = new TreeMap<Integer, LinkedList<Integer>>();
		Queue<QueueObj> q = new LinkedList<QueueObj>();
		q.add(new QueueObj(node, 0));
		while (!q.isEmpty()) {
			QueueObj temp = q.poll();
			hm.computeIfAbsent(temp.hd, a -> new LinkedList<>()).add(temp.node.data);
			if (temp.node.left != null) {
				q.add(new QueueObj(temp.node.left, temp.hd - 1));
			}
			if (temp.node.right != null) {
				q.add(new QueueObj(temp.node.right, temp.hd + 1));
			}
		}

		ArrayList<Integer> op = new ArrayList<>();
		for (Map.Entry<Integer, LinkedList<Integer>> en : hm.entrySet()) {
			op.add(en.getValue().get(en.getValue().size() - 1));
		}
		return op;
	}

	static class QueueObj {
		Node node;
		int hd;
		// boolean visited;

		public QueueObj(Node node, int hd) {
			this.node = node;
			this.hd = hd;
			// this.visited = visited;
		}
	}

	static ArrayList<Integer> leftView(Node root) {
		ArrayList<Integer> ls = new ArrayList<>();
		if (root == null)
			return ls;
		iterate(root, ls, 1);
		return ls;
	}

	static int maxlevel = 0;

	private static void iterate(Node root, ArrayList<Integer> ls, int level) {
		if (root == null)
			return;
		// if (root.left == null && root.right == null)
		// return;
		// if (maxlevel < level) {
		// ls.add(root.data);
		// maxlevel = level;
		// }
		if (root.left != null) {
			iterate(root.left, ls, level + 1);
		}
		if (root.right != null) {
			iterate(root.right, ls, level + 1);
		}
	}

	static ArrayList<Integer> rightView(Node root) {
		ArrayList<Integer> ls = new ArrayList<>();
		maxlevel = 0;
		if (root == null)
			return ls;
		rightViewUtil(root, ls, 0);
		return ls;
	}

	private static void rightViewUtil(Node root, ArrayList<Integer> ls, int level) {
		if (root == null)
			return;
		// if (root.right == null && root.left == null)
		// return;
		// if (maxlevel < level) {
		// ls.add(root.data);
		// maxlevel = level;
		// }
		if (root.right != null) {
			rightViewUtil(root.right, ls, level + 1);
		}
		if (root.left != null) {
			rightViewUtil(root.left, ls, level + 1);
		}
	}

}
