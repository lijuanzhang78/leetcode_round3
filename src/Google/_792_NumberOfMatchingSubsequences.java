package Google;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _792_NumberOfMatchingSubsequences {
	public int numMatchingSubseq(String S, String[] words) {
        if (words == null || words.length == 0) return 0;
        Map<Character,List<Integer>> map = new HashMap<>();
        for(int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (!map.containsKey(c)) {
                map.put(c, new ArrayList<Integer>());
            }
            map.get(c).add(i);
        }
        int count = 0;
        for(String w : words) {
            int prev = -1;
            boolean found = true;
            for(int i = 0; i < w.length(); i++) {
                char c = w.charAt(i);
                // find the pos of c greater than prev
                if (!map.containsKey(c)) { // 错误
                    found = false;
                    break;
                }
                prev = findIndexGreater(map.get(c),prev);
                if (prev == -1) {
                    found = false;
                    break;
                }
            }
            if (found) count++;
        }
        return count;
    }
    
    int findIndexGreater(List<Integer> list, int prev) {
        int low = 0, high = list.size()-1;
        while(low < high) {
            int mid = low + (high-low)/2;
            if (list.get(mid) <= prev) {
                low = mid + 1;
            } else {
                high = mid;
            }    
        }
        return list.get(low) > prev? list.get(low) : -1;
    }
    
    public static void main(String[] args) {
    	String S = "abcde";
    	String[] words = {"a","bb","acd","ace"};
    	int res = new _792_NumberOfMatchingSubsequences().numMatchingSubseq(S, words);
    	return;
    }
}
