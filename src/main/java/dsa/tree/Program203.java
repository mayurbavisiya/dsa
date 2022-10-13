	package dsa.tree;

import java.util.ArrayList;
import java.util.Iterator;

public class Program203 {

	// there is 4 way to represent a graph
	// 1) Adjacency matrix
	// 2) Adjacency list
	// 3) Incidence Matrix
	// 4) Incidence List

	public static void main1(String[] args) {

		int v = 5;
		ArrayList<ArrayList<Integer>> adj = new ArrayList<>(v);
		for (int i = 0; i < v; i++) {
			adj.add(new ArrayList<>());
		}

		addEdge(adj, 0, 4);
		addEdge(adj, 1, 2);
		addEdge(adj, 1, 3);
		addEdge(adj, 1, 4);
		addEdge(adj, 2, 3);
		addEdge(adj, 3, 4);
		printGraph(adj);

		// Matrix representation

		int[][] mat = new int[v][v];
		addEdge1(mat, 0, 4);
		addEdge1(mat, 1, 2);
		addEdge1(mat, 1, 3);
		addEdge1(mat, 1, 4);
		addEdge1(mat, 2, 3);
		addEdge1(mat, 3, 4);
		printGraph1(mat);

	}

	private static void printGraph1(int[][] mat) {
		System.out.println("----------------------------------------------");
		boolean flag = true;
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat.length; j++) {
				if (mat[i][j] == 1 || mat[j][i] == 1) {
					if (flag)
						System.out.print("Node : " + i);
					flag = false;
					System.out.print(" -> " + j);
				}
			}
			flag = true;
			System.out.println();
		}
	}

	private static void addEdge1(int[][] mat, int i, int j) {
		for (int j2 = 0; j2 < mat.length; j2++) {
			for (int k = 0; k < mat.length; k++) {
				if (j2 == i && k == j) {
					mat[i][j] = 1;
				}
			}
		}
	}

	private static void printGraph(ArrayList<ArrayList<Integer>> adj) {
		for (int i = 0; i < adj.size(); i++) {
			System.out.print("Node : " + i);
			for (int j = 0; j < adj.get(i).size(); j++) {
				System.out.print("-> " + adj.get(i).get(j));
			}
			System.out.println();
		}
	}

	private static void addEdge(ArrayList<ArrayList<Integer>> al, int i, int j) {
		al.get(i).add(j);
		al.get(j).add(i);
	}

	public static void main(String[] args) {
		int v = 5;
		ArrayList<ArrayList<Integer>> al = new ArrayList<>(v);
		for (int i = 0; i < v; i++) {
			al.add(new ArrayList<>());
		}
		addEdge(al, 1, 0);
		addEdge(al, 0, 2);
//		addEdge(al, 2, 1);
//		addEdge(al, 0, 3);
//		addEdge(al, 3, 4);
		if (isTree(al, v)) {
			System.out.println("yes ! Its tree");
		} else {
			System.out.println("No ! Its not tree");
		}
	}

	private static boolean isTree(ArrayList<ArrayList<Integer>> al, int v) {
		boolean[] visited = new boolean[v];
		if (isCyclic(0, visited, -1, al)) {
			return false;
		}

		for (int i = 0; i < visited.length; i++) {
			if (!visited[i])
				return false;
		}
		return true;
	}

	private static boolean isCyclic(int v, boolean[] visited, int parent, ArrayList<ArrayList<Integer>> al) {
		visited[v] = true;
		Integer i;

		Iterator<Integer> it = al.get(v).iterator();
		while (it.hasNext()) {
			i = it.next();
			if (!visited[i]) {
				if (isCyclic(i, visited, v, al))
					return true;
			} else if (i != parent)
				return true;
		}

		return false;
	}

}
