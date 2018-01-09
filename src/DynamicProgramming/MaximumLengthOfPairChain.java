package DynamicProgramming;

public class MaximumLengthOfPairChain {
	public int findLongestChain(int[][] pairs) {
        if (pairs == null || pairs.length == 0 || pairs[0] == null || pairs[0].length == 0) return 0;
        Arrays.sort(pairs, (a,b)->(a[0]-b[0]));
        int max = Integer.MIN_VALUE;
        int[] dp = new int[pairs.length];
        dp[0] = 1;
        
        for(int i = 1; i < pairs.length; i++) {
            dp[i] = 1;
            for(int j = 0; j < i; j++) {
                if (pairs[i][0] > pairs[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
            max = Math.max(max,dp[i]);
        }
        return max;
    }

}
