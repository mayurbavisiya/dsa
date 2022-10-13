package com.bst;

public class Program219 {

	static class Node {
		Node left;
		Node right;
		Node next;
		int data;

		Node(int data) {
			this.data = data;
			left = right = next = null;
		}
	}

	public static void main(String[] args) {
		Node root = new Node(10);
		root.right = new Node(12);

		root.left = new Node(8);
		root.left.left = new Node(3);
		// root.left.right = new Node(12);
		// root.left.right.left = new Node(10);
		// root.left.right.right = new Node(14);

		populateNext(root);

		// System.out.println(inorderPredecssor(root, new Node(10)).data);
	}

	static Node next = null;

	public static void populateNext(Node node) {
		// The first visited node will be the rightmost node
		// next of the rightmost node will be NULL
		if (node != null) {
			// First set the next pointer in right subtree
			populateNext(node.right);

			// Set the next as previously visited node in reverse Inorder
			node.next = next;

			// Change the prev for subsequent node
			next = node;

			// Finally, set the next pointer in left subtree
			populateNext(node.left);
		}
	}

}
