package Google;

public class _813_LargestSumOfAverages {
	public double largestSumOfAverages(int[] A, int K) {
        if (A == null || A.length == 0) return 0.0;
        double[] sum = new double[A.length + 1];
        for(int i = 0; i < A.length; i++) {
            sum[i+1] = sum[i] + A[i];
        }
        double[][] dp = new double[K+1][A.length+1];
        for(int i = 1; i <= A.length; i++) {
            dp[1][i] = sum[i]/i;
        }
        for(int k = 2; k <= K; k++) {
            for(int i = k; i <= A.length; i++) {
                for(int j = k-1; j < i; j++) {
                    dp[k][i] = Math.max(dp[k][i], dp[k-1][j] + (sum[i]-sum[j])/(i-j));
                }
            }
        }
        return dp[K][A.length];   
    }

}
