package pers.james.linkedlist_array;

/**
 * 19. Remove Nth Node From End of List
 * medium
 * @author JamesLiu
 * @date 2022年03月19日 16:26:00
 */
public class RemoveNthNodeFromEndOfList {
    /**
     * 思路比较清晰
     * 1. 计算链表长度size
     * 2. 倒数第n个数，就需要遍历到倒数n+1个数
     * 3. 使用dummyHead，所以移动到倒数n+1个数，需要移动 size - n次 即可
     * 时间复杂度O1
     * 但是不是一遍遍历，最坏情况是遍历两次
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode cur = head;
        int size = 0;
        while (cur != null) {
            cur = cur.next;
            size++;
        }
        cur = dummyHead;
        int iterNo = size - n;
        for (; iterNo > 0 ; iterNo--) {
            cur = cur.next;
        }
        cur.next = cur.next.next;
        return dummyHead.next;
    }

    /**
     * 进阶：只需要遍历一次。
     * 双指针
     * 双指针的经典应用，如果要删除倒数第n个节点，让fast移动n步，然后让fast和slow同时移动，直到fast指向链表末尾。
     * 删掉slow所指向的节点就可以了。
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd1(ListNode head, int n) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode slow = dummyHead;
        ListNode fast = dummyHead;
        while (n > 0) { //1 <= n <= size 所以不需要 fast != null
            fast = fast.next;
            n--;
        }

        //当fast移动到尾部最后一个，slow刚好再需要删除node的pre
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;
        return dummyHead.next;
    }
}
