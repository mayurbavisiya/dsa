package dsa.graph;

import java.util.ArrayList;
import java.util.Iterator;

public class Program358 {

	public static void main(String[] args) {

		ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			adj.add(new ArrayList<>());
		}
		addEdge(0, 1, adj);
		addEdge(0, 2, adj);
		addEdge(0, 3, adj);
		addEdge(2, 4, adj);
		System.out.println(adj);
		DFS(adj.size(), adj);

	}

	private static void DFS(int size, ArrayList<ArrayList<Integer>> adj) {
		boolean[] visited = new boolean[adj.size()];
		int s = 0;
		DFSUtil(s, visited, adj);
	}

	private static void DFSUtil(int s, boolean[] visited, ArrayList<ArrayList<Integer>> adj) {
		visited[s] = true;
		System.out.print(s + " -> ");
		Iterator<Integer> it = adj.get(s).iterator();
		while (it.hasNext()) {
			int n = it.next();
			if (!visited[n]) {
				DFSUtil(n, visited, adj);
			}
		}
	}

	private static void addEdge(int i, int j, ArrayList<ArrayList<Integer>> adj) {
		adj.get(i).add(j);
	}
}
