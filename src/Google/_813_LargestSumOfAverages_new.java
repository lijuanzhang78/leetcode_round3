package Google;

public class _813_LargestSumOfAverages_new {
	public double largestSumOfAverages(int[] A, int K) {
        if (A == null || A.length == 0) return 0.0;
        int[] sum = new int[A.length];
        sum[0] = A[0];
        for(int i = 1; i < A.length; i++) {
            sum[i] += sum[i-1] + A[i]; 
        }
        double[][] dp = new double[A.length][K+1];
        return dfs(A,K,0,sum,dp);
    }
    
    double dfs(int[] A, int K, int start, int[] sum, double[][] dp) {
        // valid partition
        if (dp[start][K] > 0) return dp[start][K];
        if (K == 1) {
            dp[start][1] = (double)(sum[A.length-1]-sum[start]+A[start]) / (double)(A.length-start);
            return dp[start][1];
           //return (double)(sum[A.length-1]-sum[start]+A[start]) / (double)(A.length-start);
        }
        
        double max = 0;
        for(int i = start; i <= A.length - K; i++) { // make sure it always valid partition
            double first = (double)(sum[i]-sum[start]+A[start])/(double)(i-start+1);
            max = Math.max(max, first+dfs(A,K-1,i+1,sum,dp));
        }
        dp[start][K] = max;
        return max;
    }

}
