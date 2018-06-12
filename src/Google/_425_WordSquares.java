package Google;

import java.util.ArrayList;
import java.util.List;

public class _425_WordSquares {
	TrieNode root;
    class TrieNode {
        TrieNode[] children;
        boolean isWord;
        TrieNode() {
            children = new TrieNode[26];
            isWord = false;
        }
    }
    
    public void buildTrie(String[] words) {
        for(String w : words) {
            TrieNode curr = root;
            for(int i = 0; i < w.length(); i++) {
                char c = w.charAt(i);
                if (curr.children[c-'a'] == null) {
                    curr.children[c-'a'] = new TrieNode();
                }
                curr = curr.children[c-'a'];
            }
            curr.isWord = true;
        }
    }
    
    public List<List<String>> wordSquares(String[] words) {
        if (words == null || words.length == 0) return new ArrayList<List<String>>();
        //root = new TrieNode();
        //buildTrie(words);
        boolean[] visited = new boolean[words.length];
        int length = words[0].length();
        List<List<String>> res = new ArrayList<>();
        dfs(res,words,visited,new ArrayList<String>(),0, length);
        return res;
    }
    
    void dfs(List<List<String>> res, String[] words, boolean[] visited, List<String> list, int pos, int length) {
        if (pos == length) {
            res.add(new ArrayList<String>(list));
            return;
        }
        
        for(int i = 0; i < words.length; i++) {
            //if (visited[i]) continue;
            if (pos == 0 || isValid(words[i], list)) {
                list.add(words[i]);
                visited[i] = true;
                dfs(res,words,visited,list,pos+1,length);
                visited[i] = false;
                list.remove(list.size()-1);
            } 
        }
    }
    
    boolean isValid(String w, List<String> list) {
        for(int i = 0; i < list.size(); i++) {
            if (list.get(i).charAt(list.size()) != w.charAt(i)) return false;
        }
        return true;
    }
    
    public static void main(String[] args) {
    	String[] words = {"abat","baba","atan","atal"};
    	List<List<String>> res = new _425_WordSquares().wordSquares(words);
    	return;
    }
}
