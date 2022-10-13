package com.bst;

public class Program228 {

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
		Node root = new Node(5);
		root.right = new Node(7);
		root.right.left = new Node(6);
		root.right.right = new Node(8);

		root.left = new Node(3);
		root.left.left = new Node(2);
		root.left.right = new Node(4);
		System.out.println(findMedian(root));

	}

	// 1) Naive approach is perform inorder traversal on tree and store into
	// arraylist and get the median
	// TC would be O(n) and SC = O(n)

	// 2) Count number of nodes , And perform inorder till u reach the count
	// Trcik is to maintain the prev node , in the case of even number of node
	// get the sum of prev node data + current node data /2
	public static float findMedian(Node root) {
		float[] temp = new float[1], res = new float[1];
		inorder(root, temp);
		float count = (float) Math.floor(temp[0] / 2);
		temp[0] = 0;
		Node prev = null;
		util(temp, root, count, res, prev);
		return res[0];
	}

	private static void util(float[] temp, Node root, float count, float[] res, Node prev) {
		if (root == null)
			return;
		util(temp, root.left, count, res, prev);
		if (prev == null) {
			prev = root;
			temp[0] = temp[0] + 1;
		} else if (count == temp[0]) {
			temp[0] = temp[0] + 1;
			res[0] = root.data;
			return;
		} else {
			temp[0] = temp[0] + 1;
			prev = root;
		}
		util(temp, root.right, count, res, prev);
	}

	private static void inorder(Node root, float[] countNode) {
		if (root != null) {
			inorder(root.left, countNode);
			countNode[0] = countNode[0] + 1;
			inorder(root.right, countNode);
		}
	}
}
