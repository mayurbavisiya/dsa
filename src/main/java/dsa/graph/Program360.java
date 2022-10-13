package dsa.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Program360 {

	private static void addEdge(ArrayList<ArrayList<Integer>> al, int i, int j) {
		al.get(i).add(j);
		al.get(j).add(i);
	}

	public static void main(String[] args) {

		int v = 5;
		ArrayList<ArrayList<Integer>> adj = new ArrayList<>(v);
		for (int i = 0; i < v; i++) {
			adj.add(new ArrayList<>());
		}

		addEdge(adj, 0, 1);
		addEdge(adj, 1, 2);
		addEdge(adj, 1, 4);
		addEdge(adj, 2, 3);
		addEdge(adj, 3, 4);

		System.out.println(isCycleDFS(adj.size(), adj));
		System.out.println(isCycleBFS(adj.size(), adj));

	}

	private static boolean isCycleDFS(int size, ArrayList<ArrayList<Integer>> adj) {

		boolean visited[] = new boolean[size];
		for (int i = 0; i < visited.length; i++) {
			if (isCycleDFSUtil(visited, i, -1, adj)) {
				return true;
			}
		}
		return false;
	}

	private static boolean isCycleDFSUtil(boolean[] visited, int node, int parent, ArrayList<ArrayList<Integer>> adj) {
		visited[node] = true;
		for (Integer in : adj.get(node)) {
			if (!visited[in]) {
				if (isCycleDFSUtil(visited, in, node, adj)) {
					return true;
				} else if (in != parent) {
					return true;
				}
			}
		}
		return false;
	}

	public static boolean isCycleBFS(int V, ArrayList<ArrayList<Integer>> adj) {
		boolean[] visited = new boolean[V];
		for (int i = 0; i < visited.length; i++) {
			if (!visited[i])
				if (isCycleBFSUtil(visited, adj, i))
					return true;

		}
		return false;
	}

	static class Node {
		int parent;
		int current;

		public Node(int parent, int current) {
			this.parent = parent;
			this.current = current;
		}
	}

	private static boolean isCycleBFSUtil(boolean[] visited, ArrayList<ArrayList<Integer>> adj, int s) {
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(-1, s));
		visited[s] = true;
		while (!q.isEmpty()) {
			int cur = q.peek().current;
			int par = q.peek().parent;
			q.poll();
			for (Integer in : adj.get(cur)) {
				if (!visited[in]) {
					q.add(new Node(cur, in));
					visited[in] = true;
				} else if (par != in) {
					return true;
				}
			}
		}
		return false;
	}

}
