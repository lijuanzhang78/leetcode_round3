package Google_Others;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
class Node{
	int key;
	int val;
	long expiration;
	Node(int key, int val, long expiration) {
		this.key = key;
		this.val = val;
		this.expiration = expiration;
	}
}

public class HashMapWithExpiration {
	class Node{
		int key;
		int val;
		long expiration;
		Node(int key, int val, long expiration) {
			this.key = key;
			this.val = val;
			this.expiration = expiration;
		}
	}
	
	Map<Integer, Node> map = new HashMap<>();
	//Queue<Node> q = new PriorityQueue<>((a,b)->(a.expiration - b.expiration));
	Queue<Node> q = new PriorityQueue<Node>( new Comparator<Node>() {
		public int compare(Node a, Node b) {
			if (a.expiration - b.expiration > (long)0) {
				return 1;
			} else {
				return -1;
			}
			
		}		
	});

	int get(int key) {
		if (!map.containsKey(key)) return -1;
		Node node = map.get(key);
		if (node.expiration >= System.currentTimeMillis()) {
			return node.val;
		} else {
			map.remove(key);
			return -1;
		}
	}
	
	void put(int key, int val) {
		if (map.containsKey(key)) return;
		long currtime = System.currentTimeMillis();
		Node node = new Node(key,val,currtime);
		map.put(key,node);
		q.offer(node);
	}
	
	void cleanup(){
		long currtime = System.currentTimeMillis();
		while(q.size() > 0) {
			if (q.peek().expiration <= currtime) {
				q.poll();
			} else {
				break;
			}	
		}
	}
	

}
