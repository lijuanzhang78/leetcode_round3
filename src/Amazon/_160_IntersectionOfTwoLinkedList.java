package Amazon;

public class _160_IntersectionOfTwoLinkedList {
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        int lenA = getLen(headA), lenB = getLen(headB);
        if (lenA <= lenB) {
            return helper(headA,headB,lenB-lenA);
        } else {
            return helper(headB,headA,lenA-lenB);
        }
    }
    
    ListNode helper(ListNode small, ListNode large, int diff) {
        while(diff > 0) {
            large = large.next;
            diff--;
        }
        
        while(small != null && large != null) {
            if (small == large) return small;
            small = small.next;
            large = large.next;
        }
        return null;    
    }
    
    int getLen(ListNode head) {
        int res = 0;
        while(head != null) {
            res++;
            head = head.next;
        }
        return res;
    }

}
