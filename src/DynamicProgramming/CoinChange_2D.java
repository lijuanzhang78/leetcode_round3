package DynamicProgramming;

import java.util.Arrays;

// 注意与combination sum IV, coin change 2比较
// 
public class CoinChange_2D {
	public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0) return 0;
        int[][] dp = new int[coins.length+1][amount+1];
        for(int[] arr : dp) {
            Arrays.fill(arr,Integer.MAX_VALUE);
        }
        for(int i = 0; i < dp.length; i++) {
            dp[i][0] = 0;
        }
        for(int j = 1; j <= amount; j++ ) {
            for(int i = 1; i < dp.length; i++) {
                dp[i][j] = dp[i-1][j]; // not select
                int k = 0;
                while(k*coins[i-1] <= j) {
                    if (dp[i-1][j-k*coins[i-1]] != Integer.MAX_VALUE) {
                        dp[i][j] = Math.min(dp[i][j], dp[i-1][j-k*coins[i-1]] + k);
                    }
                    k++;
                }
            }
        }
        return dp[coins.length][amount] == Integer.MAX_VALUE? -1 : dp[coins.length][amount];
    }
	
	public static void main(String[] args) {
		int[] coins = {1,2};
		int amount = 3;
		int res = new CoinChange_2D().coinChange(coins, amount);
	}
}
