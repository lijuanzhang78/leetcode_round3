package Google;

public class _340_LongestSubstringWithAtMostKDistinceCharacters {
	public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s == null || s.length() == 0) return 0;
        Map<Character,Integer> map = new HashMap<>();
        int left = 0, maxlen = 0;
        for(int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            if (map.containsKey(c)) {
                map.put(c,map.get(c)+1);
            } else {
                map.put(c,1);
                while(map.size() > k) {
                    char cleft = s.charAt(left);
                    left++;
                    map.put(cleft,map.get(cleft)-1);
                    if (map.get(cleft) == 0) {
                        map.remove(cleft);
                    }    
                }
            }
            maxlen = Math.max(maxlen,right-left+1);
        }
        return maxlen;
    }

}
