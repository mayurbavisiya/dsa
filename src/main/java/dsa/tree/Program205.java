package dsa.tree;

public class Program205 {

	public static void main(String[] args) {

		Node n = new Node(1);
		n.left = new Node(2);
		n.right = new Node(3);

		n.left.left = new Node(4);
		n.left.left.right = new Node(5);
		n.left.left.right.left = new Node(6);

		n.right.right = new Node(9);
		n.right.right.right = new Node(12);
		n.right.right.left = new Node(10);
		n.right.right.left.right = new Node(11);

		largestSumNode(n);
	}

	static int res = Integer.MIN_VALUE;

	public static void largestSumNode(Node root) {
		largestSumNodeTreeUtil(root);
		System.out.println(res);
	}

	private static int largestSumNodeTreeUtil(Node root) {
		if (root == null)
			return 0;

		int sum1 = 0;
		sum1 += root.data;
		if (root.left != null && root.left.left != null) {
			sum1 += largestSumNodeTreeUtil(root.left.left);
			sum1 += largestSumNodeTreeUtil(root.left.right);
		}
		if (root.right != null && root.right.right != null) {
			sum1 += largestSumNodeTreeUtil(root.right.left);
			sum1 += largestSumNodeTreeUtil(root.right.right);
		}
		int sum2 = largestSumNodeTreeUtil(root.left) + largestSumNodeTreeUtil(root.right);
		int curMax = Math.max(sum1, sum2);
		res = Math.max(curMax, res);
		return curMax;
	}

}
