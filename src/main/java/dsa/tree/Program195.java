package dsa.tree;

public class Program195 {

	public static void main(String[] args) {

		Node n = new Node(10);
		n.left = new Node(-2);
		n.right = new Node(6);

		n.left.left = new Node(8);
		n.left.right = new Node(-4);

		n.right.left = new Node(7);
		n.right.right = new Node(5);
		// System.out.println(topView(n));

		toSumTree(n);
	}

	private static void toSumTree(Node n) {
		toSumTreeUtil(n);
	}

	private static int toSumTreeUtil(Node n) {
		if (n == null)
			return 0;
		int temp = n.data;
		n.data = toSumTreeUtil(n.left) + toSumTreeUtil(n.right);
		return n.data + temp;

	}

}
