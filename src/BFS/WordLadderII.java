package BFS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class WordLadderII {
	public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        if (wordList == null || wordList.size() == 0) return new ArrayList<>();
        Map<String, Integer> dist = new HashMap<>();
        Map<String, List<String>> parent = new HashMap<>();
        Set<String> set = new HashSet<>();
        
        for(String s : wordList) {
            set.add(s);    
        }
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        dist.put(beginWord,0);
        parent.put(beginWord,new ArrayList<>());
        
        boolean found = false;
        int level = 0;
        while(q.size() > 0) {
            if(found) break;
            int size = q.size();
            for(int isize = 0; isize < size; isize++) {
                String curr = q.poll();
                for(int i = 0; i < curr.length(); i++) {
                    char[] arr = curr.toCharArray();
                    for(char c = 'a'; c <= 'z'; c++) {
                        arr[i] = c;
                        String newS = new String(arr);
                        if (newS.equals(curr) || !set.contains(newS)) continue;
                        if (!dist.containsKey(newS)) {
                            dist.put(newS,level+1);
                            parent.put(newS,new ArrayList<String>());
                            parent.get(newS).add(curr);
                            q.offer(newS);
                            if (newS.equals(endWord)) {
                                found = true;
                            }
                        } else {
                            if (dist.get(curr)+1 <= dist.get(newS)) {
                                parent.get(newS).add(curr);
                            }    
                        }    
                    }
                }
            }
            level++;
        }
        if (!found) return new ArrayList<List<String>>();
        
        List<List<String>> res = new ArrayList<List<String>>();
        List<String> temp = new ArrayList<>();
        temp.add(endWord);
        output(res,parent,endWord,temp);
        return res;
    } 
    
    void output(List<List<String>> res, Map<String,List<String>> parent, String source, List<String> temp) {
        if (parent.get(source).size() == 0) { // beginWord
            res.add(new ArrayList<String>(temp));
            return;
        }
        
        for(String p : parent.get(source)) {
            temp.add(0,p);
            output(res,parent,p,temp);
            temp.remove(0);
        }
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
