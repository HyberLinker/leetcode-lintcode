package pers.james.linkedlist_array;

/**
 * 203. Remove Linked List Elements
 * easy
 * 考察链表元素的删除
 *
 * @author JamesLiu
 * @date 2022年03月13日 19:10:00
 */
public class RemoveLinkedListElements {
    /**
     * 可以使用dummyHead，来避免第一个节点的情况需要拿出来单独处理
     * @param head
     * @param val
     * @return
     */
    public static ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        while (cur != null && cur.next != null) {//cur有可能是null。由于最后一个可能是要被删除的数，所以cur.next直接指向null，然后cur=cur.next
            System.out.printf("cur:[%d], next:[%d]\n", cur.val, cur.next.val);
            if (cur.next.val == val) {
                cur.next = cur.next.next;
            }
            cur = cur.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        int[] head = {1,2,6,3,4,5,6};
        ListNode dummyEnd = new ListNode(0);
        ListNode trueEnd = null;
        for (int i = head.length - 1; i >= 0 ; i--) {
            ListNode node = new ListNode(head[i]);
            if (i == head.length - 1) {
                trueEnd = node;
            }
            node.next = dummyEnd;
            dummyEnd = node;
        }
        trueEnd.next = null;

        removeElements(dummyEnd, 6);

    }

    private ListNode buildNodeList(int[] head) {
        ListNode dummyEnd = new ListNode(0);
        ListNode trueEnd = null;
        for (int i = head.length - 1; i >= 0 ; i--) {
            ListNode node = new ListNode(head[i]);
            if (i == head.length - 1) {
                trueEnd = node;
            }
            node.next = dummyEnd;
            dummyEnd = node;
        }
        trueEnd.next = null;
        return dummyEnd;
    }
}
