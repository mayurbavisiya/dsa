package dsa.graph;

public class Program371 {

	public static void main(String[] args) {
		char[][] grid = { { '0', '1' }, { '1', '0' }, { '1', '1' }, { '1', '0' } };
		System.out.println(numIslands(grid));
	}

	public static int numIslands(char[][] grid) {
		boolean[][] visited = new boolean[grid.length + 1][grid[0].length + 1];
		int islands = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] == '1' && !visited[i][j]) {
					islands++;
					DFS(i, j, visited, grid);
				}
			}
		}
		return islands;
	}

	private static void DFS(int i, int j, boolean[][] visited, char[][] grid) {
		if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] != '1' || visited[i][j])
			return;
		visited[i][j] = true;
		DFS(i + 1, j, visited, grid);
		DFS(i - 1, j, visited, grid);
		DFS(i, j + 1, visited, grid);
		DFS(i, j - 1, visited, grid);
		DFS(i + 1, j + 1, visited, grid);
		DFS(i - 1, j - 1, visited, grid);
		DFS(i - 1, j + 1, visited, grid);
		DFS(i + 1, j - 1, visited, grid);
	}
}
