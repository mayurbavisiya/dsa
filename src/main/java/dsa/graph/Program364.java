package dsa.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Program364 {
	public static void main(String[] args) {

	}

	static class Node {
		public int val;
		public List<Node> neighbors;

		public Node() {
			val = 0;
			neighbors = new ArrayList<Node>();
		}

		public Node(int _val) {
			val = _val;
			neighbors = new ArrayList<Node>();
		}

		public Node(int _val, ArrayList<Node> _neighbors) {
			val = _val;
			neighbors = _neighbors;
		}
	}

	static Map<Integer, Node> hm = new HashMap<Integer, Node>();
	
	public static Node cloneGraph(Node node) {
		if (node == null)
			return null;

		if(hm.containsKey(node.val))
			return hm.get(node.val);
		Node node1 = new Node(node.val);
		hm.put(node.val, node1);
		for (Node n : node.neighbors) {
			node1.neighbors.add(cloneGraph(n));
		}
		return node1;
	}

}
