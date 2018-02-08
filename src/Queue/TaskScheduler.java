package Queue;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;


// priority queue + queue
// priority stores the elements in a way such that the most frequent element come first.
// queue is like a waiting list which stores elements that are not allowed to be picked.

// before iteration 0: 
// pq: A=3,B=3,   waitq: empty
// befotre iteration 1:
// pq: B=3,       waitq: A=2
// before iteration 2:
// pq: empty      waitq: A=2,B=2, at this time, we need to add "idle, but we need to insert 'null' to waitq to takes up a place
//                                at the end of each iteration, we need to check if the waitq is ready to release the head element
// before iteration 3:
// pq: A=2        waitq: B=2,null
// before iteration 4:
// pq: B=2        waitq: null,A=1, at this time, we need to add B=1 to the end of waitq, and pop the front element null,
// before iteration 5:
// pq: empty      waitq: A=1,B=1
// before iteration 6:
// pq: A=1,       waitq: B=1, null
//
public class TaskScheduler {
	public int leastInterval(char[] tasks, int n) {
        if (tasks == null || tasks.length == 0) return 0;
        Map<Character,Integer> map = new HashMap<>();
        for(char c : tasks) {
            if (!map.containsKey(c)) {
                map.put(c,0);
            }
            map.put(c,map.get(c)+1);
        }
        Queue<Map.Entry<Character,Integer>> q = new PriorityQueue<>((a,b)->(b.getValue()-a.getValue()));
        for(Map.Entry<Character,Integer> entry : map.entrySet()) {
            q.offer(entry);
        }
        Queue<Map.Entry<Character,Integer>> waitq = new LinkedList<>();
        int count = 0, total = tasks.length;
                                                                    
        while(total > 0) {
            if (q.size() > 0) {
                Map.Entry<Character,Integer> first = q.poll();
                //if (first != null) { // not necessary
                    count++; total--;
                    first.setValue(first.getValue()-1);
                    if (first.getValue() == 0) {
                        waitq.offer(null);
                    } else {
                        waitq.offer(first);
                    }
                //} 
            }else {
                count++;
                waitq.offer(null);
            }
            if (waitq.size() == n+1) { // prepare for the next round
                Map.Entry<Character,Integer> first = waitq.poll();
                if (first != null) q.offer(first);
            }    
        }    
        return count;
    }

}
