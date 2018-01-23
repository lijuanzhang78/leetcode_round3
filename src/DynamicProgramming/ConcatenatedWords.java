package DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// 对words先排序，短的放前面
// 然后对每个word进行类似word break的分析，如果可以被前面的字符串组成，那么就可以添加进结果里面。
// 这道题也可以用trie树做。
//
public class ConcatenatedWords {
	public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> res = new ArrayList<>();
        if (words == null || words.length == 0) return res;
        
        // sort words based on their length
        Arrays.sort(words, (a,b)->(a.length() - b.length()));
        Set<String> preWords = new HashSet<>();
        for(int i = 0; i < words.length; i++) {
            if (canForm(words[i], preWords)) {
                res.add(words[i]);
            }
            preWords.add(words[i]);
        }
        return res;
    }
    
    boolean canForm(String word, Set<String> dict) {
        if (dict.size() == 0) return false;
        boolean[] dp = new boolean[word.length()+1];
        dp[0] = true;
        
        for(int i = 1; i <= word.length(); i++) {
            for(int j = 0; j < i; j++) {
                if (!dp[j]) continue;
                if (dict.contains(word.substring(j,i))) {
                    dp[i] = true;
                    break;
                }   
            }
        }
        return dp[word.length()];
    } 
    
    public static void main(String[] args) {
    	String[] words = {"cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"};
    	List<String> res = new ConcatenatedWords().findAllConcatenatedWordsInADict(words);
    	return;	
    }
}
