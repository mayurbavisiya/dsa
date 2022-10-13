package dsa.tree;

public class Program207 {

	public static void main(String[] args) {

		Node n = new Node(1);
		n.left = new Node(2);
		n.right = new Node(3);
		n.left.left = new Node(4);
		n.right.right = new Node(5);
		System.out.println(lca(n, 4, 5).data);

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
