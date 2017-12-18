package DFS;

import java.util.HashMap;
import java.util.Map;

public class WordPatternII {
	public boolean wordPatternMatch(String pattern, String str) {
        if (pattern == null || pattern.length() == 0) {
            if (str == null || str.length() == 0) {
                return true;
            } else {
                return false;
            }
        }
        Map<Character,String> map = new HashMap<>();
        return dfs(pattern,str,0,0,map);  
    }
    
    boolean dfs(String pattern, String str, int pos, int start, Map<Character,String> map) {
        if (pos == pattern.length() && start == str.length()) return true;
        if (pos == pattern.length()) return false;
        if (start == str.length()) return false;
        for(int end = start; end < str.length(); end++) {
            String curr = str.substring(start,end+1);
            if (!map.containsKey(pattern.charAt(pos))) {
                if(!map.containsValue(curr)) {
                    map.put(pattern.charAt(pos), curr);
                    if (dfs(pattern,str,pos+1,end+1,map)) return true;
                    map.remove(pattern.charAt(pos));
                } 
            } else {
                if (map.get(pattern.charAt(pos)).equals(curr)) {
                    if (dfs(pattern,str,pos+1,end+1,map)) return true; 
                }
            }
        }
        return false;
    }
    
    public static void main(String[] args) {
    	String pattern = "abab";
    	String str = "redblueredblue";
    	boolean res = new WordPatternII().wordPatternMatch(pattern, str);
    	return;
    }

}
