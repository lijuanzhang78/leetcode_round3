package Google;

import java.util.LinkedList;
import java.util.Queue;

public class _317_ShortestDistanceFromAllBuildings {
	int m, n;
    public int shortestDistance(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) return 0;
        m = grid.length; n = grid[0].length;
        int[][] dist = new int[m][n];
        int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
        int numBuilding = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    numBuilding++;
                    Queue<int[]> q = new LinkedList<>();
                    q.offer(new int[]{i,j});
                    int level = 0;
                    while(q.size() > 0) {
                        int size = q.size();
                        level++;
                        for(int isize = 0; isize < size; isize++) {
                            int[] curr = q.poll();
                            for(int[] dir : dirs) {
                            	int x = dir[0] + curr[0];
                                int y = dir[1] + curr[1];
                                if (x < 0 || x >= m || y < 0 || y >= n || grid[x][y] != -(numBuilding-1)) continue;
                                grid[x][y] = -numBuilding;
                                dist[x][y] += level;
                                q.offer(new int[]{x,y});
                            }                        
                        }
                    }
                }
            }
        }
        
        int minDist = Integer.MAX_VALUE;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if (grid[i][j] == -numBuilding) {
                    minDist = Math.min(dist[i][j],minDist);
                }
            }
        }
        return minDist == Integer.MAX_VALUE? -1 : minDist;
    }
    
    public static void main(String[] args) {
    	int[][] grid = {{1,0,2,0,1},{0,0,0,0,0},{0,0,1,0,0}};
    	int res = new _317_ShortestDistanceFromAllBuildings().shortestDistance(grid);
    	return;
    }

}
