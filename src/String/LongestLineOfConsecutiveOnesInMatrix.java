package String;

// anti-diagonal的意思
// 需要判断j < n, 防止数组越界 dp[i][j][3] = (j < n? dp[i-1][j+1][3] : 0) + 1; // anti-diagonal
// 返回时要判断max == Integer.MIN_VALUE;
//
public class LongestLineOfConsecutiveOnesInMatrix {
	public int longestLine(int[][] M) {
        if (M == null || M.length == 0 || M[0] == null || M[0].length == 0) return 0;
        int m = M.length, n = M[0].length;
        int[][][] dp = new int[m+1][n+1][4];
        int max = Integer.MIN_VALUE;
        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                if (M[i-1][j-1] == 0) continue;
                dp[i][j][0] = dp[i][j-1][0] + 1; // horizontal
                dp[i][j][1] = dp[i-1][j][1] + 1; // vertical
                dp[i][j][2] = dp[i-1][j-1][2] + 1; // diagonal
                dp[i][j][3] = (j < n? dp[i-1][j+1][3] : 0) + 1; // anti-diagonal
                max =  Math.max(max, Math.max(Math.max(dp[i][j][0], dp[i][j][1]), Math.max(dp[i][j][2], dp[i][j][3])));   
            }   
        }
        return max == Integer.MIN_VALUE? 0 : max;
    }

}
