package Google;

public class _425_WordSquares_Trie {
	TrieNode root;
    class TrieNode {
        TrieNode[] children;
        boolean isWord;
        List<String> prefix;
        TrieNode() {
            children = new TrieNode[26];
            isWord = false;
            prefix = new ArrayList<>();
        }
    }
    
    public void buildTrie(String[] words) {
        for(String w : words) {
            TrieNode curr = root;
            for(int i = 0; i < w.length(); i++) {
                curr.prefix.add(w);
                char c = w.charAt(i);
                if (curr.children[c-'a'] == null) {
                    curr.children[c-'a'] = new TrieNode();
                }
                curr = curr.children[c-'a'];
            }
            curr.isWord = true;
            curr.prefix.add(w);
        }
    }
    
    List<String> hasPrefix(String prefix) {
        TrieNode curr = root;
        for(int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (curr.children[c-'a'] == null) {
                return new ArrayList<String>();
            }
            curr = curr.children[c-'a'];
        }
        return curr.prefix;
    }
    
    public List<List<String>> wordSquares(String[] words) {
        if (words == null || words.length == 0) return new ArrayList<List<String>>();
        root = new TrieNode();
        buildTrie(words);
        int length = words[0].length();
        List<List<String>> res = new ArrayList<>();
        dfs(res,words,new ArrayList<String>(),0, length);
        return res;
    }
    
    void dfs(List<List<String>> res, String[] words, List<String> list, int pos, int length) {
        if (pos == length) {
            res.add(new ArrayList<String>(list));
            return;
        }
        
        StringBuilder prefix = new StringBuilder();
        for(int i = 0; i < list.size(); i++) {
            prefix.append(list.get(i).charAt(pos));
        }
        
        for(String candidate : hasPrefix(prefix.toString())) {
            list.add(candidate);
            dfs(res,words,list,pos+1,length);
            list.remove(list.size()-1);
        }
    }
    
    boolean isValid(String w, List<String> list) {
        for(int i = 0; i < list.size(); i++) {
            if (list.get(i).charAt(list.size()) != w.charAt(i)) return false;
        }
        return true;
    }

}
