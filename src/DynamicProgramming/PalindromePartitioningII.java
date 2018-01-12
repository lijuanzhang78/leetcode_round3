package DynamicProgramming;

public class PalindromePartitioningII {
	public int minCut(String s) {
        if (s == null || s.length() == 0) return 0;
        int[] dp = new int[s.length()];
        boolean[][] palin = new boolean[s.length()][s.length()];
        
        for(int i = 0; i < s.length(); i++) {
            dp[i] = i; // maximum: cut at every letter
            for(int j = 0; j <= i; j++) {
                if (j+1 == i) {
                    palin[j+1][i] = true;
                    dp[i] = Math.min(dp[i],dp[j]+1);
                } else if (j+1 < i && s.charAt(j+1) == s.charAt(i) && palin[j+2][i-1]) {
                    palin[j+1][i] = true;
                    dp[i] = Math.min(dp[i],dp[j]+1);
                } else if (j == i && i != 0 && s.charAt(0) == s.charAt(i) && palin[1][i-1]) {
                    palin[0][i] = true;
                    dp[i] = Math.min(dp[i],dp[j]+1);
                } 
            }    
        } 
        return dp[s.length()-1];
    }
	
	public static void main(String[] args) {
		String s = "aab";
		int res = new PalindromePartitioningII().minCut(s);
		return;
	}

}
