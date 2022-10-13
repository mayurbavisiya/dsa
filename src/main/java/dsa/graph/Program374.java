package dsa.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Program374 {

	static class Node {
		int v;
		int weight;

		Node(int v, int w) {
			this.v = v;
			this.weight = w;

		}

	}

	public static void main(String[] args) {

		int n = 5;
		ArrayList<ArrayList<Node>> adj = new ArrayList<ArrayList<Node>>();
		for (int i = 0; i < n; i++)
			adj.add(new ArrayList<Node>());

		adj.get(0).add(new Node(1, 4));
		adj.get(1).add(new Node(0, 4));

		adj.get(1).add(new Node(2, 2));
		adj.get(2).add(new Node(1, 2));

		adj.get(0).add(new Node(2, 8));
		adj.get(2).add(new Node(0, 8));

		adj.get(1).add(new Node(3, 6));
		adj.get(3).add(new Node(1, 6));

		adj.get(2).add(new Node(3, 3));
		adj.get(3).add(new Node(2, 3));

		adj.get(3).add(new Node(4, 5));
		adj.get(4).add(new Node(3, 5));

		adj.get(2).add(new Node(4, 9));
		adj.get(4).add(new Node(2, 9));

		primsAlgo(adj, n);

	}

	/*
	 * 
	 * 
	 * 
	 * */

	private static void primsAlgo(ArrayList<ArrayList<Node>> adj, int n) {
		boolean[] visited = new boolean[n];
		int[] parent = new int[n];
		int[] dist = new int[n];

		Arrays.fill(dist, Integer.MAX_VALUE);

		int src = 0;
		parent[src] = -1;
		dist[src] = 0;
		visited[src] = true;

		PriorityQueue<Integer> q = new PriorityQueue<Integer>();
		q.add(src);		
		while (!q.isEmpty()) {
			int s = q.poll();	
			visited[s] = true;
			ArrayList<Node> sAdj = adj.get(s);
			for (Node node : sAdj) {
				if (!visited[node.v] && dist[node.v] > node.weight) {
					parent[node.v] = s;
					dist[node.v] = node.weight;
					q.add(node.v);
				}
			}
		}

		for (int i = 1; i < dist.length; i++) {
			System.out.println(parent[i] + " " + i + " -- > " + dist[i]);
		}
	}

}
