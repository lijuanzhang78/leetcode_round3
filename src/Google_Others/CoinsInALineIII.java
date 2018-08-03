package Google_Others;

public class CoinsInALineIII {
	public class Solution {
	    /**
	     * @param values: a vector of integers
	     * @return: a boolean which equals to true if the first player will win
	     */
	    int[] sum;
	    public boolean firstWillWin(int[] values) {
	        if (values == null || values.length == 0) return false;
	        sum = new int[values.length];
	        sum[0] = values[0];
	        for(int i = 1; i < values.length; i++) {
	            sum[i] = values[i] + sum[i-1];
	        }
	        int n = values.length;
	        int[][] dp = new int[n][n];
	        for(int i = 0; i < n; i++) {
	            dp[i][i] = values[i];
	        }
	        for(int len = 2; len <= values.length; len++) {
	            for(int i = 0; i <= n-len; i++) {
	                int j = len+i-1;
	                dp[i][j] = Math.max(values[i]+getSum(i,j)-dp[i+1][j], 
	                                    values[j]+getSum(i,j)-dp[i][j-1]);
	            }
	        }
	        return dp[0][n-1] > sum[n-1]/2; 
	    }
	    
	    int getSum(int i, int j) {
	        if (i == 0) return sum[j];
	        return sum[j] - sum[i-1];
	    }
	}
}
