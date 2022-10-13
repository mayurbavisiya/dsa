package com.bst;

public class Program216 {

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

	static int minValue(Node node) {
		if (node == null)
			return -1;
		while (node != null && node.left != null) {
			node = node.left;
		}
		return node.data;
	}

}
