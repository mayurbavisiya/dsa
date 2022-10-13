package com.bst;

public class Program214 {

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

	}

	boolean isBST(Node node) {
		if (node == null) {
			return true;
		}
		if (node.left != null && node.left.data >= node.data)
			return false;
		if (node.right != null && node.right.data <= node.data)
			return false;
		if(!isBST(node.left) || !isBST(node.right))
			return false;
		return true;
	}
}
