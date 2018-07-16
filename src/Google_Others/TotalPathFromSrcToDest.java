package Google_Others;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TotalPathFromSrcToDest {
	int totalPaths(int[][] edges, int N, int m, int src, int dest) {
		if (edges == null || edges.length == 0 || edges[0] == null || edges[0].length == 0) return 0;
		List<List<Integer>> adjList = new ArrayList<>();
		for(int i = 0; i < N; i++) {
			adjList.add(new ArrayList<Integer>());
		}
		for(int[] e : edges) {
			adjList.get(e[0]).add(e[1]);
		}
		Queue<Integer> q = new LinkedList<>();
		q.offer(src);
		int level = 0, count = 0;
		while(q.size() > 0 && level <= m) {
			 int size = q.size();
			 for(int i = 0; i < size; i++) {
				 int curr = q.poll();
				 if (curr == dest && level == m) {
					 count++;
				 }
				 for(int adj : adjList.get(curr)) {
					 q.offer(adj);
				 }
			 }
			 level++;
		}
		return count;
	}
	
	public static void main(String[] args) {
		int[][] edges = {{0,6},{0,1},{1,6},{1,5},{1,2},{2,3},{3,4},{5,2},{5,3},{5,4},{6,5},{7,6},{7,1}};
		int res = new TotalPathFromSrcToDest().totalPaths(edges, 8, 4, 0, 3);
		return;
	}

}
