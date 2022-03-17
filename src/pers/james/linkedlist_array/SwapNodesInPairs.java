package pers.james.linkedlist_array;

/**
 * 24. Swap Nodes in Pairs
 * medium
 * @author JamesLiu
 * @date 2022年03月17日 21:44:00
 */
public class SwapNodesInPairs {
    /**
     * 思路比较清晰
     * 1. 两个node处理
     * 2. 两个node为一个整体，需要记忆两个node的前一个pre，和后一个next
     * 3. 从左到右变动指针即可
     * 4. 注意循环处indexNode.next.next != null，避免second.next出现空指针。比如[1]
     * @param head
     * @return
     */
    public static ListNode swapPairs(ListNode head) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode indexNode = dummyHead;
        while (indexNode.next != null && indexNode.next.next != null) {
            ListNode second = indexNode.next.next;
            ListNode first = indexNode.next;
            ListNode next = second.next;
            indexNode.next = second;
            second.next = first;
            first.next = next;
            indexNode = first;
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        int[] nums = {1};
        ListNode head = buildNodeList(nums);
        ListNode node = swapPairs(head);
        printNodeList(node);
    }

    /**
     * 通过数组构造ListNode
     * @param head
     * @return
     */
    private static ListNode buildNodeList(int[] head) {
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

    /**
     * 打印链表数值
     * @param head
     */
    private static void printNodeList(ListNode head) {
        StringBuilder builder = new StringBuilder();
        while (head != null) {
            builder.append(head.val).append(",");
            head = head.next;
        }
        System.out.println(builder.toString());
    }
}
