package Google_Others;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class GBike {
	class Pair {
		int[] bike;
		int[] person;
		int dist;
		Pair(int[] bike, int[] person, int dist) {
			this.bike = bike;
			this.person = person;
			this.dist = dist;
		}
	}
	
	// 1-represents bike; 2-represents person; 0-empty
	//
	int[] getClosestBike(int[][] matrix, int[] target) {
		if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) return new int[0];
		Queue<Pair> q = new PriorityQueue<Pair>((a,b)->(a.dist-b.dist));
		int m = matrix.length, n = matrix[0].length;
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				if (matrix[i][j] == 1) {
					bfs(matrix,q,new boolean[m][n],i,j);
				}
			}
		}
		
		int[] res = new int[2];
		while(q.size() > 0) {
			Pair top = q.poll();
			int[] person = top.person;
			int[] bike = top.bike;
			if (matrix[person[0]][person[1]] == 2 && matrix[bike[0]][bike[1]] == 1) {
				matrix[person[0]][person[1]] = -1;
				matrix[bike[0]][bike[1]] = -1;
				if (person[0] == target[0] && person[1] == target[1]) {
					res[0] = bike[0];
					res[1] = bike[1];
					break;
				}
			}
		}
		return res;
	}
		
	void bfs(int[][] matrix, Queue<Pair> pq, boolean[][] visited, int sr, int sc) {
		int level = 0, m = matrix.length, n = matrix[0].length;
		Queue<int[]> q = new LinkedList<>();
		int[][] dirs = {{1,0},{0,1},{-1,0},{0,-1}};
		q.offer(new int[]{sr,sc});
		visited[sr][sc] = true;
		while(q.size() > 0) {
			int size = q.size();
			for(int i = 0; i < size; i++) {
				int[] curr = q.poll();
				for(int[] dir : dirs) {
					int x = dir[0] + curr[0];
					int y = dir[1] + curr[1];
					if (x < 0 || x >= m || y < 0 || y >= n || visited[x][y]) continue;
					q.offer(new int[]{x,y});
					visited[x][y] = true;
					if (matrix[x][y] == 2) {
						pq.offer(new Pair(new int[]{sr,sc}, new int[]{x,y}, level+1));
					}
				}
			}
			level++;		
		}	
	}
	
	public static void main(String[] args) {
		int[][] matrix = {{2,0,1,1,0},
				          {0,0,2,0,0},
				          {0,0,0,2,0},
				          {1,0,0,0,0}};
		int[] target = {0,0};
		int[] res = new GBike().getClosestBike(matrix,target);
		return;
	}
}
