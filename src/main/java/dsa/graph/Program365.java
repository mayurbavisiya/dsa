package dsa.graph;

import java.util.ArrayList;

public class Program365 {
	public static void main(String[] args) {
		int n = 4;
		int[][] connections = { { 0, 1 }, { 0, 2 }, { 1, 2 } };
		System.out.println(makeConnected(n, connections));

	}

	public static int makeConnected(int n, int[][] connections) {

		if (connections.length < n - 1)
			return -1;

		ArrayList<ArrayList<Integer>> adj = new ArrayList<>(n);
		for (int i = 0; i < n; i++) {
			adj.add(new ArrayList<>());
		}

		for (int i = 0; i < connections.length; i++) {
			adj.get(connections[i][0]).add(connections[i][1]);
			adj.get(connections[i][1]).add(connections[i][0]);
		}

		int c = 0;
		boolean[] visited = new boolean[n + 1];
		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				c++;
				DFS(i, visited, adj);
			}
		}
		return c - 1;
	}

	private static void DFS(int i, boolean[] visited, ArrayList<ArrayList<Integer>> adj) {
		visited[i] = true;
		for (int in : adj.get(i)) {
			if (!visited[in])
				DFS(in, visited, adj);
		}
	}

}
