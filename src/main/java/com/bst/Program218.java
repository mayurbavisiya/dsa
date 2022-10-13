package com.bst;

public class Program218 {

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

		System.out.println(isBST(root));

		// System.out.println(inorderPredecssor(root, new Node(10)).data);
	}

	static boolean isBST(Node node) {
		if (node == null)
			return true;
		if (node.left != null && node.data < node.left.data) {
			return false;
		}
		if (node.right != null && node.data > node.right.data) {
			return false;
		}
		boolean isLeft = isBST(node.left);
		boolean isRight = isBST(node.right);
		return (isLeft && isRight);
	}

}
