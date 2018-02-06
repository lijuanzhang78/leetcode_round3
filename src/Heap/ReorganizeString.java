package Heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

// 每次需要把prev重新加入到heap的时候，要重置prev为null
// S = "aab"
// before iteration 1, prev = null, q = {a=2,b=1}, sb = ""
// iteration 1: choose a, append a to stringbuilder, "lock" a in prev, as prev = null,
// we don't need to add prev back to the priorityqueue
// before iteration 2, prev = a, q = {b=1}, sb = "a"
// iteration 2: choose b, append b to stringbuilder, add prev(=a) to the priorityqueue, 
// as it can released, as we only keep remaining element, prev is still point to a without 
// reseting to null
// before iteration 3, prev = a, q = {a=1}, sb = "ab"
//
public class ReorganizeString {
	public String reorganizeString(String S) {
        if (S == null || S.length() == 0) return "";
        Map<Character,Integer> map = new HashMap<>();
        for(int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (!map.containsKey(c)) map.put(c,0);
            map.put(c,map.get(c)+1);
        }
        
        Queue<Map.Entry<Character,Integer>> q = new PriorityQueue<>((a,b)->(b.getValue()-a.getValue()));
        for(Map.Entry<Character,Integer> entry : map.entrySet()) {
            q.offer(entry);
        }
        
        StringBuilder sb = new StringBuilder();
        Map.Entry<Character,Integer> prev = null;
        while(q.size() > 0) {
            Map.Entry<Character,Integer> front = q.poll();
            sb.append(front.getKey());
            front.setValue(front.getValue()-1);
            
            if (prev != null) {
                q.offer(prev);
                prev = null; // this line is important
            }
            if (front.getValue() > 0) {
                prev = front;
            }    
        }
        return sb.length() == S.length()? sb.toString() : "";
    }
	
	
	// this version is better at dealing with prev
	// if prev.getValue() == 0, we still add this back to the priorityqueue
	// but if when we poll the first element at the priorityqueue, and front.getValue() == 0
	// we need to break the loop, which means we don't have element available.
	
	public static void main(String[] args) {
		String S = "aab";
		String res = new ReorganizeString().reorganizeString(S);
		return;	
	}

}
