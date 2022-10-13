package dsa.tree;

public class Program198 {

	static boolean isSumTree(Node node) {
		int ls, rs;
		if (node == null || (node.left == null && node.right == null)) {
			return true;
		}
		ls = sum(node.left);
		rs = sum(node.right);
		if (node.data == ls + rs && isSumTree(node.left) && isSumTree(node.right)) {
			return true;
		}
		return false;
	}

	private static int sum(Node node) {
		if (node == null)
			return 0;
		return sum(node.left) + node.data + sum(node.right);
	}

	public static void main(String[] args) {

		// Node n = new Node(10);
		// n.left = new Node(20);
		// n.right = new Node(30);
		// n.left.left = new Node(10);
		// n.left.right = new Node(10);
		Node n = new Node(3);
		n.left = new Node(1);
		n.right = new Node(2);
		// n.left.left = new Node(10);
		// n.left.right = new Node(10);
		System.out.println(isSumTree(n));
	}
}
