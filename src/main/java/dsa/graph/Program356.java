package dsa.graph;

import java.util.ArrayList;

public class Program356 {

	public static void main(String[] args) {

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

	private static void addEdge(ArrayList<ArrayList<Integer>> al, int i, int j) {
		al.get(i).add(j);
		al.get(j).add(i);
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
		mat[i][j] = 1;
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

}
