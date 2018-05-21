package Amazon;

public class _141_LinkedListCycle {
	public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        ListNode runner = head.next;
        ListNode walker = head;
        while(runner!= null && runner.next!= null) {
            if (runner == walker) return true;
            walker = walker.next;
            runner = runner.next.next;
        }
        return false;   
    }

}
