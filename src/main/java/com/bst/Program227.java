package com.bst;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.swing.text.html.HTMLDocument.HTMLReader.IsindexAction;

public class Program227 {

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

		Node root1 = new Node(10);

		root1.right = new Node(15);
		root1.right.left = new Node(11);
		root1.right.right = new Node(18);

		root1.left = new Node(6);
		root1.left.left = new Node(3);
		root1.left.right = new Node(8);
		System.out.println(countPairs(root, root1, 16));
	}

	// Naive Solution
	public static int countPairs(Node root1, Node root2, int x) {
		Set<Integer> hs1 = new HashSet<>(), hs2 = new HashSet<>();
		inorder(hs1, root1);
		inorder(hs2, root2);
		int res = 0;
		Iterator<Integer> in = hs1.iterator();
		while (in.hasNext()) {
			int n = in.next();
			if (hs2.contains(x - n)) {
				res++;
				// hs2.remove(x - n);
				// hs1.remove(n);
			}
		}
		return res;
	}

	
	// Second logic is Inorder traversal of one tree and search root.data - x in second tree, So TC would be O(n+h(m))
	
	static int res = 0;

	private static void inorder(Set<Integer> hs1, Node root) {
		if (root != null) {
			inorder(hs1, root.left);
			// hs1.add(root.data);
			if (isExist(root, 0))
				inorder(hs1, root.right);
		}
	}

	private static boolean isExist(Node root, int x) {
		if (root == null) {
			return false;
		}
		if (root.data == x)
			return true;
		boolean a = false, b = false;
		if (x > root.data) {
			a = isExist(root.right, x);
		}
		if (x < root.data) {
			b = isExist(root.left, x);
		}
		return a || b;
	}

}
