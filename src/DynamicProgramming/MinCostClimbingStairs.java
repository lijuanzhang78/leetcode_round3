package DynamicProgramming;

// dp[i] 到达step i的最小cost，dp[cost.length-1]是到达最后一级台阶的最小cost， 并不是到达top的最小cost
// 所以dp的dimension应该是cost.length + 1
//
public class MinCostClimbingStairs {
	public int minCostClimbingStairs(int[] cost) {
        if (cost == null || cost.length == 0) return 0;
        int[] dp = new int[cost.length+1];
        dp[0] = 0; dp[1] = 0;
        for(int i = 2; i <= cost.length; i++) {
            dp[i] = Math.min(dp[i-2]+cost[i-2], dp[i-1]+cost[i-1]);
            
        }
        return dp[cost.length];
    }

}
