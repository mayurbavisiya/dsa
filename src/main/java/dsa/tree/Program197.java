package dsa.tree;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Program197 {

	public static void main(String[] args) {

		Node n = new Node(1);
		n.left = new Node(3);
		n.right = new Node(2);

		// n.left = new Node(12);
		// n.right = new Node(15);
		// n.left.left = new Node(25);
		// n.left.right = new Node(30);
		// n.right.left = new Node(36);

		bToDLL(n);
		System.out.println("asd");
	}

	static Node head;

	// static public void push(int new_data) {
	// Node new_Node = new Node(new_data);
	//
	// /* 3. Make next of new node as head and previous as NULL */
	// new_Node.right = head;
	// new_Node.left = null;
	//
	// /* 4. change prev of head node to new node */
	// if (head != null)
	// head.left = new_Node;
	//
	// /* 5. move the head to point to the new node */
	// head = new_Node;
	// }

	static public void push(int new_data) {
		Node new_Node = new Node(new_data);

		/* 3. Make next of new node as head and previous as NULL */
		new_Node.left = head;
		new_Node.right = null;

		/* 4. cha  nge prev of head node to new node */
		if (head != null) {
			head.right = new_Node;
		}
		/* 5. move the head to point to the new node */
		head = new_Node;
	}

	static void inorder(Node node, List<Integer> ls) {
		if (node != null) {
			inorder(node.left, ls);
			// System.out.print(node.data + " ");
			// push(node.data);
			ls.add(node.data);
			inorder(node.right, ls);
		}
	}

	static Node bToDLL(Node root) {
		List<Integer> ls = new LinkedList<>();
		inorder(root, ls);
		Collections.reverse(ls);
		for (int i : ls) {
			push(i);
		}
		return head;
	}
}
