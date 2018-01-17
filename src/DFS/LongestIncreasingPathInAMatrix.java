package DFS;

public class LongestIncreasingPathInAMatrix {
	int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) return 0;
        int m = matrix.length, n = matrix[0].length;
        int[][] maxlen = new int[m][n];
        
        for(int i = 0; i < m; i ++) {
            Arrays.fill(maxlen[i], Integer.MIN_VALUE); 
        }
        
        int res = Integer.MIN_VALUE;
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                    dfs(matrix,maxlen,i,j,m,n);
                    res = Math.max(res,maxlen[i][j]);    
            }
        }
        return res;
    }
    
    void dfs(int[][] matrix, int[][] maxlen, int i, int j, int m, int n) {
        if (maxlen[i][j] != Integer.MIN_VALUE) return;
        
        for(int[] dir : dirs) {
            int x = dir[0] + i;
            int y = dir[1] + j;
            if (x < 0 || x >= m || y < 0 || y >= n) continue;
            if (matrix[i][j] < matrix[x][y]) {
                dfs(matrix,maxlen,x,y,m,n);
                maxlen[i][j] = Math.max(maxlen[i][j], maxlen[x][y]+1);
            } 
        }
        if (maxlen[i][j] == Integer.MIN_VALUE) maxlen[i][j] = 1;
        return;    
    }

}
