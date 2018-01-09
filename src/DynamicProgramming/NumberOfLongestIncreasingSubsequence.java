package DynamicProgramming;

// LIS 的变种
// 用二维dp,第一位记录max length，第二位记录对应的count
//
public class NumberOfLongestIncreasingSubsequence {
	public int findNumberOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int n = nums.length;
        int[][] dp = new int[n][2]; // dp[i][0] -- longest length dp[i][1] -- count
        
        dp[0][0] = 1; dp [0][1] = 1;
        int max = 1, maxcount = 1;
        for(int i = 1; i < n; i++) {
            dp[i][0] = 1; dp[i][1] = 1; // initial condition
            for(int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    if (dp[i][0] < dp[j][0] + 1) {
                        dp[i][0] = dp[j][0] + 1;
                        dp[i][1] = dp[j][1];
                    } else if (dp[i][0] == dp[j][0] + 1) {
                        dp[i][1] += dp[j][1]; // 注意这里！！！从dp【j】那里继承下来的都要算进去。
                    }
                }    
            }
            if (max < dp[i][0]) {
                max = dp[i][0]; maxcount = dp[i][1];
            } else if (max == dp[i][0]) {
                maxcount += dp[i][1];
            }   
        }
        return maxcount;
    }

}
