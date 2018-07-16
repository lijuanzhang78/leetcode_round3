package Google_Others;

import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class BoatMinDays {
	public int boatMinDays(int[][] matrix, int[] source, int[] end) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
		int m = matrix.length, n = matrix[0].length;
		int[][] dist = new int[m][n];
		for(int[] day : dist) {
			Arrays.fill(day, Integer.MAX_VALUE);
		}
		Queue<Integer> q = new PriorityQueue<Integer>((a,b)-> dist[a/n][a%n] - dist[b/n][b%n]);
		dist[source[0]][source[1]] = 0;
		 // add all vertices to the priority queue
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				q.offer(i*n+j);
			}
		}
			
		Set<Integer> visited = new HashSet<>();
		int[][] dirs = {{1,0},{0,1},{-1,0},{0,-1}};
		while(q.size() > 0) {
			int curr = q.poll();
			// mark as visited, the shortest length for curr[] has determined
			visited.add(curr);
			if (curr/n == end[0] && curr%n == end[1]) break;
			// relax the adjacent vertices, to get an estimate shortest distance
			for(int[] d : dirs) {
				int x = d[0] + curr/n;
				int y = d[1] + curr%n;
				if (x < 0 || x >= m || y < 0 || y >= n || visited.contains(x*n+y)) continue;
				int day = matrix[x][y] >= matrix[curr/n][curr%n]? matrix[x][y] - matrix[curr/n][curr%n] : 0;
				dist[x][y] = Math.min(dist[x][y], dist[curr/n][curr%n] + day);
				q.remove(x*n+y);
				q.offer(x*n+y);		
			}
		}
		return matrix[source[0]][source[1]] + dist[end[0]][end[1]];	
	}
	
	public static void main(String[] args) {
		int[][] matrix = {{1,2,3},
				{2,3,3},
				{1,3,2}};
		int[] begin = {0,0}, end = {2,2};
		int res = new BoatMinDays().boatMinDays(matrix, begin, end);
		return;
		
		
	}
}
