package Amazon;

public class _138_CopyListWithRandomPointer {
	public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) return null;
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode orig = head;
        RandomListNode dummy = new RandomListNode(0);
        RandomListNode prev = dummy;
        
        while(orig != null) {
            if (!map.containsKey(orig)) {
                RandomListNode newnode = new RandomListNode(orig.label);
                prev.next = newnode;
                map.put(orig,newnode);
            } else {
                prev.next = map.get(orig);
            }
            
            if (orig.random != null) {
                if (!map.containsKey(orig.random)) {
                    RandomListNode newrandomnode = new RandomListNode(orig.random.label);
                    map.get(orig).random = newrandomnode;
                    map.put(orig.random,newrandomnode);
                } else {
                    map.get(orig).random = map.get(orig.random);
                }
            }
            prev = prev.next;
            orig = orig.next;
        }
        return dummy.next;    
    }

}
