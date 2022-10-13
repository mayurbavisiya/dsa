package com.bst;

public class Program220 {

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

	}

	Node LCA(Node root, int n1, int n2) {
		if (root == null)
			return null;
		if (root.data > n1 && root.data > n2) {
			return LCA(root.left, n1, n2);
		}
		if (root.data < n1 && root.data < n2) {
			return LCA(root.right, n1, n2);
		}
		return root;
	}

}
