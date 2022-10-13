package dsa.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class Program187 {

	public static void main(String[] args) {

		Node n = new Node(1);
		n.left = new Node(2);
		n.right = new Node(3);
		n.left.left = new Node(4);
		n.left.right = new Node(5);
		n.left.left.right = new Node(8);

		n.right.left = new Node(6);
		n.right.right = new Node(7);
		System.out.println(topView(n));

	}
// To get the top view we have to use here the concept of vertical line or Horizontal distance from the y axis
	// HD of the root will be 0
	// HD of the left node will be parent node HD-1 and for the right will be HD+1
	// To keep the value of the HD with the Node we have to create a Class call NodeObj having node and HD as a properties 
	static class QueueObj {
		Node node;
		int hd;

		public QueueObj(Node node, int hd) {
			this.node = node;
			this.hd = hd;
		}
	}

	static ArrayList<Integer> topView(Node node) {

		Map<Integer, LinkedList<Integer>> hm = new TreeMap<Integer, LinkedList<Integer>>();
		if (node == null)
			return null;
		Queue<QueueObj> q = new LinkedList<QueueObj>();
		q.add(new QueueObj(node, 0));
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
			op.add(en.getValue().get(0));
		}
		return op;

	}
}
