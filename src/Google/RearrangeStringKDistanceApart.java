package Google;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class RearrangeStringKDistanceApart {
	public String rearrangeString(String s, int k) {
        if (s == null || s.length() == 0) return "";
        if (k == 0) return s; // 错误
        Map<Character,Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!map.containsKey(c)) {
                map.put(c,0);
            }
            map.put(c,map.get(c)+1);
        }
        Queue<Map.Entry<Character,Integer>> pq = new PriorityQueue<>((a,b)->(b.getValue()-a.getValue()));
        for(Map.Entry<Character,Integer> entry : map.entrySet()) {
            pq.offer(entry);
        }
        Queue<Map.Entry<Character,Integer>> lockq = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        while(sb.length() < s.length()) {
            if (pq.size() > 0) {
                Map.Entry<Character,Integer> front = pq.poll();
                front.setValue(front.getValue()-1);
                sb.append(front.getKey());
                if(front.getValue() >= 0) lockq.offer(front);
                while(lockq.size() >= k) { // 错误
                    Map.Entry<Character,Integer> first = lockq.poll();
                    if (first.getValue() > 0) {
                        pq.offer(first);
                    }
                } 
            } else {
                return "";
            }
        }
        return sb.toString();                                                                                                        
    }
	
	public static void main(String[] args) {
		String s = "aabbcc";
		int k = 3;
		String res = new RearrangeStringKDistanceApart().rearrangeString(s, k);
		return;
	}

}
