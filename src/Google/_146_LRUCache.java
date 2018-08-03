package Google;

public class _146_LRUCache {
	class LRUCache {
	    class ListNode {
	        int val,key;
	        ListNode next,prev;
	        ListNode(int key,int val) {
	            this.key = key; 
	            this.val = val;
	            next = null;
	            prev = null;
	        }
	    }
	    ListNode head = new ListNode(0,0); // dummy head
	    ListNode end = new ListNode(0,0); // dummy end
	    int max;
	    
	    Map<Integer,ListNode> map = new HashMap<>(); // map supports quick lookup; list supports quick delete/insert

	    public LRUCache(int capacity) {
	        this.max = capacity;
	        head.next = end;
	        end.prev = head;
	    }
	    
	    public int get(int key) {
	        if (!map.containsKey(key)) return -1;
	        ListNode node = map.get(key);
	        int res = node.val;
	        
	        // delete the node
	        ListNode prev = node.prev;
	        ListNode next = node.next;
	        prev.next = next;
	        next.prev = prev;
	        
	        next = head.next;
	        node.next = next;
	        next.prev = node;
	        node.prev = head;
	        head.next = node;
	        return res;
	    }
	    
	    public void put(int key, int value) {
	        if (!map.containsKey(key)) {
	            if (map.size() == max) {
	                // delte the last one
	            
	                ListNode tail = end.prev;
	                map.remove(tail.key); // delete the end node entry
	                tail.prev.next = end;
	                end.prev = tail.prev;
	            }
	        } else {
	            // delete the old key-value pair
	            ListNode node = map.get(key);
	            node.prev.next = node.next;
	            node.next.prev = node.prev;
	        }
	        
	        // add to the front
	        ListNode newnode = new ListNode(key,value);
	        map.put(key,newnode);
	        ListNode next = head.next;
	        head.next = newnode;
	        newnode.prev = head;
	        newnode.next = next;
	        next.prev = newnode;
	    }
	}

}
