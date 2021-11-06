package pers.james.linkedlist_array;

public class Linked_List_Cycle {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode slow = head, fast = head.next;
        while(slow != fast){
            if (fast == null || slow == null || fast.next == null){
                return false;
            }else{
                slow = slow.next;
                fast = fast.next.next;
            }
        }
        return true;
    }
}
