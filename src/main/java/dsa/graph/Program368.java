package dsa.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Program368 {

	public static void main(String[] args) {
		int v = 4;
		ArrayList<ArrayList<Integer>> adj = new ArrayList<>(v);
		for (int i = 0; i < v; i++) {
			adj.add(new ArrayList<>());
		}

		addEdge(adj, 1, 0);
		addEdge(adj, 2, 0);
		addEdge(adj, 3, 0);
		System.out.println(Arrays.toString(topoSort(v, adj)));
	}

	private static void addEdge(ArrayList<ArrayList<Integer>> al, int i, int j) {
		al.get(i).add(j);
	}

	// 1) First create the indegree aray by looping through the adjancey list
	// 2) Add all nodes who has indegree 0 in queue
	// 3) Perform BFS
	static int[] topoSort(int v, ArrayList<ArrayList<Integer>> adj) {
		int[] toposort = new int[v];
		int[] indegree = new int[v];

		// Step 1
		for (int i = 0; i < adj.size(); i++) {
			for (int j = 0; j < adj.get(i).size(); j++) {
				indegree[adj.get(i).get(j)]++;
			}
		}

		// Step 2
		Queue<Integer> q = new LinkedList<Integer>();
		for (int i = 0; i < indegree.length; i++) {
			if (indegree[i] == 0)
				q.add(i);
		}

		// Step 3
		int index = 0;
		while (!q.isEmpty()) {
			int n = q.poll();
			toposort[index++] = n;
			for (Integer i : adj.get(n)) {
				indegree[i]--;
				if (indegree[i] == 0) {
					q.add(i);
				}
			}
		}
		return toposort;
	}
}
