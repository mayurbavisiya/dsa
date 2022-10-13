package dsa.tree;

public class Program202 {

	public static void main(String[] args) {

		Node n = new Node(1);
		n.left = new Node(2);
		n.right = new Node(3);
		n.left.left = new Node(4);
		n.left.right = new Node(5);
		n.left.left.right = new Node(8);

		n.right.left = new Node(6);
		n.right.right = new Node(7);
		System.out.println(sumOfLongRootToLeafPath(n));

	}

	static int maxLen;
	static int maxSum;

	public static int sumOfLongRootToLeafPath(Node root) {
		// if tree is NULL, then sum is 0
		if (root == null)
			return 0;

		maxSum = Integer.MIN_VALUE;
		maxLen = 0;

		// finding the maximum sum 'maxSum' for the
		// maximum length root to leaf path
		sumOfLongRootToLeafPathUtil(root, 0, 0);

		// required maximum sum
		return maxSum;
	}

	private static void sumOfLongRootToLeafPathUtil(Node root, int sum, int len) {
		// if true, then we have traversed a
		// root to leaf path
		if (root == null) {
			// update maximum length and maximum sum
			// according to the given conditions
			if (maxLen < len) {
				maxLen = len;
				maxSum = sum;
			} else if (maxLen == len && maxSum < sum)
				maxSum = sum;
			return;
		}

		// recur for left subtree
		sumOfLongRootToLeafPathUtil(root.left, sum + root.data, len + 1);

		sumOfLongRootToLeafPathUtil(root.right, sum + root.data, len + 1);

	}

}
