package TwoPointers;

// 不要忘记跳出for loop最后 还要比较一下 right-left 和 res的大小！
//
public class LongestSubstringWithoutRepeatingCharacters {
	public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        int left = 0, right = 0;
        Set<Character> set = new HashSet<>();
        int res = Integer.MIN_VALUE;
        for(right = 0; right < s.length();) {
            char c = s.charAt(right);
            if (!set.contains(c)) {
                set.add(c);
            } else {
                res = Math.max(res,right-left);
                while(s.charAt(left) != c) {
                    set.remove(s.charAt(left));
                    left++;
                }
                left++;
            }
            right++;
        }
        res = Math.max(res,right-left); // 这一句不要忘记
        return res;
    }

}
