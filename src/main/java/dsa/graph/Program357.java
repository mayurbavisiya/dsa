package dsa.graph;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Program357 {

	// static int v; // No. of vertices
	// static ArrayList<Integer> adj[];

	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			adj.add(new ArrayList<>());
		}
		addEdge(0, 1, adj);
		addEdge(0, 2, adj);
		addEdge(0, 3, adj);
		addEdge(2, 4, adj);
		System.out.println(bfsOfGraph(adj.size(), adj));
		System.out.println(dfsOfGraph(adj.size(), adj));

	}

	private static ArrayList<Integer> dfsOfGraph(int size, ArrayList<ArrayList<Integer>> adj) {
		ArrayList<Integer> op = new ArrayList<Integer>();
		boolean[] visited = new boolean[adj.size()];
		DFS(visited, 0, adj, op);
		return op;
	}

	private static void DFS(boolean[] visited, int s, ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> op) {
		op.add(s);
		visited[s] = true;

		Iterator<Integer> it = adj.get(s).iterator();
		while (it.hasNext()) {
			int n = it.next();
			if (!visited[n]) {
				DFS(visited, n, adj, op);
			}
		}

	}

	static public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
		ArrayList<Integer> op = new ArrayList<Integer>();
		BFS(op, adj);
		return op;
	}

	private static void BFS(ArrayList<Integer> op, ArrayList<ArrayList<Integer>> adj) {

		int i = 0;
		int v = adj.size();
		boolean visited[] = new boolean[v];
		Queue<Integer> q = new LinkedList<>();
		q.add(i);
		visited[i] = true;
		while (!q.isEmpty()) {
			int a = q.poll();
			op.add(a);
			Iterator<Integer> it = adj.get(a).iterator();
			while (it.hasNext()) {
				int n = it.next();
				if (!visited[n]) {
					visited[n] = true;
					q.add(n);
				}
			}
		}

	}

	private static void addEdge(int i, int j, ArrayList<ArrayList<Integer>> adj) {
		adj.get(i).add(j);
	}
}
