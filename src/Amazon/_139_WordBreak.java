package Amazon;

public class _139_WordBreak {
	public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || s.length() == 0) return true;
        Set<String> dict = new HashSet<>();
        for(String str : wordDict) dict.add(str);
        
        boolean[] dp = new boolean[s.length() + 1]; // dp[i] represents length i, not position
        dp[0] = true;
        for(int i = 1; i <= s.length(); i++) {
            for(int j = 0; j < i; j++) {
                if (dp[j] && dict.contains(s.substring(j,i))) {
                    dp[i] = true;
                    break;
                }
            }    
        }
        return dp[s.length()];
    }

}
