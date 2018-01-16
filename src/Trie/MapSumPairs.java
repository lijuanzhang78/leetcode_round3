package Trie;

public class MapSumPairs {
	 /** Initialize your data structure here. */
    public MapSum() {
        root = new TrieNode();
    }
    
    public void insert(String key, int val) {
        TrieNode curr = root;
        for(int i = 0; i < key.length(); i++) {
            char c = key.charAt(i);
            if (curr.children[c-'a'] == null) {
                curr.children[c-'a'] = new TrieNode();
            }
            curr = curr.children[c-'a'];
        }
        curr.isWord = true;
        curr.value = val;
    }
    
    public int sum(String prefix) {
        int sum = 0;
        if (prefix == "") return 0;
        
        TrieNode ptr = getPtr(prefix);
        if (ptr == null) return 0;  // no prefix found in the trie tree
        if (ptr.isWord) sum += ptr.value;
        for(int i = 0; i < 26; i++) {
            if (ptr.children[i] != null) {
                sum += helper(ptr.children[i]);
            }
        }
        return sum;
    }
    
    int helper(TrieNode curr) {
        int sum = 0;
        if (curr.isWord) sum += curr.value;
        for(int i = 0; i < 26; i++) {
            if (curr.children[i] != null) {
                sum += helper(curr.children[i]);
            }
        }
        return sum;
    }
    
    TrieNode getPtr(String prefix) {
        TrieNode curr = root;
        for(int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (curr.children[c-'a'] == null) return null;
            curr = curr.children[c-'a'];
        }
        return curr; // now point to the object of the last char of prefix
    }
    
    TrieNode root;
    
    class TrieNode {
        TrieNode[] children;
        boolean isWord;
        int value;
        TrieNode() {
            children = new TrieNode[26];
            isWord = false;
            value = 0;
        }
    }

}
