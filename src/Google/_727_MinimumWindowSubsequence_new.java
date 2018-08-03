package Google;

public class _727_MinimumWindowSubsequence_new {
	String s, t;
    public String minWindow(String S, String T) {
        if ((S == null || S.length() == 0) && (T == null || T.length() == 0)) return "";
        this.s = S;
        this.t = T;
        int min = Integer.MAX_VALUE;
        String res = "";
        int[][] dp = new int[S.length()][T.length()];
        for(int[] arr : dp) Arrays.fill(arr,-2);
        for(int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == T.charAt(0)) {
                int end = helper(i,0,dp);
                if (end != -1) {
                    if (end-i < min) {
                        res = S.substring(i,end);
                        min = end-i;
                    }
                }
            }
        }
        return res;
    }
    
    int helper(int i, int j, int[][] dp) {
        if (j == t.length()) {
            return i;
        }
        if (i == s.length()) return -1;
        if (dp[i][j] != -2) return dp[i][j];
        if (s.charAt(i) == t.charAt(j)) {
            int end = helper(i+1,j+1,dp);
            dp[i][j] = end;
            return end;
        } else {
            int end = helper(i+1,j,dp);
            dp[i][j] = end;
            return end;
        }
    }
    
    public static void main(String[] args) {
    	String S = "abcdebdde";
    	String T = "bde";
    	String res = new _727_MinimumWindowSubsequence_new().minWindow(S, T);
    	return;
    }
}
