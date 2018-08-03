package Google;

import java.util.Arrays;

public class _309_BestTimeToBuyAndSellStockWithCoolDown {
	int max = 0;
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int n = prices.length;
        int[][] dp = new int[n][3];
        for(int i = 0; i < prices.length; i++) Arrays.fill(dp[i],Integer.MIN_VALUE);
        // 0-rest, 1-buy, 2-sell
        return dfs(0,prices,0,dp);
        
    }
    
    int dfs(int prev, int[] prices, int day, int[][] dp) {
        if (day >= prices.length) return 0;
        if (dp[day][prev] != Integer.MIN_VALUE) return dp[day][prev];
        int max = 0;
        if (prev == 0) { // prev is rest
            max = Math.max(dfs(0,prices,day+1,dp), -prices[day]+dfs(1,prices,day+1,dp));
        } else if (prev == 1) { // prev is buy
            max = Math.max(prices[day]+dfs(2,prices,day+1,dp), dfs(1,prices,day+1,dp));
        } else {
            max = dfs(0,prices,day+1,dp);
        }
        dp[day][prev] = max;
        return max;
    }
}
