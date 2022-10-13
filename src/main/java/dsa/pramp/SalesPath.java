package dsa.pramp;

import java.util.LinkedList;
import java.util.Queue;

public class SalesPath {

	public static void main(String[] args) {
		Node rootNode = new Node(0);
		rootNode.children = new Node[] { new Node(5), new Node(3), new Node(6) };
		rootNode.children[0].children = new Node[] { new Node(4) };
		rootNode.children[1].children = new Node[] { new Node(2), new Node(0) };
		rootNode.children[2].children = new Node[] { new Node(1), new Node(5) };
		rootNode.children[1].children[0].children = new Node[] { new Node(1) };
		rootNode.children[1].children[1].children = new Node[] { new Node(10) };
		rootNode.children[1].children[0].children[0].children = new Node[] { new Node(1) };
		System.out.println(getCheapestCost(rootNode));
	}

	static int getCheapestCost(Node rootNode) {
		if (rootNode == null)
			return 0;

		Queue<Node> q = new LinkedList<Node>();
		q.add(rootNode);
		int min = Integer.MAX_VALUE;
		while (q != null) {
			Node temp = q.poll();
			if (temp.children == null) {
				min = Math.min(min, temp.cost);
			} else {
				for (Node node : temp.children) {
					node.cost += temp.cost;
					q.add(node);
				}
			}
		}
		return min;
	}
}

class Node {
	int cost;
	Node[] children;
	Node parent;

	Node(int cost) {
		this.cost = cost;
		children = null;
		parent = null;
	}
}
