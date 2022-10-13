package dsa.tree;

public class Program208 {

	public static void main(String[] args) {

		Node n = new Node(1);
		n.left = new Node(2);
		n.right = new Node(3);
		n.left.left = new Node(4);
		n.right.right = new Node(5);
		System.out.println(dist(n, 4, 5));
	}

	static int dist(Node root, int n1, int n2) {
		if (n1 == n2) {
			return 0;
		}
		Node anc = lca(root, n1, n2);
		int len = getLength(anc, n1, 0);
		int len1 = getLength(anc, n2, 0);

		return len + len1;
	}

	private static int getLength(Node anc, int n2, int level) {
		if (anc == null)
			return 0;
		if (anc.data == n2) {
			return level;
		}
		int left = getLength(anc.left, n2, level + 1);
		int right = getLength(anc.right, n2, level + 1);
		return Math.max(left, right);
	}

	static Node lca(Node root, int n1, int n2) {
		if (root == null)
			return null;
		if (root.data == n1 || root.data == n2)
			return root;
		Node left = lca(root.left, n1, n2);
		Node right = lca(root.right, n1, n2);
		if (left != null && right != null) {
			return root;
		} else
			return (left != null) ? left : right;
	}
}
