package DynamicProgramming;

// knapsack 
// dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i]]
// 这道题首先要判断数组所有元素的和是不是为偶数，然后问题等价于是否能从N个数里面选一个subset，然后这个subset
// 的和等于sum/2
// dp[i][j] 是否能在前i个数里面得到一个subset然后这个subset的和是j，对于元素i，分为两种情况，可选可不选
// 如果不选它，那么等同于是否能在前i-1个数里面选出一个subset然后这些数的和是j (dp[i-1][j])
// 如果选它，那么问题等同于书否能在前i-1个数里面选出一个subset然后这些数的和是j-nums[i] (dp[i-1][j-nums[i-1]])
// 可以空间优化，一维数组就可以
//
public class PartitionEqualSubsetSum {
	public boolean canPartition(int[] a) {
        if (a == null || a.length == 0) return false;
        int sum = 0;
        for(int i = 0; i < a.length; i++) {
            sum += a[i];
        }
        if (sum % 2 != 0) return false;
        sum /= 2;
        boolean[][] dp = new boolean[a.length+1][sum+1];
        
        dp[0][0] = true;
        for(int i = 1; i <= a.length;i++) {
            dp[i][0] = true;
        }
        for(int i = 1; i <= sum; i++) {
            dp[0][i] = false;
        }
        
        for(int i = 1; i <= a.length; i++) {
            for(int j = 1; j <= sum; j++) {
                dp[i][j] = dp[i-1][j];
                if (j >= a[i-1]) {
                    dp[i][j] = (dp[i][j] || dp[i-1][j-a[i-1]]);
                }
            }
        }
        return dp[a.length][sum];
    }

}
