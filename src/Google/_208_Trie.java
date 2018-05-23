package Google;

public class _208_Trie {
	TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        if (word == null || word.length() == 0) return;
        TrieNode curr = root;
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (curr.children[c-'a'] == null) {
                curr.children[c-'a'] = new TrieNode();
            }
            curr = curr.children[c-'a'];
        }
        curr.isWord = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode curr = root;
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (curr.children[c-'a'] == null) {
                return false;
            } else {
                curr = curr.children[c-'a'];
            }
        }
        return curr.isWord;      
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for(int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (curr.children[c-'a'] == null) {
                return false;
            } else {
                curr = curr.children[c-'a'];
            }
        }
        return true;   
    }
}

class TrieNode {
    TrieNode[] children;
    boolean isWord;
    TrieNode() {
        children = new TrieNode[26];
        isWord = false;
    }

}
