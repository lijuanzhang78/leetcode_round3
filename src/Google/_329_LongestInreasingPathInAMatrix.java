package Google;

public class _329_LongestInreasingPathInAMatrix {
	int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
    int m, n;
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) return 0;
        m = matrix.length; n = matrix[0].length;
        int[][] dp = new int[m][n];
        int max = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                int maxPath = dfs(matrix,i,j,dp);
                max = Math.max(max,maxPath);
            }
        }
        return max;
    }
    
    int dfs(int[][] matrix, int i, int j, int[][] dp) {
        if (dp[i][j] != 0) {
            return dp[i][j];
        } else {
            int max = 0;
            for(int[] dir : dirs) {
                int x = dir[0] + i;
                int y = dir[1] + j;
                if (x < 0 || x >= m || y < 0 || y >= n || matrix[x][y] <= matrix[i][j]) continue;
                max = Math.max(dfs(matrix,x,y,dp),max);    
            }
            dp[i][j] = max+1;
            return dp[i][j];
        }    
    }

}
