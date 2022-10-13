package dsa.tree;

public class Program190 {

	public static void main(String[] args) {

		Node n = new Node(1);

		n.left = new Node(2);
		n.right = new Node(39);

		n.left.right = new Node(3);
		// n.left.right = new Node(5);
		// n.left.left.right = new Node(8);
		//
		// n.right.left = new Node(6);
		// n.right.right = new Node(7);
		System.out.println(isBalanced(n));

	}
	
		
		static boolean isBalanced(Node root) {
			if(root == null)
				return true;
			int lh = height(root.left);
			int rh = height(root.right);
			if(Math.abs(lh - rh) > 1)
				return false;
			boolean lr = isBalanced(root.left);
			boolean rr = isBalanced(root.right);
			return (lr && rr);
		}
	
		
		private static int height(Node root) {
			if (root == null)
				return 0;
			else {
				int leftheight = height(root.left);
				int rightHight = height(root.right);
				return 1 + Math.max(leftheight, rightHight);
			}
		}

}
