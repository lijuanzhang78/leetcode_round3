package BackTracking;

// 需要先判断给定字符串是不是可以被break，用动态规划的思想即可
// 给定s，第一步需要cut s，看第一部分是不是在字典里面，如果在字典里面，那么就递归剩余的字符串，如果能被break，那么
// 递归返回的就是剩余字符串能被break的所有可能，然后这个递归的结果再与第一部分结合构成新解，再返回上一层
// 
public class WordBreakII {
	public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>();
        for(String str : wordDict) {
            dict.add(str);
        }
        
        if (!canBreak(s,dict)) return new ArrayList<String>();
        return helper(s,dict,0);
    }
    
    List<String> helper(String s, Set<String> dict, int pos) {
        List<String> res = new ArrayList<>();
        if (pos == s.length()) {
            res.add("");
            return res;
        }
        
        for(int i = pos; i < s.length(); i++) {
            String str = s.substring(pos,i+1);
            if (dict.contains(str)) {
                List<String> brokens = helper(s,dict,i+1);
                if (brokens.size() > 0) {
                    for(String broken : brokens) {
                        String news = str + " " + broken;
                        res.add(news.trim());
                    }
                }
            }
        }
        return res;
    }
        
        
    public boolean canBreak(String s, Set<String> dict) {
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
