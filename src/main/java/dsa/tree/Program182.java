package dsa.tree;

import java.util.Stack;

public class Program182 {

	public static void main(String[] args) {

		Node n = new Node(1);
		n.left = new Node(2);
		n.right = new Node(3);
		inOrder(n);
		inOrderiterative(n);
	}

	// recursive
	private static void inOrder(Node n) {
		if (n != null) {
			inOrder(n.left);
			System.out.print(n.data + " ");
			inOrder(n.right);
		}
	}

	private static void inOrderiterative(Node n) {
		System.out.println();
		if (n == null)
			return;
		Stack<Node> s = new Stack<>();
		while (!s.isEmpty() || n != null) {
			if(n != null){
				s.add(n);
				n = n.left;
			}else{
				n = s.pop();
				System.out.print(n.data + " ");
				n = n.right;
			}
		}

	}
}
