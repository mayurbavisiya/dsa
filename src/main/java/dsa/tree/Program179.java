package dsa.tree;

public class Program179 {
	public static void main(String[] args) {

		Node n = new Node(2);
		n.left = new Node(1);
		n.left.right = new Node(3);
		System.out.println(height(n));

	}

	static int height(Node node) {
		if (node == null)
			return 0;
		else {
			int leftDepth = height(node.left);
			int rightDepth = height(node.right);
			return Math.max(leftDepth, rightDepth) + 1;
		}

	}
}
