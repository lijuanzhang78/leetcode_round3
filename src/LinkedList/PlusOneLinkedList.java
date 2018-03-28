package LinkedList;

public class PlusOneLinkedList {
	public ListNode plusOne(ListNode head) {
        if (head == null) return null;
        int res = plusOneHelper(head);
        if (res == 0) return head;
        ListNode newHead = new ListNode(res);
        newHead.next = head;
        return newHead;
    }
    
    int plusOneHelper(ListNode head) {
        if (head.next == null) {
            head.val = head.val + 1;
            int res = head.val/10;
            head.val %= 10;
            return res;
        }
        
        int res = plusOneHelper(head.next);
        if (res > 0) {
            head.val = head.val + 1;
            res = head.val/10;
            head.val %= 10;
            return res;    
        }
        return 0;
    }

}
