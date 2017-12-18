package DFS;

// 解法一： DFS
// BFS也可以用，只是搜索方式不一样
//
public class MaxAreaOfIsland {
	public int maxAreaOfIsland_1(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) return 0;
        int res = Integer.MIN_VALUE;
        int m = grid.length, n = grid[0].length;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                int[] count = new int[1];
                if (grid[i][j] == 1) {
                    count[0] = 0;
                    dfs(grid,i,j,m,n,count);
                    res = Math.max(res,count[0]);
                }
            }    
        }
        return res == Integer.MIN_VALUE? 0 : res;
    }
    
    void dfs(int[][] grid, int i, int j, int m, int n, int[] count) {
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] != 1) {
            return;
        }
        count[0]++; grid[i][j] = -1;
        dfs(grid,i+1,j,m,n,count);
        dfs(grid,i-1,j,m,n,count);
        dfs(grid,i,j+1,m,n,count);
        dfs(grid,i,j-1,m,n,count);
    }

}

// 对解法一的改进：可以不用count[0],而且对dfs加一个返回值
// 注意理解运用递归返回值和参数，特别是当两者一样的时候
//
public int maxAreaOfIsland_2(int[][] grid) {
    if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) return 0;
    int res = Integer.MIN_VALUE;
    int m = grid.length, n = grid[0].length;
    for(int i = 0; i < m; i++) {
        for(int j = 0; j < n; j++) {
            if (grid[i][j] == 1) {
                int count = 0;
                count = dfs(grid,i,j,m,n,count);
                res = Math.max(res,count);
            }
        }    
    }
    return res == Integer.MIN_VALUE? 0 : res;
}

int dfs(int[][] grid, int i, int j, int m, int n, int count) {
    if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] != 1) {
        return count;
    }
    count++; grid[i][j] = -1;
    count = dfs(grid,i+1,j,m,n,count);
    count = dfs(grid,i-1,j,m,n,count);
    count = dfs(grid,i,j+1,m,n,count);
    count = dfs(grid,i,j-1,m,n,count);
    return count;
}
