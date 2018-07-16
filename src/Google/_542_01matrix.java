package Google;

import java.util.LinkedList;
import java.util.Queue;

public class _542_01matrix {
	public int[][] updateMatrix(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    q.offer(new int[]{i,j});
                }
            }
        }
        
        int level = 0;
        int[][] dirs = {{1,0},{0,1},{-1,0},{0,-1}};
        while(q.size() > 0) {
            int size = q.size();
            level++;
            for(int i = 0; i < size; i++) {
                int[] curr = q.poll();
                for(int[] d : dirs) {
                    int x = d[0]+curr[0];
                    int y = d[1]+curr[1];
                    if (x < 0 || x >= m || y < 0 || y >= n || matrix[x][y] == 0 || visited[x][y]) continue;
                    visited[x][y] = true;
                    matrix[x][y] = level;
                    q.offer(new int[]{x,y});
                }
            }
        }
        return matrix;
    }
	
	public static void main(String[] args) {
		int[][] matrix = {{0,0,0},{0,1,0},{1,1,1}};
		int[][] res = new _542_01matrix().updateMatrix(matrix);
		return;
	}
}
