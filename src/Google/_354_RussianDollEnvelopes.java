package Google;

public class _354_RussianDollEnvelopes {
	public int maxEnvelopes(int[][] envelopes) {
        if (envelopes == null || envelopes.length == 0) return 0;
        Arrays.sort(envelopes,(a,b)->( a[0] - b[0]));
        
        int[] dp = new int[envelopes.length];
        int n = envelopes.length;
        for(int i = 0; i < n; i++) {
            dp[i] = 1;
        }
        
        int max = 1;
        for(int i = 1; i < n; i++) {
            for(int j = 0; j < i; j++) { // their width could be the same
                if (envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1]) {
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
            max = Math.max(max,dp[i]);
        }
        return max;
    }
}
