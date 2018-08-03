package Google;

public class _486_PredictTheWinnder {
	public boolean PredictTheWinner(int[] nums) {
        if (nums == null || nums.length == 1) return true;
        int n = nums.length;
        int[][] dp = new int[n][n];
        int[] sum = new int[n];
        sum[0] = nums[0];
        for(int i = 1; i < n; i++) sum[i] = sum[i-1]+nums[i];
        for(int[] arr : dp) {
            Arrays.fill(arr, Integer.MIN_VALUE);
        }
        dfs(dp,nums,0,n-1,sum);
        return dp[0][n-1] >= sum[n-1]/2;
    }
    int getSum(int[] sum, int i, int j) {
        if (i == 0) return sum[j];
        return sum[j] - sum[i-1];
    }
    int dfs(int[][] dp, int[] nums, int i, int j, int[] sum) {
        if (dp[i][j] != Integer.MIN_VALUE) return dp[i][j];
        int max = Integer.MIN_VALUE;
        if (i == j) {
            dp[i][i] = nums[i];
            return nums[i];
        }
        max = Math.max(nums[i]+getSum(sum,i,j)-dfs(dp,nums,i+1,j,sum), 
                      nums[j]+getSum(sum,i,j)-dfs(dp,nums,i,j-1,sum));
        dp[i][j] = max;
        return max;
    }

}
