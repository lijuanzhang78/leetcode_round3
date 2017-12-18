package BFS;

//
// 需要确定可以建房子的点是不是可以被all building visit到
// 可以用grid[i][j]--(负数)来确定总共可以被visit的次数,而不是另外开一个内存
//
public class ShortestDistanceFromAllBuildings {
	public int shortestDistance(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        int m = grid.length, n = grid[0].length;
        
        int count = 0; // count the number of buildings visited
        int[][] dis = new int[m][n];
      
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    count++;
                    bfs(grid,i,j,dis,m,n);                    
                }    
            }
        }
        
        int res = Integer.MAX_VALUE;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if (grid[i][j] == -count) {
                    res = Math.min(res,dis[i][j]);
                }   
            }
        }
        return res == Integer.MAX_VALUE? -1 : res;    
    }
    
    void bfs(int[][] grid, int sr, int sc, int[][] dis, int m, int n) {
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{sr,sc});
        visited[sr][sc] = true;
        
        int level = 0;
        while(q.size() > 0) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                int[] curr = q.poll();
                dis[curr[0]][curr[1]] += level;
                
                for(int[] dir : dirs) {
                    int x = dir[0] + curr[0];
                    int y = dir[1] + curr[1];
                    if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] <= 0 && !visited[x][y] ) {
                        grid[x][y] --;
                        q.offer(new int[]{x,y});
                        visited[x][y] = true;
                    }    
                }
            }
            level++;
        }    
    }   

}
