package DynamicProgramming;

// 这道题的DP可以借鉴discuss第一个帖子
// 注意这道题这样的内存不是最优的,应该思考怎么样改进
// 返回的是max*max
//
public class MaximalSquares {
	public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) return 0;
        int m = matrix.length, n= matrix[0].length;
        int[][] dp = new int[m][n];
        int max = 0;
        
        // for the first row
        for(int i = 0; i < n; i++) {
            if (matrix[0][i] == '1') {
                dp[0][i] = 1;
                max = Math.max(max,dp[0][i]);
            }
        }
        // for the first colume
        for(int i = 0; i < m; i++) {
            if (matrix[i][0] == '1') {
                dp[i][0] = 1;
                max = Math.max(max,dp[i][0]);
            }
        }
            
        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                if (matrix[i][j] == '1') {
                    dp[i][j] = Math.min(dp[i-1][j],Math.min(dp[i-1][j-1],dp[i][j-1])) + 1;
                    max = Math.max(dp[i][j],max);
                }    
            }
        }
        return max*max;
    }

}
