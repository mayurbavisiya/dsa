package dsa.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Program370 {

	public static void main(String[] args) {

		int v = 4;
		List<ArrayList<Integer>> ls = new ArrayList<>();
		for (int i = 0; i < v; i++) {
			ls.add(new ArrayList<>());
		}

		addEdge(ls, 1, 0);
		addEdge(ls, 2, 1);
		addEdge(ls, 3, 2);
		System.out.println(isPossibleBFS(ls, v));
		System.out.println(isPossibleDFS(ls, v));
	}

	private static void addEdge(List<ArrayList<Integer>> ls, int i, int j) {
		ls.get(i).add(j);
	}

	private static boolean isPossibleDFS(List<ArrayList<Integer>> ls, int v) {

		boolean onpath[] = new boolean[v];
		boolean visited[] = new boolean[v];

		for (int i = 0; i < v; i++)
			if (!visited[i] && dfs_cycle(ls, i, onpath, visited))
				return false;

		return true;
	}

	static boolean dfs_cycle(List<ArrayList<Integer>> graph, int node, boolean onpath[], boolean visited[]) {
		if (visited[node])
			return false;
		onpath[node] = visited[node] = true;

		for (int neigh : graph.get(node))
			if (onpath[neigh] || dfs_cycle(graph, neigh, onpath, visited))
				return true;

		return onpath[node] = false;
	}

	private static boolean isPossibleBFS(List<ArrayList<Integer>> ls, int v) {
		boolean[] visited = new boolean[v + 1];
		Queue<Integer> q = new LinkedList<Integer>();
		visited[0] = true;
		q.add(0);
		while (!q.isEmpty()) {
			int cur = q.poll();
			for (int n : ls.get(cur)) {
				if (!visited[n]) {
					q.add(n);
				} else if (visited[n])
					return false;
			}
		}
		return true;
	}
}
