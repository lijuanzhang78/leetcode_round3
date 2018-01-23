package DynamicProgramming;

// 注意：如果wordDict为空的话，不能立刻返回，比如s = “a”，wordDict为空，应该返回false
// 
public class WordBreak {
	public boolean wordBreak(String s, List<String> wordDict) {
        //if (s == null || s.length() == 0 || wordDict == null || wordDict.size() == 0) return true;
        Set<String> dict = new HashSet<>();
        for(String str : wordDict) {
            dict.add(str);
        }
        
        boolean[] dp = new boolean[s.length()]; // dp[i] s.substring(0,i+1) broken or not
        for(int i = 0; i < s.length(); i++) {
            if (dict.contains(s.substring(0,i+1))) {
                dp[i] = true; continue;
            }
            for(int j = 0; j < i; j++) {
                if (dp[j] && dict.contains(s.substring(j+1,i+1))) {
                    dp[i] = true; break;
                }
            }
        }
        return dp[s.length()-1];
    }

}
