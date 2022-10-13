package dsa.tree;

import java.util.HashMap;
import java.util.Map;

public class Program200 {

	public static void main(String[] args) {
		Node n = new Node(1);
		n.left = new Node(2);
		n.right = new Node(3);

		n.left.left = new Node(4);
		n.left.right = new Node(5);

		n.right.right = new Node(2);
		n.right.right.left = new Node(4);
		n.right.right.right = new Node(5);
		// inorder(n);
		System.out.println(dupSub(n));
	}

	// static int dupSub(Node root) {
	// if (root == null) {
	// return 0;
	// }
	//
	// if (isContains(root, root.left) || isContains(root, root.right)) {
	// return 1;
	// }
	// return 0;
	// }
	//
	// private static boolean isContains(Node root, Node s) {
	// if (root == null && s == null)
	// return true;
	// if (root == null || s == null)
	// return false;
	// if (root.data == s.data && isContains(root.left, s.left) &&
	// isContains(root.right, s.right)) {
	// return true;
	// }
	// isContains(root.left, s);
	// isContains(root.right, s);
	// return false;
	// }

	static Map<String, Integer> hm = new HashMap<>();

	static int dupSub(Node root) {

		solve(root);
		System.out.println(hm);
		for (Map.Entry<String, Integer> mp : hm.entrySet()) {
			if(mp.getValue() > 1) return 1;
		}	
		return 0;
	}

	private static String solve(Node root) {
		if (root == null)
			return "$";
		String s = "";
		if (root.left == null && root.right == null) {
			s += root.data;
			return s;
		}
		s = s + root.data;
		s = s + solve(root.left);
		s = s + solve(root.right);
		hm.put(s, hm.containsKey(s) ? hm.get(s) + 1 : 1);
		return s;
	}
}
