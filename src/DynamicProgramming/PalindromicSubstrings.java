package DynamicProgramming;

public class PalindromicSubstrings {
	public int countSubstrings(String s) {
        if (s == null || s.length() == 0) return 0;
        int res = 0;
        boolean[][] dp = new boolean[s.length()][s.length()];
        
        // len = 1
        for(int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
            res++;
        }
        
        // len = 2
        for(int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(i+1)) {
                dp[i][i+1] = true;
                res++;
            }
        }
        
        // len = 3 and above
        for(int len = 3; len <= s.length(); len++) {
            for(int i = 0; i < s.length(); i++) {
                int j = i + len - 1; // start at i
                if (j < s.length() && dp[i+1][j-1] && s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = true;
                    res ++;
                }
            }
        }
        return res;
    }
	
	public static void main(String[] args) {
		int res = new PalindromicSubstrings().countSubstrings("a");
		return;
	}

}
