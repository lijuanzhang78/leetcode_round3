package DynamicProgramming;

// dp[i][j]: length of longest repeated subarray ending with nums[i] and nums[j]
//
public class MaximumLengthOfRepeatedSubarray {
	public int findLength(int[] A, int[] B) {
        if (A == null || A.length == 0 || B == null || B.length == 0) return 0;
        int m = A.length, n = B.length;
        int[][] dp = new int[m][n];
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < m; i++) {
            if (A[i] == B[0]) {
                dp[i][0] = 1;
                max = Math.max(max,dp[i][0]);
            }
        }
        for(int i = 0; i < n; i++) {
            if (A[0] == B[i]) {
                dp[0][i] = 1;
                max = Math.max(max,dp[0][i]);
            }
        }
        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                if (A[i] == B[j]) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                    max = Math.max(max,dp[i][j]);
                }    
            }
        }
        return max == Integer.MIN_VALUE? 0 : max;
        
    }

}
