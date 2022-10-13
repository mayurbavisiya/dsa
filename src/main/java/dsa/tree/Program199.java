package dsa.tree;

public class Program199 {

	static boolean check(Node root) {
		return checkutil(root, 0, 0);
	}

	private static boolean checkutil(Node root, int level, int mxlevel) {
		boolean left = false, right = true;
		if (root == null)
			return true;
		if (root.left == null && root.right == null && mxlevel == 0) {
			mxlevel = level;
		}
		if (root.left == null && root.right == null) {
			if (level == mxlevel)
				return true;
			return false;

		}
		left = checkutil(root.left, level + 1, mxlevel);
		right = checkutil(root.right, level + 1, mxlevel);
		return left == right;
	}

	public static void main(String[] args) {

		Node n = new Node(1);
		n.left = new Node(2);
		// n.right = new Node(3);
		n.left.left = new Node(5);
		n.left.left = new Node(4);
		// n.left.right = new Node(15);
		// n.left.left.right = new Node(8);
		//
		// n.right.left = new Node(6);
		// n.right.right = new Node(7);
		System.out.println(check(n));
	}
}
