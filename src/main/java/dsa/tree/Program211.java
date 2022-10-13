package dsa.tree;

public class Program211 {

	public static void main(String[] args) {
		Node root1 = new Node(1);
		root1.right = new Node(3);
		root1.right.left = new Node(6);

		root1.left = new Node(2);
		root1.left.left = new Node(4);
		root1.left.right = new Node(5);
		root1.left.right.left = new Node(7);
		root1.left.right.right = new Node(8);

		Node root2 = new Node(1);
		root2.left = new Node(3);
		root2.left.right = new Node(6);

		root2.right = new Node(2);
		root2.right.left = new Node(4);
		root2.right.right = new Node(5);

		root2.right.right.left = new Node(8);
		root2.right.right.right = new Node(7);
		System.out.println(isIsomorphic(root1, root2));
	}

	// Return True if the given trees are isomotphic. Else return False.
	static boolean isIsomorphic(Node root1, Node root2) {
		if ((root1 == null && root2 != null) || (root1 != null && root2 == null)) {
			return false;
		}
		if (root1 == null && root2 == null) {
			return true;
		}
		if (root1.data != root2.data) {
			return false;
		}

		return (isIsomorphic(root1.left, root2.left) && isIsomorphic(root1.right, root2.right))
				|| (isIsomorphic(root1.left, root2.right) && isIsomorphic(root1.right, root2.left));

	}
}
