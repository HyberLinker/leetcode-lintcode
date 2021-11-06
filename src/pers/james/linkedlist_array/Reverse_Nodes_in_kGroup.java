package pers.james.linkedlist_array;

public class Reverse_Nodes_in_kGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        while (prev != null){
            prev = reverseNextKNodes(prev, k);
        }
        return dummy.next;
    }
    //prev, n1, n2, ..., nk, nk+1
    //prev, nk,..,n2, n1, nk+1
    private ListNode reverseNextKNodes(ListNode head, int k) {
        ListNode curt = head;
        ListNode n1 = head.next;
        for (int i = 0; i < k; i++) {
            curt = curt.next;
            if (curt == null) return null;
        }

        ListNode nk = curt;
        ListNode nk_1 = curt.next;

        //reverse
        curt = head.next;
        ListNode prev = head;
        while (curt != nk_1){
            ListNode temp = curt.next;
            curt.next = prev;
            prev = curt;
            curt = temp;
        }
        // prev<=>n1
        // n1<-n2...<-nk
        // nk+1
        head.next = nk;
        n1.next = nk_1;

        // prev->nk->...n2->n1->nk+1
        //下一个点从n+1开始，所以return它前一个点，即n1
        return n1;
    }
}
