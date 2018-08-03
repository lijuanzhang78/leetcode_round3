package Google;

public class _375_GuessNumberHigherOrLower {
	public int getMoneyAmount(int n) {
        int[][] dp = new int[n+1][n+1];
        
        for(int len = 2; len <= n; len++) {
            for(int i = 1; i <= n-len+1; i++) {
                int j = i+len-1;
                dp[i][j] = Integer.MAX_VALUE;
                int max = Integer.MIN_VALUE;
                for(int k = i; k <= j; k++) {
                    max = Integer.MIN_VALUE;
                    if (k-1>=i) {
                        max = Math.max(max, k+dp[i][k-1]);
                    }
                    if (k+1<=j) {
                        max = Math.max(max,k+dp[k+1][j]);
                    }
                    dp[i][j] = Math.min(dp[i][j],max);
                }
            }
        }
        return dp[1][n];
    }

}
