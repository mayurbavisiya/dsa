package com.bst;

public class Program215 {

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

		public static Node deleteNode(Node root, int key) {
			if (root == null) {
				return root;
			}
			if (root.left == null && root.right == null) {
				if (root.data == key)
					return null;
			}
			if (root.data < key)
				root.right = deleteNode(root.right, key);
			else if (root.data > key)
				root.left = deleteNode(root.left, key);
			else {
				Node inP = inPre(root.left);
				Node sucP = inSuc(root.right);
				root.data = inP == null ? sucP.data : inP.data;
				if (inP != null)
					root.left = deleteNode(root.left, key);
				else
					root.right = deleteNode(root.right, key);
	
			}
			return root;
		}

	public static Node inPre(Node root) {
		while (root != null && root.right != null) {
			root = root.right;
		}
		return root;
	}

	public static Node inSuc(Node root) {
		while (root != null && root.left != null) {
			root = root.left;
		}
		return root;
	}

}
