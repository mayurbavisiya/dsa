package dsa.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Program359 {

	public static void main(String[] args) {
		int v = 5;
		ArrayList<ArrayList<Integer>> adj = new ArrayList<>(v);
		for (int i = 0; i < v; i++) {
			adj.add(new ArrayList<>());
		}

		addEdge(adj, 0, 1);
		addEdge(adj, 0, 2);
		addEdge(adj, 1, 2);
		addEdge(adj, 2, 0);
		addEdge(adj, 2, 3);
		// addEdge(adj, 3, 3);

		System.out.println(isCycleDFS(adj));
		System.out.println(isCycleBFS(adj));
	}

	private static void addEdge(ArrayList<ArrayList<Integer>> al, int i, int j) {
		al.get(i).add(j);
	}

	private static boolean isCycleBFS(ArrayList<ArrayList<Integer>> adj) {
		int[] indegree = new int[adj.size()];
		for (int i = 0; i < adj.size(); i++) {
			for (int j = 0; j < adj.get(i).size(); j++) {
				indegree[adj.get(i).get(j)]++;
			}
		}
		Queue<Integer> q = new LinkedList<>();
		for (int i = 0; i < indegree.length; i++) {
			if (indegree[i] == 0) {
				q.add(i);
			}
		}

		int count = 0;
		while (!q.isEmpty()) {
			int n = q.poll();
			count++;
			for (Integer i : adj.get(n)) {
				indegree[i]--;
				if (indegree[i] == 0)
					q.add(i);
			}
		}
		if (count == adj.size())
			return false;
		return true;
	}

	private static boolean isCycleDFS(ArrayList<ArrayList<Integer>> adj) {
		boolean[] visited = new boolean[adj.size()];
		boolean[] dfsvisited = new boolean[adj.size()];
		for (int i = 0; i < adj.size(); i++) {
			if (isCycleDFS(visited, dfsvisited, i, adj))
				return true;
		}

		return false;
	}

	private static boolean isCycleDFS(boolean[] visited, boolean[] dfsvisited, int i,
			ArrayList<ArrayList<Integer>> adj) {
		if (dfsvisited[i])
			return true;
		if (visited[i])
			return false;

		visited[i] = true;
		dfsvisited[i] = true;
		ArrayList<Integer> al = adj.get(i);
		for (int j = 0; j < al.size(); j++) {
			if (isCycleDFS(visited, dfsvisited, al.get(j), adj)) {
				return true;
			}
		}
		dfsvisited[i] = false;
		return false;
	}

}
