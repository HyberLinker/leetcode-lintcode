package pers.james.linkedlist_array;

/**
 * 707. Design Linked List
 * medium
 * @author JamesLiu
 * @date 2022年03月15日 21:59:00
 */
public class DesignLinkedList {
    /**
     * 为什么要使用dummyHead
     * 难点在对头结点的处理上,因为对头结点进行的操作步骤与普通节点不同,插入与删除操作中,目标为普通节点找到其前驱就可以了。
     * 但是头结点没有前驱节点,所以在插入跟删除时就需要对头结点与普通节点分开操作,这样就增加了操作的复杂性。
     * 我们应该找到一个普遍的方法可以同时处理头结点与普通节点就可以了。
     * 答案就是创建一个虚拟节点,当做头结点来使用,这用实际的头结点就成了第二的节点,这样我们在操作时就可以一起操作了,头结点的前驱就是刚刚创建的虚拟节点
     *
     * 作者：xiao-bei-2m
     * 链接：https://leetcode-cn.com/problems/design-linked-list/solution/java-xu-ni-jie-dian-si-lu-xiang-jie-by-x-gykm/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * 1. 删除和新增当前位置，要从pre位置考虑
     * 2. 增加dummyHead，不用把头节点单独拎出来的情况考虑了
     */
    static class MyLinkedList{
        private int size;
        private ListNode dummyHead;
        public MyLinkedList() {
            this.dummyHead = new ListNode(-1);
            this.size = 0;
        }

        public int get(int index) {
            if (index < 0 || index >= size) {
                return -1;
            }
            ListNode pre = dummyHead;
            while (index > 0) {
                pre = pre.next;
                index--;
            }
            return pre.next.val;
        }

        public void addAtHead(int val) {
            addAtIndex(0, val);
        }

        public void addAtTail(int val) {
            addAtIndex(size, val);
        }

        public void addAtIndex(int index, int val) {
            if (index > size) {
                //如果 index 大于链表长度，则不会插入节点
                return;
            }

            ListNode pre = dummyHead;
            while (index > 0) {
                pre = pre.next;
                index--;
            }
            ListNode next = pre.next;
            pre.next = new ListNode(val);
            pre.next.next = next;
            size++;
        }

        public void deleteAtIndex(int index) {
            if (index < 0 || index >= size) {
                return;
            }
            ListNode pre = dummyHead;
            while (index > 0) {
                pre = pre.next;
                index--;
            }
            ListNode next = pre.next.next;
            pre.next = next;
            size--;
        }
    }

    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addAtHead(1);
        myLinkedList.addAtTail(3);
        myLinkedList.addAtIndex(1, 2);    // linked list becomes 1->2->3
        myLinkedList.get(1);              // return 2
        myLinkedList.deleteAtIndex(1);    // now the linked list is 1->3
        myLinkedList.get(1);              // return 3
    }
}
