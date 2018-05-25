package Google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _269_AlienDictionary {
	public String alienOrder(String[] words) {
        if (words == null || words.length == 0) return "";
        StringBuilder sb = new StringBuilder();
        int[] visited = new int[26];
        Arrays.fill(visited,-1); // this means the letter does not exist
        Map<Character,List<Character>> adjList = buildGraph(words,visited);
        for(int i = 0; i < 26; i++) {
            char c = (char)(i+'a');
            if (visited[c-'a'] == 0) { // not visited yet, but exist
                if(!dfs(c,adjList,visited,sb)) return "";
            }
            
        }
        return sb.reverse().toString();
    }
    
    boolean dfs(char curr, Map<Character,List<Character>> adjList, int[] visited, StringBuilder sb) {
        visited[curr-'a'] = 1;
        if (adjList.containsKey(curr)) {
            for(char adj : adjList.get(curr)) {
                if (visited[adj-'a'] == 1) return false;
                if (visited[adj-'a'] == 2) continue;
                if(!dfs(adj,adjList,visited,sb)) return false;
            }
        }
        visited[curr-'a'] = 2;
        sb.append(curr);
        return true;
    }
    
    Map<Character,List<Character>> buildGraph(String[] words, int[] visited) {
        Map<Character,List<Character>> adjList = new HashMap<>();
        for(int i = 0; i < words.length; i++) {
            for(char c : words[i].toCharArray()) {
                visited[c-'a'] = 0;
            }
            if (i == words.length-1) break;
            String w1 = words[i], w2 = words[i+1];
            for(int j = 0; j < Math.min(w1.length(),w2.length()); j++) {
                if (w1.charAt(j) != w2.charAt(j)) {
                    if (!adjList.containsKey(w1.charAt(j))) {
                        adjList.put(w1.charAt(j), new ArrayList<Character>());
                    }
                    adjList.get(w1.charAt(j)).add(w2.charAt(j));
                    break; // 错误
                }    
            }
        }
        return adjList;                
    }
    
    public static void main(String[] args) {
    	String[] words = new String[]{"za","zb","ca","cb"};
    	String res = new _269_AlienDictionary().alienOrder(words);
    	return;
    }
}
