package DynamicProgramming;

public class CoinChange {
	public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0) return 0;
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        for(int i = 1; i <= amount; i++) {
            dp[i] = Integer.MAX_VALUE;
            for(int coin : coins) {
                if (i >= coin) {
                    if (dp[i-coin] != -1) {
                        dp[i] = Math.min(dp[i],dp[i-coin]+1);
                    }
                }
            } 
            if (dp[i] == Integer.MAX_VALUE) dp[i] = -1;
        }
        return dp[amount];
    }

}
