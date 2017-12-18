package BFS;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class WordLadder {
	public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        if (wordList == null || wordList.size() == 0) return 0;
        Queue<String> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        q.offer(beginWord);
        visited.add(beginWord);
        
        int level = 0;
        while(q.size() > 0) {
            int size = q.size();
            for(int isize = 0; isize < size; isize++) {
                String curr = q.poll();
                if (curr.equals(endWord)) return level;
                for(int i = 0; i < curr.length(); i++) {
                    char[] arr = curr.toCharArray();
                    for(char c = 'a'; c <= 'z'; c++) {
                        arr[i] = c;
                        String newS = new String(arr);
                        if (!newS.equals(curr) && wordList.contains(newS) && !visited.contains(newS)) {
                            q.offer(newS);
                            visited.add(newS);
                        }
                    }
                }
            }
            level++;
        }
        return 0;    
    }

	public static void main(String[] args) {
		String begin = "hit", end = "cog";
		Set<String> set = new HashSet<>();
		set.add("hot");
		set.add("dot");
		set.add("dog");
		set.add("lot");
		set.add("log");
		set.add("cog");
		int res = new WordLadder().ladderLength(begin, end, set);
		return;
	}
}
