package Google;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;


	class LFUCache {
	    class ListQueue {
	        ListQueue prev, next;
	        LinkedHashSet<Integer> list;
	        ListQueue() {
	            list = new LinkedHashSet<Integer>();
	            prev = null;
	            next = null;
	        }   
	    }
	    
	    ListQueue head = new ListQueue(); // dummy head
	    ListQueue end = new ListQueue(); // dummy end
	    
	    int max;
	    Map<Integer,Integer> vals = new HashMap<>();
	    Map<Integer,Integer> counts = new HashMap<>();
	    Map<Integer,ListQueue> nodes = new HashMap<>();

	    public LFUCache(int capacity) {
	        this.max = capacity;
	        head.next = end;
	        end.prev = head;
	    }
	    
	    // (1) remove from orig // (2) add to bigger q, if there is not bigger q, create it (3) increase count
	    public int get(int key) {
	        if (!vals.containsKey(key)) return -1;
	        int count = counts.get(key);
	        counts.put(key,count+1);
	        
	        ListQueue orig = nodes.get(key);
	        
	        // add one node behind orig node
	        if (!nodes.containsKey(count+1)) {
	            addNode(orig, count+1);
	        } 
	        ListQueue q = nodes.get(count+1);
	        q.list.add(key);
	        
	        orig.list.remove(key);
	        if (orig.list.size() == 0) {
	            orig.prev.next = orig.next;
	            orig.next.prev = orig.prev;
	        }
	        return vals.get(key);    
	    }
	    
	    // add node after original node
	    private void addNode(ListQueue orig, int count) {
	        ListQueue q = new ListQueue();
	        nodes.put(count,q);
	        ListQueue next = orig.next;
	        orig.next = q;
	        q.prev = orig;
	        q.next = next;
	        next.prev = q;    
	    }
	    
	    public void put(int key, int value) {
	        if (!vals.containsKey(key)) {
	            if (vals.size() == max) {
	                ListQueue last = head.next;
	                int lastkey = last.list.iterator().next();
	                vals.remove(lastkey); counts.remove(lastkey);
	                last.list.remove(lastkey);
	                if (last.list.size() == 0) {
	                    last.prev.next = last.next;
	                    last.next.prev = last.prev;
	           
	                }
	            }
	            vals.put(key,value);
	            counts.put(key,1);
	            if (!nodes.containsKey(1)) {
	                addNode(head,1);
	            }
	            nodes.get(1).list.add(key);    
	        } else {
	            get(key);
	            vals.put(key,value);
	        }
	    }
	
	public static void main(String[] args) {
		LFUCache lfu = new LFUCache(2);
		
		lfu.put(1,1);
		lfu.put(2,2);
		int res = lfu.get(1);
		lfu.put(3,3);
		res = lfu.get(2);
		res = lfu.get(3);
		lfu.put(4,4);
		lfu.get(1);
		lfu.get(3);
		lfu.get(4);
			
	}

}
