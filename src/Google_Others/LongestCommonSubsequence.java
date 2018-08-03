package Google_Others;

public class LongestCommonSubsequence {
	int longestCommonSubsequence(String s, String t) {
		int m = s.length(), n = t.length();
		int[][] dp = new int[m+1][n+1];
		for(int i = 0; i < s.length(); i++) {
			for(int j = 0; j < t.length(); j++) {
				if (s.charAt(i) == t.charAt(j)) {
					dp[i+1][j+1] = dp[i][j] + 1;
				} else {
					dp[i+1][j+1] = Math.max(dp[i][j+1], dp[i+1][j]);
				}
			}
		}
		return dp[m][n];
	}
	
	int longestCommonSubsequence_SpaceOpt(String s, String t) {
		int m = s.length(), n = t.length();
		int[] prev = new int[n+1];
		int[] curr = new int[n+1];
		for(int i = 0; i < s.length(); i++) {
			for(int j = 0; j < t.length(); j++) {
				if (s.charAt(i) == t.charAt(j)) {
					curr[j+1] = prev[j] + 1;
				} else {
					curr[j+1] = Math.max(prev[j+1], curr[j]);
				}
			}
			for(int j = 0; j <= t.length(); j++) {
				prev[j] = curr[j];
			}
		}
		return curr[n];
	}
	
	public static void main(String[] args) {
		String s = "XMJYAUZ", t = "MAJAWXU";
		int res = new LongestCommonSubsequence().longestCommonSubsequence(s, t);
		int res1 = new LongestCommonSubsequence().longestCommonSubsequence_SpaceOpt(s, t);
		return;
	}
}
