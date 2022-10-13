package dsa.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Program210 {
	public static void main(String[] args) {

		Node n = new Node(1);
		n.left = new Node(2);
		n.left.left = new Node(4);
		// n.left.right = new Node(5);

		n.right = new Node(3);
		n.right.left = new Node(2);
		n.right.right = new Node(4);
		n.right.left.left = new Node(4);

		printAllDups(n);
		// largestSumNode(n);

	}

	static Set<Node> s = new HashSet<>();

	static public List<Node> printAllDups(Node root) {
		solve(root);
		List<Node> ls = new ArrayList<Node>();
		for (int i = 0 ; i < hm.size() ; i++) {
			ls.add(root);
		}
		return ls;
	}

	static HashMap<String, Integer> hm = new HashMap<>();

	static private String solve(Node root) {
		if (root == null)
			return "";
		String s = "";
		s += "$";
		s += solve(root.left);
		s += root.data;
		s += solve(root.right);
		// s += "$";
		// if (hm.get(s) != null && hm.get(s) == 1)
		// System.out.print(root.data + " ");

		if (hm.containsKey(s))
			hm.put(s, hm.get(s) + 1);
		else
			hm.put(s, 1);

		return s;
	}
}
