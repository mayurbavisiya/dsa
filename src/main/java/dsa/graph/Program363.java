package dsa.graph;

public class Program363 {
	public static void main(String[] args) {
		// int[][] image = { { 0, 0, 0 }, { 0, 0, 0 } };
		// int sr = 0, sc = 0, newColor = 2;

		int[][] image = { { 0, 0, 0 }, { 0, 1, 1 } };
		// 1
		// 1
		// 1
		// int[][] image = {{1,1,1},{1,1,0},{1,0,1}};
		int sr = 1, sc = 1, newColor = 1;
		floodFill(image, sr, sc, newColor);
		System.out.println();
	}

	public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
		if (image[sr][sc] == newColor)
			return image;
		DFS(image, sr, sc, newColor, image[sr][sc]);
		return image;
	}

	private static void DFS(int[][] image, int sr, int sc, int newColor, int curColor) {
		if (sr >= image.length || sc >= image[0].length || sr < 0 || sc < 0) {
			return;
		}
		if (image[sr][sc] != curColor) {
			return;
		}
		image[sr][sc] = newColor;
		DFS(image, sr + 1, sc, newColor, curColor);
		DFS(image, sr, sc + 1, newColor, curColor);
		DFS(image, sr, sc - 1, newColor, curColor);
		DFS(image, sr - 1, sc, newColor, curColor);
	}
}
