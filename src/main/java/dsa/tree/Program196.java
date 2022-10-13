package dsa.tree;

import java.util.HashMap;

public class Program196 {

	public static void main(String[] args) {

		// Node n = new Node(0);
		// n.left = new Node(1);
		// n.right = new Node(3);
		// n.left.left = new Node(4);
		// n.left.right = new Node(5);
		// n.left.left.right = new Node(8);
		//
		// n.right.left = new Node(6);
		// n.right.right = new Node(7);
		int[] inorder = { 3, 1, 4, 0, 5, 2 }, preorder = { 0, 1, 3, 4, 2, 5 };
		// Node n = buildTree(inorder, preorder, preorder.length);
		// postOreder(n);

	}

	static HashMap<Integer, Integer> hm = new HashMap<>();
	static int preIndex = 0;

	public static Node buildTreeUtil(int[] in, int[] pre, int inStrt, int inEnd) {

		if (inStrt > inEnd) {
			return null;
		}

		/*
		 * Pick current node from Preorder traversal using preIndex and
		 * increment preIndex
		 */
		int curr = pre[preIndex++];
		Node tNode;
		tNode = new Node(curr);

		/* If this node has no children then return */
		if (inStrt == inEnd) {
			return tNode;
		}

		/* Else find the index of this node in Inorder traversal */
		int inIndex = hm.get(curr);

		/*
		 * Using index in Inorder traversal, construct left and right subtress
		 */
		tNode.left = buildTreeUtil(in, pre, inStrt, inIndex - 1);
		tNode.right = buildTreeUtil(in, pre, inIndex + 1, inEnd);
		return tNode;
	}

	// This function mainly creates an unordered_map, then
	// calls buildTree()
	public static Node buldTreeWrap(int[] in, int[] pre, int len) {
		for (int i = 0; i < len; i++) {
			hm.put(in[i], i);
		}
		return buildTreeUtil(in, pre, 0, len - 1);
	}

	private static void postOreder(Node buildTree) {
		if (buildTree != null) {
			postOreder(buildTree.left);
			postOreder(buildTree.right);
			System.out.print(buildTree.data + " ");
		}
	}

	// public static Node buildTree(int inorder[], int preorder[], int n) {
	// if (preorder == null || preorder.length < 1)
	// return null;
	// Node root = new Node(preorder[0]);
	//
	// int rootIndex = findIndex(preorder[0], inorder);
	// int prevIndex = rootIndex;
	// for (int i = 1; i < preorder.length; i++) {
	// int curNodeIndex = findIndex(preorder[i], inorder);
	// if (curNodeIndex < rootIndex) {
	// boolean isCurrNull = false;
	// Node curr = root.left;
	// if (curr == null) {
	// isCurrNull = true;
	// curr = root;
	// }
	// if (curNodeIndex < prevIndex) {
	// while (curr.left != null) {
	// curr = curr.left;
	// }
	// curr.left = new Node(preorder[i]);
	// } else {
	// while (curr.right != null) {
	// curr = curr.right;
	// }
	// curr.right = new Node(preorder[i]);
	// }
	// if (isCurrNull)
	// root = curr;
	// else
	// root.left = curr;
	// } else {
	// boolean isCurrNull = false;
	// Node curr = root.right;
	// if (curr == null) {
	// isCurrNull = true;
	// curr = root;
	// }
	// if (curNodeIndex < prevIndex) {
	// while (curr.left != null) {
	// curr = curr.left;
	// }
	// curr.left = new Node(preorder[i]);
	// } else {
	// while (curr.right != null) {
	// curr = curr.right;
	// }
	// curr.right = new Node(preorder[i]);
	// }
	// if (isCurrNull)
	// root = curr;
	// else
	// root.right = curr;
	// }
	// prevIndex = curNodeIndex;
	// }
	// return root;
	// }

	private static int findIndex(int i, int[] inorder) {
		for (int j = 0; j < inorder.length; j++) {
			if (i == inorder[j])
				return j;
		}
		return -1;
	}
}
