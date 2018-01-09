package DynamicProgramming;

public class LongestPalindromicSubsequence {
	public int longestPalindromeSubseq(String s) {
        if (s == null || s.length() == 0) return 0;
        int[][] dp = new int[s.length()][s.length()];
        for(int len = 1; len <= s.length(); len++) {
            for(int i = 0; i < s.length(); i++) {
                if (len == 1) {
                    dp[i][i] = 1;
                } else if (len == 2) {
                    int j = i+len-1;
                    if (j >= s.length()) continue;
                    if (s.charAt(i) == s.charAt(j)) {
                        dp[i][j] = 2;
                    } else {
                        dp[i][j] = 1;
                    }
                } else {
                    int j = i+len-1;
                    if (j >= s.length()) continue;
                    if (s.charAt(i) == s.charAt(j)) {
                        dp[i][j] = dp[i+1][j-1] + 2;
                    } else {
                        dp[i][j] = Math.max(dp[i+1][j],dp[i][j-1]);
                    }
                }
            }
        }
        return dp[0][s.length()-1];
    }

}
