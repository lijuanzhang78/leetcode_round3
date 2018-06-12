package Google_Others;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

// key-map with expiration
//
public class Dictionary {
	class Value {
		int value;
		Timestamp expTime;
		Value(int val, Timestamp expTime) {
			this.value = val;
			this.expTime = expTime;
		}
	}
	
	Map<Integer, Value> map;
	PriorityQueue<Integer> pq;
	
	Dictionary() {
		map = new HashMap<Integer, Value>();
		pq = new PriorityQueue<Integer>((a,b)->(map.get(a).expTime.compareTo(map.get(b).expTime)));
	}
	
	public Timestamp getCurrentTime() {
		return new Timestamp(System.currentTimeMillis());
	}
	
	// key doesn't exist, return -1
	// key exists, value expired, return -1
	//             value not expired, return value
	public int get(int key) {
		if (!map.containsKey(key)) return -1;
		Value val = map.get(key);
		if (getCurrentTime().after(val.expTime)) return -1;
		return val.value;	
	}
	
	// key doesn't exist, insert 
	// key exists with different duration, update timestamp (duration+currtime)
	//
	public void insert(int key, int val, long duration) {
		long expTime = getCurrentTime().getTime() + duration;
		Value value = new Value(val,new Timestamp(expTime));
		map.put(key, value);
		if (!map.containsKey(key)) {
			pq.offer(key);
		} 
	}
	
	public void prune(Timestamp ts) {
		while(pq.size() > 0) {
			Value val = map.get(pq.peek());
			if (val.expTime.compareTo(ts) < 0) {
				int key = pq.poll();
				map.remove(key);
			} else {
				break;
			}	
		}	
	}
	
	public void testpq() {
		Map<Integer,Integer> map = new HashMap<>();
		PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->(map.get(b)-map.get(a)));
		map.put(1,100);
		map.put(2,200);
		map.put(3,300);
		pq.offer(1);pq.offer(2);pq.offer(3);
		int first = pq.peek();
		map.put(1,400);
		first = pq.peek();
		first = pq.poll();
		first = pq.peek();
	}
	
	public static void main(String[] args) {
		new Dictionary().testpq();
		return;
		
	}
}
