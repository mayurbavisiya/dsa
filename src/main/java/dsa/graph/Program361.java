package dsa.graph;

import java.util.ArrayList;

public class Program361 {

	public static void main(String[] args) {
		int[][] m = { { 1, 0, 0, 0 }, { 1, 1, 0, 1 }, { 1, 1, 0, 0 }, { 0, 1, 1, 1 } };
		System.out.println(findPath(m, m.length));
	}

	public static ArrayList<String> findPath(int[][] m, int n) {
		ArrayList<String> op = new ArrayList<>();
		if (m[0][0] == 0) {
			return op;
		}
		if (m[m.length - 1][m[0].length - 1] == 0) {
			return op;
		}
		boolean[][] visited = new boolean[m.length][m[0].length];
		DFS(m, op, 0, 0, "", visited);
		return op;
	}

	private static void DFS(int[][] m, ArrayList<String> op, int i, int j, String string, boolean[][] visited) {
		if (i >= m.length || i < 0 || j >= m[0].length || j < 0) {
			return;
		}
		if (visited[i][j])
			return;
		if (m[i][j] == 0)
			return;
		if (i == m.length - 1 && j == m[0].length - 1) {
			op.add(string);
			string = "";
			return;
		}
		visited[i][j] = true;
		DFS(m, op, i + 1, j, string + "D", visited);
		DFS(m, op, i, j - 1, string + "L", visited);
		DFS(m, op, i - 1, j, string + "U", visited);
		DFS(m, op, i, j + 1, string + "R", visited);
		visited[i][j] = false;
	}
}
