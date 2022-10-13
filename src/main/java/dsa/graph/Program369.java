package dsa.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Program369 {

	public static void main(String[] args) {
		int v = 10;
		List<ArrayList<Integer>> ls = new ArrayList<>();
		for (int i = 0; i <= v; i++) {
			ls.add(new ArrayList<>());
		}
		addEdge(ls, 1, 3);
		addEdge(ls, 1, 4);
		addEdge(ls, 1, 5);
		addEdge(ls, 2, 3);
		addEdge(ls, 2, 9);
		addEdge(ls, 3, 6);
		addEdge(ls, 4, 6);
		addEdge(ls, 4, 8);
		addEdge(ls, 5, 8);
		addEdge(ls, 5, 8);
		addEdge(ls, 6, 7);
		addEdge(ls, 7, 8);
		addEdge(ls, 8, 10);
		System.out.println(Arrays.toString(calculateMinimumTime(ls, v)));
	}

	private static void addEdge(List<ArrayList<Integer>> ls, int i, int j) {
		ls.get(i).add(j);
	}

	private static int[] calculateMinimumTime(List<ArrayList<Integer>> ls, int v) {
		// calculate in degree array
		int[] indegree = new int[v + 1];
		int[] cost = new int[v + 1];
		indegree[0] = -1;
		for (int k = 0; k < ls.size(); k++) {
			for (int l = 0; l < ls.get(k).size(); l++) {
				indegree[ls.get(k).get(l)]++;
			}
		}

		int index = 1;
		Queue<Integer> q = new LinkedList<Integer>();
		for (int i = 0; i < indegree.length; i++) {
			if (indegree[i] == 0) {
				q.add(i);
				cost[index++] = 1;
			}
		}
		
		while(!q.isEmpty()){
			int cur = q.poll();
			for (int n : ls.get(cur)) {
				indegree[n]--;
				if(indegree[n] == 0){
					q.add(n);
					cost[n] = 1 + cost[cur];
				}
			}
		}

		return cost;
	}

}
