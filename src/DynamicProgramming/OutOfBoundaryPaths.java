package DynamicProgramming;

// 三维DP dp[N+1][m][n]
// 初始条件：dp[0][i][j] = 1 
// dp[N][p][q]： 从i，j出发，最多走N步走到（p，q）最多走多少步；
// 可以和unique path和unique path II一起做， 这种问题起始点都是1（注意是走法，不是走的步数）
// 
public class OutOfBoundaryPaths {
	public int findPaths(int m, int n, int N, int i, int j) {
        if (N <= 0) return 0;
        int[][][] dp = new int[N+1][m][n];
        dp[0][i][j] = 1; 
        int res = 0;
        
        int MOD = 1000000007;
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        for(int r = 1; r <= N; r++) {
            for(int p = 0; p < m; p++) {
                for(int q = 0; q < n; q++) {
                    for(int[] dir : dirs) {
                        int x = dir[0] + p;
                        int y = dir[1] + q;
                        if (x < 0 || x >= m || y < 0 || y >= n) {
                            res = (res + dp[r-1][p][q])%MOD;
                        } else {
                            dp[r][x][y] = (dp[r][x][y] + dp[r-1][p][q]) % MOD;
                        }
                    }    
                }
            }
        }
        return res;
    }

}
