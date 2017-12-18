package DFS;

public class IslandPerimeter {
	//
	// 解法一：数island的个数，再减去邻居的个数
	//
	public int islandPerimeter_1(int[][] grid) {
        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
        if (grid == null || grid[0] == null || grid.length == 0 || grid[0].length == 0) return 0;
        int m = grid.length, n = grid[0].length;
        int numIsland = 0, numEdges = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    numIsland++;
                    for(int[] dir : dirs) {
                        int x = dir[0] + i;
                        int y = dir[1] + j;
                        if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == 1) {
                            numEdges++;
                        }
                    }
                }                
            }
        }
        return numIsland*4-numEdges;   
    }
	
	// 解法二：从任何一个岛开始找，如果上下左右是边界或者是水（grid[i][j] == 0），说明此条edge是岛的边界，
	// 用了一个数组res[0]记录值。
	//
	public int islandPerimeter_2(int[][] grid) {
        if (grid == null || grid[0] == null || grid.length == 0 || grid[0].length == 0) return 0;
        int m = grid.length, n = grid[0].length;
        int[] res = new int[1];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                dfs(grid,res,i,j,m,n);
            }
        }
        return res[0];       
    }
    
    void dfs(int[][] grid, int[] res, int i, int j, int m, int n) {
    	//
    	// 在函数的开头判断index是否valid，这样写比在递归时判断是否valid更简洁
    	//
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] != 1) return;
        grid[i][j] = -1;
        if (i+1 >= m || grid[i+1][j] == 0) res[0]++;
        if (i-1 < 0 || grid[i-1][j] == 0) res[0]++;
        if (j+1 >= n || grid[i][j+1] == 0) res[0]++;
        if (j-1 < 0 || grid[i][j-1] == 0) res[0]++;
            
        dfs(grid,res,i+1,j,m,n);
        dfs(grid,res,i-1,j,m,n);
        dfs(grid,res,i,j+1,m,n);
        dfs(grid,res,i,j-1,m,n);        
    }
    
    
    //
    //解法三： bfs
    //
    public int islandPerimeter_3(int[][] grid) {
        if (grid == null || grid[0] == null || grid.length == 0 || grid[0].length == 0) return 0;
        int m = grid.length, n = grid[0].length;
        int res = 0;
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    res += bfs(grid,i,j,m,n,new LinkedList<int[]>());
                }    
            }
        }
        return res;
    }
    
    int bfs(int[][] grid, int i, int j, int m, int n, Queue<int[]> q) {
        q.offer(new int[]{i,j});
        grid[i][j] = -1;
        int res = 0;
        int[][] dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}};
        while(q.size() > 0) {
            int[] curr = q.poll();
            if(curr[0]-1 < 0 || grid[curr[0]-1][curr[1]] == 0) res++;
            if(curr[0]+1 >= m || grid[curr[0]+1][curr[1]] == 0) res++;
            if(curr[1]-1 < 0 || grid[curr[0]][curr[1]-1] == 0) res++;
            if(curr[1]+1 >= n || grid[curr[0]][curr[1]+1] == 0) res++;
            
            for(int[] dir : dirs) {
                int x = dir[0] + curr[0];
                int y = dir[1] + curr[1];
                if (x >= 0 && x < m && y >=0 && y < n && grid[x][y] == 1) {
                    q.offer(new int[]{x,y});
                    grid[x][y] = -1;
                }
            }            
        }
        return res;   
    }
}
