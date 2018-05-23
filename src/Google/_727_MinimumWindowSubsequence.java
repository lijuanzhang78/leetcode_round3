package Google;

public class _727_MinimumWindowSubsequence {
	public String minWindow(String S, String T) {
        if ((S == null || S.length() == 0) && (T == null || T.length() == 0)) return "";
        int m = S.length(), n = T.length();
        int[][] dp = new int[m+1][n+1];
        for(int i = 0; i <= m; i++) {
            Arrays.fill(dp[i],-1);
        }
        for(int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        int minLen = Integer.MAX_VALUE;
        int start = -1;
        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                if (S.charAt(i-1) == T.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
            
            if (dp[i][n] != -1) {
                if (i - dp[i][n] < minLen) {
                    start = dp[i][n];
                    minLen = i - dp[i][n];
                }    
            }
        }
        return start == -1? "" : S.substring(start,start+minLen);
    }

}
