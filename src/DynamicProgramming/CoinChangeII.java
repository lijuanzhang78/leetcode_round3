package DynamicProgramming;

// pay attention to the initialization: dp[i][0] = 1;
// the two for loops can be exchanged
//
public class CoinChangeII {
	public int change(int amount, int[] coins) {
        // write your code here
        if (coins == null || coins.length == 0) return 0;
        int[][] dp = new int[coins.length+1][amount+1];
        for(int i = 0; i <= coins.length; i++) {
            dp[i][0] = 1; 
        }
        //for(int i = 1; i <= coins.length; i++) {
            //for(int j = 1; j <= amount; j++) { 
        for(int j = 1; j <= amount; j++) {    
            for(int i = 1; i <= coins.length; i++) {
                dp[i][j] = dp[i-1][j]; // not select
                if (j >= coins[i-1]) {
                    dp[i][j] += dp[i][j-coins[i-1]];
                }
            }
        }
        return dp[coins.length][amount];
    }

}
