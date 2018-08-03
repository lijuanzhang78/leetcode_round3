package Google;

import java.util.HashMap;
import java.util.Map;

public class _340_LongestSubstringWithAtMostKDistinctCharacters {
	public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s == null || s.length() == 0) return 0;
        int left = 0, right = 0, len = Integer.MIN_VALUE;
        Map<Character,Integer> map = new HashMap<>();
        for(right = 0; right < s.length(); right++) {
            if (!map.containsKey(s.charAt(right))) {
                map.put(s.charAt(right),right);
                if (map.size() > k) {
                    int minpos = Integer.MAX_VALUE;
                    Character minkey = null;
                    for(char key : map.keySet()) {
                        if (minpos > map.get(key)) {
                            minpos = map.get(key);
                            minkey = key;
                        }
                    }
                    left = minpos+1;
                    map.remove(minkey);
                }
                len = Math.max(right-left+1,len); 
            } else {
                map.put(s.charAt(right),right);
                len = Math.max(right-left+1,len);
            }
        }
        return len;
    }
    
	
	public static void main(String[] args) {
		String s = "aba";
		int k = 1;
		int res = new _340_LongestSubstringWithAtMostKDistinctCharacters().lengthOfLongestSubstringKDistinct(s, k);
		return;
	}
	

}
