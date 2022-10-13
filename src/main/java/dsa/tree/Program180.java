package dsa.tree;

public class Program180 {

	public static void main(String[] args) {

	}
	int diameter(Node root) {
		diameterUtil(root);
		return max;
	}
	int max = 0;
	int diameterUtil(Node root) {
		if(root == null)
			return 0;
		int left  = diameterUtil(root.left);
		int right  = diameterUtil(root.left);
		max = Math.max(max, left + right);
		return 1 + Math.max(left, right);
	}
}
