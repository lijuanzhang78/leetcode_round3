package TwoPointers;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithAtMostTwoDistinctCharacters {
	public int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s == null || s.length() == 0) return 0;
        Map<Character,Integer> map = new HashMap<>();
        
        int left = 0, right = 0;
        int res = Integer.MIN_VALUE;
        for(right = 0; right < s.length();) {
            char c = s.charAt(right);
            if (map.containsKey(c)) {
                map.put(c,map.get(c)+1);
                res = Math.max(right-left+1,res);
            } else {
                if (map.size() < 2) {
                    map.put(c,1);
                    res = Math.max(right-left+1,res);
                } else {
                	map.put(c,1); // 错误：
                    while(map.size() > 2) {
                        char leftc = s.charAt(left);
                        map.put(leftc,map.get(leftc)-1);
                        if (map.get(leftc) == 0) map.remove(leftc);
                        left++;
                    } 
                    //map.put(c,1); 错误，应该先添加到map，再移动前面的指针
                    res = Math.max(res,right-left+1);
                }    
            }
            right++;
        }
        return res;
    }
	
	public static void main(String[] args) {
		String s = "eceba";
		int res = new LongestSubstringWithAtMostTwoDistinctCharacters().lengthOfLongestSubstringTwoDistinct(s);
		return;
	}

}
