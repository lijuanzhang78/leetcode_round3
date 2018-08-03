package Google_Others;

// substitution
// insertion
// deletion
// convert s to t
public class EditDistance {
	int getMinEditDist(String s, String t) {
		int m = s.length(), n = t.length();
		int[][] dp = new int[m+1][n+1];
		for(int i = 0; i <= n; i++) {
			dp[0][i] = i; // convert empty string to string with length i (by insertion)
		}
		for(int i = 0; i <= m; i++) {
			dp[i][0] = i; // convert string with length i to empty string (by deletion)
		}
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				if (s.charAt(i) == t.charAt(j)) {
					dp[i+1][j+1] = dp[i][j];
				} else {
					dp[i+1][j+1] = 1+Math.min(dp[i][j], // substitution
							Math.min(dp[i+1][j],   // insertion
									 dp[i][j+1]));  // deletion 
				}	
			}
		}
		return dp[m][n];
	}
	public static void main(String[] args) {
		String s = "kitten", t = "sitting";
		int res = new EditDistance().getMinEditDist(s, t);
		return;	
	}
}
