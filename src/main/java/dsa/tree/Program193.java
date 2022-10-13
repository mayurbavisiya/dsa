package dsa.tree;

import java.util.Stack;

public class Program193 {

	public static void main(String[] args) {
		construct("4(2(3)(1))(6(5))");
	}

	static class Node {
		Node left;
		Node right;
		Node parent;
		int data;

		public Node(int data) {
			left = right = parent = null;
			this.data = data;
		}
	}

	static void construct(String s) {
		if (s == null || s.length() < 1) {
			return;
		}
		Node root = new Node(Integer.parseInt("" + s.charAt(0)));
		root.parent = root;
		s = s.substring(1, s.length());
		boolean isLeft = true;
		Stack<Character> st = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				st.add(s.charAt(i));
				isLeft = true;
			}
			if (s.charAt(i) == ')') {
				st.pop();
				isLeft = false;
			}
			
		}
	}
}
