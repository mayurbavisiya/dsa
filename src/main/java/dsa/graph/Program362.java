package dsa.graph;

public class Program362 {

	public static void main(String[] args) {
		int[] KnightPos = { 6, 1 }, TargetPos = { 2, 4 };
		int N = 7;
		System.out.println(minStepToReachTarget(KnightPos, TargetPos, N));
	}

	public static int minStepToReachTarget(int KnightPos[], int TargetPos[], int N) {

		int x[] = { -2, -1, 1, 2, -2, -1, 1, 2 };
		int y[] = { -1, -2, -2, -1, 1, 2, 2, 1 };
		boolean[][] visited = new boolean[N + 1][N + 1];

		int[] steps = { Integer.MAX_VALUE };
		DFS(KnightPos[0], KnightPos[1], TargetPos[0], TargetPos[1], x, y, N, 0, steps, visited);
		return (steps[0] == Integer.MAX_VALUE) ? -1 : steps[0];
	}

	private static void DFS(int i, int j, int targetx, int targety, int[] x, int[] y, int n, int step, int[] globalStep,
			boolean[][] visited) {
		if (i > n || i < 0 || j > n || j < 0) {
			return;
		}

		if (visited[i][j]){
			step = step - 1;
			return;
		}
		visited[i][j] = true;
		if (i == targetx && j == targety) {
			globalStep[0] = Math.min(step, globalStep[0]);
		}
		for (int k = 0; k < y.length; k++) {
			DFS(i + x[k], j + y[k], targetx, targety, x, y, n, step + 1, globalStep, visited);
		}

		// visited[i][j] = false;

	}

}
