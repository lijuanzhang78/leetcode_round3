package Google_Others;

// n objects and 1 bad with maximum weight W
// [w1,w2,w3,...wn]
// [v1,v2,v3,...vn] 
// how to select objects to make total maximum value
		
public class _01Knapsack {
	int knapsack(int[] w, int[] v, int W) {
		int n = w.length;
		int[][] dp = new int[n+1][W+1]; 
		
		for(int i = 0; i <= n; i++) {
			dp[i][0] = 0; 
		}
		for(int i = 0; i <= W; i++) {
			dp[0][i] = 0;
		}
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= W; j++) {
				dp[i][j] = dp[i-1][j]; // not select
				if (j >= w[i-1]) {
					dp[i][j] = Math.max(dp[i][j], dp[i-1][j-w[i-1]]+v[i-1]);
				}
			}
		}
		return dp[n][W];
	}
		
	public static void main(String[] args) {
		int[] w = {1,2,3,8,7,4};
		int[] v = {20,5,10,40,15,25};
		int W = 10;
		int max = new _01Knapsack().knapsack(w, v, W);
		return;	
	}
}
