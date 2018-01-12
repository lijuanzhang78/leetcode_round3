package DynamicProgramming;

public class GuessNumberHigherOrLowerII {
	public int getMoneyAmount(int n) {
        if (n < 1) return 0;
        int[][] dp = new int[n+1][n+1]; // actually 1 to n in use
        
        for(int i = 1; i <= n; i++) {
            dp[i][i] = 0; // [i,i] need 0 to guarantee a win;
        }
        
        for(int len = 2; len <= n; len++) {
            for(int i = 1; i+len-1 <= n; i++) {
                int j = i + len - 1;
                int min = Integer.MAX_VALUE;
                if (len == 2) {
                    dp[i][j] = Math.min(i,j);
                    continue;
                }
                for(int k = i+1; k < j; k++) {
                    min = Math.min(min, Math.max(k+dp[k+1][j], k+dp[i][k-1]));
                } 
                dp[i][j] = min;
            }    
        }
        return dp[1][n];   
    }

}
