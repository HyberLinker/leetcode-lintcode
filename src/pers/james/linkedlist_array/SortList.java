package pers.james.linkedlist_array;

public class SortList {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode mid = findMid(head);
//        ListNode temp = mid.next;
//        mid.next = null;
//        ListNode left = sortList(head);
//        ListNode right = sortList(temp);
        ListNode right = sortList(mid.next);
        mid.next = null;
        ListNode left = sortList(head);
        return merge(left, right);
    }

    private ListNode merge(ListNode left, ListNode right) {
        ListNode dummy = new ListNode(0);
        ListNode pre = dummy;
        while (left != null && right != null){
            if (left.val < right.val){
                pre.next = left;
                left = left.next;
            }else {
                pre.next = right;
                right = right.next;
            }
            pre = pre.next;
        }

        if (left != null) pre.next = left;
        if (right != null) pre.next = right;
        return dummy.next;
    }

    private ListNode findMid(ListNode head) {
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next == null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }


}
