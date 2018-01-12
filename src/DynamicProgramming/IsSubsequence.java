package DynamicProgramming;

public class IsSubsequence {
	public boolean isSubsequence(String s, String t) {
        if (s == null || s.length() == 0) return true;
        int lens = s.length(), lent = t.length();
        boolean[][] dp = new boolean[lens+1][lent+1];
        
        // initialize
        for(int i = 0; i <= lent; i++) {
            dp[0][i] = true; // when the length of s is zero, it is the subsubsequence of t of any length;
        }
        
        for(int i = 1; i <= lens; i++) {
            for(int j = 1; j <= lent; j++) {
                if (j < i) {
                    dp[i][j] = false;
                } else {
                    dp[i][j] = dp[i][j-1];
                    if (s.charAt(i-1) == t.charAt(j-1)) {
                        dp[i][j] = dp[i][j] || dp[i-1][j-1];
                    } 
                }    
            }
        }
        return dp[lens][lent];
    }
	
	public static void main(String[] args) {
		String s = "abc";
		String t = "ahbgdc";
		boolean res = new IsSubsequence().isSubsequence(s, t);
		return;
	}

}
