package DynamicProgramming;

public class DecodeWays {
	public int numDecodings(String s) {
        if (s == null || s.length() == 0) return 0;
        int[][] dp = new int[s.length()+1][2]; // dp[i][0] individual, dp[0][1] combined
        dp[0][0] = 1; // individual 
        dp[0][1] = 0; // combined
        dp[1][0] = s.charAt(0) != '0'? 1 : 0; 
        dp[1][1] = 0; 
        
        for(int i = 2; i <= s.length(); i++) {
            char c0 = s.charAt(i-2);
            char c1 = s.charAt(i-1);
            if (c1 != '0') {
                dp[i][0] = dp[i-1][0] + dp[i-1][1]; // individual;
            }
            
            if (c0 >= '1' && c0 <= '2') {
                int val = Integer.valueOf(s.substring(i-2,i));
                if (val >= 10 && val <= 26) {
                    dp[i][1] = dp[i-2][0] + dp[i-2][1];
                }
            }            
        }
        return dp[s.length()][0] + dp[s.length()][1];    
    }

}
