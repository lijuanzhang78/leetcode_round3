package UnionFind;

public class _817_LinkedListComponents {
	public int numComponents(ListNode head, int[] G) {
        if (G == null || G.length == 0) return 0;
        Set<Integer> set = new HashSet<>();
        for(int g : G) {
            set.add(g);
        }
        ListNode curr = head;
        int size = G.length;
        while(curr != null && curr.next != null) {
            if (set.contains(curr.val) && set.contains(curr.next.val)) {
                size--;
            }
            curr = curr.next;
        }
        return size;
    }

}
