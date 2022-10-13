package dsa.tree;

public class Program204 {

	public static void main(String[] args) {

		Node n = new Node(1);
		n.left = new Node(-2);
		n.right = new Node(3);

		n.left.left = new Node(4);
		n.left.right = new Node(5);

		n.right.left = new Node(-6);
		n.right.right = new Node(2);
		largestSubSumTree(n);

	}

	static int res = Integer.MIN_VALUE;

	public static void largestSubSumTree(Node root) {
		largestSubSumTreeUtil(root);
		System.out.println(res);
	}

	private static int largestSubSumTreeUtil(Node root) {
		if (root == null) {
			return 0;
		}

		int sum = root.data + largestSubSumTreeUtil(root.left) + largestSubSumTreeUtil(root.right);

		res = Math.max(sum, res);
		return sum;
	}
}
