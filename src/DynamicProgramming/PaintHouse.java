package DynamicProgramming;

// 
public class PaintHouse {
	public int minCost(int[][] costs) {
        if (costs == null || costs.length == 0 || costs[0] == null || costs[0].length == 0) return 0;
        int n = costs.length;
        int[][] dp = new int[n][3]; // dp[i][j] the min cost for house 0 to i to paint house i the color j
        for(int i = 0; i < 3; i++) {
            dp[0][i] = costs[0][i];
        }
        
        for(int i = 1; i < costs.length; i++) {
            dp[i][0] = Math.min(dp[i-1][1],dp[i-1][2]) + costs[i][0];
            dp[i][1] = Math.min(dp[i-1][0],dp[i-1][2]) + costs[i][1];
            dp[i][2] = Math.min(dp[i-1][0],dp[i-1][1]) + costs[i][2];
        }
        return Math.min(Math.min(dp[n-1][0],dp[n-1][1]),dp[n-1][2]);
    }

}
