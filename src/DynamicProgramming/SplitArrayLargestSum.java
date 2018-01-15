package DynamicProgramming;

public class SplitArrayLargestSum {
	public int splitArray(int[] nums, int m) {
        if (nums == null || nums.length == 0) return 0;
        int[][] dp = new int[nums.length][m+1];
        for(int[] arr : dp) {
            Arrays.fill(arr,-1);
        }
        return dfs(nums,m,0,dp);
    }
    
    // get the minimum largest for the subarray starting at start, and m groups
    int dfs(int[] nums, int m, int start, int[][] dp) {
        if (m == 0) {
            if (start < nums.length) {
                return Integer.MAX_VALUE;
            } else {
                return 0;
            }
        } else if (m > 0) {
            if (start == nums.length) return Integer.MAX_VALUE;
        }
        
        if (dp[start][m] != -1) return dp[start][m];
        int minSplit = Integer.MAX_VALUE;
        int oneSplitMaxSum = 0;
        int sum1 = 0;
        for(int i = start; i < nums.length; i++) { //
                sum1 += nums[i];
                int res = dfs(nums,m-1,i+1,dp);
                if (res != -1) {
                    oneSplitMaxSum = Math.max(sum1,res);
                    minSplit = Math.min(minSplit,oneSplitMaxSum);
                }
        }
        dp[start][m] = minSplit;
        return minSplit;
    }

}
