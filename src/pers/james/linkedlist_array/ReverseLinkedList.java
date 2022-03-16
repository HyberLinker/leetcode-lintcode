package pers.james.linkedlist_array;

import java.util.ArrayList;
import java.util.List;

/**
 * 206. Reverse Linked List
 * easy
 * @author JamesLiu
 * @date 2022年03月16日 21:47:00
 */
public class ReverseLinkedList {
    /**
     * 迭代
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        List<Integer> vals = new ArrayList<>();
        while (head != null) {
            vals.add(head.val);
            head = head.next;
        }
        ListNode dummyEnd = null;
        for (int i = 0; i < vals.size(); i++) {
            ListNode node = new ListNode(vals.get(i));
            node.next = dummyEnd;
            dummyEnd = node;
        }
        return dummyEnd;
    }

    /**
     * 递归
     * @param head
     * @return
     */
    public ListNode reverseList1(ListNode head) {
        List<Integer> vals = new ArrayList<>();
        ListNode node = head;
        while (node != null) {
            vals.add(node.val);
            node = node.next;
        }
        if (vals.size() == 0) {
            return head;
        }
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = recursive(vals, vals.size() - 1);
        return dummyHead.next;
    }

    private ListNode recursive(List<Integer> vals, int index) {
        ListNode node = new ListNode(vals.get(index));
        if (index == 0) {
            return node;
        }
        node.next = recursive(vals, --index);
        return node;
    }

    /**
     * leetcode 之前的递归答案
     * 空间复杂度是O1
     * @param head
     * @return
     */
    public ListNode reverseList3(ListNode head) {
        if (head == null || head.next == null) return head; //head.next == null就行了，head==null是怎么考虑的？原来是考虑head本身第一个就是null，醉了
        ListNode tail = reverseList3(head.next);
        head.next.next = head;
        head.next = null;
        return tail;
    }

    /**
     * leetcode 之前的迭代答案
     * 空间复杂度是O1
     * @param head
     * @return
     */
    public ListNode reverseList4(ListNode head) {
        ListNode prev = null, curr = head, next = null;
        while (curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
