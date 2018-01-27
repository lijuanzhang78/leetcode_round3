package Trie;

import java.util.Arrays;
import java.util.List;

public class ReplaceWords {
	class TrieNode {
        TrieNode[] children;
        boolean isWord;
        String word;
        public TrieNode() {
            children = new TrieNode[26];
            isWord = false;
            word = null;
        }
    }
    
    TrieNode root = new TrieNode();
    
    public String replaceWords(List<String> dict, String sentence) {
        if (dict == null || dict.size() == 0) return sentence;
        for(String word : dict) {
            char[] arr = word.toCharArray();
            TrieNode curr = root;
            for(int i = 0; i < arr.length; i++) {
                if (curr.children[arr[i]-'a'] == null) {
                    curr.children[arr[i]-'a'] = new TrieNode();
                }
                curr = curr.children[arr[i]-'a'];
            }
            curr.isWord = true;
            curr.word = word;
        }
        
        StringBuilder sb = new StringBuilder();
        String[] sentences = sentence.split(" ");
        for(String s : sentences) {
            getRoot(s,sb);
        }
        return sb.toString();
    }
    
    void getRoot(String s, StringBuilder sb) {
        char[] arr = s.toCharArray();
        TrieNode curr = root;
        for(int i = 0; i < arr.length; i++) {
            if (curr.children[arr[i]-'a'] == null) {
                sb.append(s + " ");
                return;
            }
            
            if (curr.isWord) {
                sb.append(curr.word);
                break;
            }
            curr = curr.children[arr[i]-'a'];
        }
    }  
    
    public static void main(String[] args) {
    	String[] arr = {"cat", "bat", "rat"};
    	String sentence = "the cattle was rattled by the battery";
    	List<String> dict = Arrays.asList(arr);
    	String res = new ReplaceWords().replaceWords(dict, sentence);
    }

}
