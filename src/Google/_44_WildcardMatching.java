package Google;

public class _44_WildcardMatching {
	public boolean isMatch(String s, String p) {
        if (s == null || p == null) return false;
        int lens = s.length() + 1, lenp = p.length() + 1;
        boolean[][] dp = new boolean[lens][lenp];
        dp[0][0] = true;
        for(int j = 1; j <= p.length(); j++) {
            if (p.charAt(j-1) == '*') dp[0][j] = dp[0][j-1];
        }
        
        for(int i = 1; i <= s.length(); i++) {
            for(int j = 1; j <= p.length(); j++) {
                if (s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '?') {
                    dp[i][j] = dp[i-1][j-1];
                } else if (p.charAt(j-1) == '*') {
                    dp[i][j] = dp[i-1][j] || dp[i][j-1];
                } else {
                    dp[i][j] = false;
                }
            }
        }
        return dp[lens-1][lenp-1];
    }

}
