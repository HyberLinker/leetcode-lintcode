package pers.james.linkedlist_array;

public class LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;
        ListNode slow = head, fast = head.next;
        while (slow != fast){
            if (fast == null || fast.next == null) return null;
            slow = slow.next;
            fast = fast.next.next;
        }
        fast = head;
        slow = slow.next;
        while (slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }
}
