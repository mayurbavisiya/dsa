package dsa.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Program373 {

	static class Edge {
		int source;
		int dest;
		int weight;

		public Edge(int source, int dest, int weight) {
			this.source = source;
			this.dest = dest;
			this.weight = weight;
		}
	}

	public static void main(String[] args) {
		int nodes = 4;
		ArrayList<Edge> ls = new ArrayList<Edge>();
		addEdge(ls, new Edge(2, 3, 4));
		addEdge(ls, new Edge(0, 3, 5));
		addEdge(ls, new Edge(0, 2, 6));
		addEdge(ls, new Edge(0, 1, 10));
		addEdge(ls, new Edge(1, 3, 15));
		kruskals(ls, nodes);

	}

	private static void kruskals(ArrayList<Edge> ls, int nodes) {
		// Sort the array
		Collections.sort(ls, new Comparator<Edge>() {
			@Override
			public int compare(Edge e1, Edge e2) {
				return e1.weight < e2.weight ? 1 : 0;
			}
		});

		int[] parent = new int[nodes];
		for (int i = 0; i < parent.length; i++) {
			parent[i] = i;
		}

		List<Edge> op = new ArrayList<>();

		int count = 0, index = 0;
		while (count != nodes && index < ls.size()) {
			Edge currEdge = ls.get(index);

			int srcPar = findParent(currEdge.source, parent);
			int destPar = findParent(currEdge.dest, parent);
			if (srcPar != destPar) {
				op.add(currEdge);
				count++;
				parent[srcPar] = destPar;
			}

			index++;
		}

		int minSpanTreeCost = 0;

		for (Edge x : op) {
			minSpanTreeCost += x.weight;
			System.out.println(x.source + " " + x.dest + " " + x.weight);
		}
		System.out.println("MST : " + minSpanTreeCost);
	}

	private static int findParent(int source, int[] parent) {
		if (source == parent[source]) {
			return source;
		}
		return findParent(parent[source], parent);
	}

	private static void addEdge(List<Edge> ls, Edge edge) {
		ls.add(edge);
	}

}
