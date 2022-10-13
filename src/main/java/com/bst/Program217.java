package com.bst;

public class Program217 {

	static class Node {
		Node left;
		Node right;
		int data;

		Node(int data) {
			this.data = data;
			left = right = null;
		}
	}

	public static void main(String[] args) {
		Node root = new Node(20);
		root.right = new Node(22);

		root.left = new Node(8);
		root.left.left = new Node(4);
		root.left.right = new Node(12);
		root.left.right.left = new Node(10);
		root.left.right.right = new Node(14);

		System.out.println(inorderSuccessor(root, new Node(8)).data);

		System.out.println(inorderPredecssor(root, new Node(10)).data);
	}

	public static Node inorderSuccessor(Node root, Node x) {
		Node successor = null;
		while (root != null) {
			if (x.data >= root.data) {
				root = root.right;
			} else {
				successor = root;
				root = root.left;
			}
		}
		return successor;
	}

	public static Node inorderPredecssor(Node root, Node x) {
		Node predecessor = null;
		while (root != null) {
			if (root.data >= x.data) {
				root = root.left;
			} else {
				predecessor = root;
				root = root.right;
			}
		}
		return predecessor;
	}

}
