package pers.james.linkedlist_array;

import java.util.HashMap;
import java.util.Map;

public class Copy_List_with_Random_Pointer {
    // Version1
    // 用hashmap，创建老节点到新节点的映射
    public RandomListNode copyRandomList(RandomListNode head) {
        Map<RandomListNode, RandomListNode> mapping = new HashMap<>();
        RandomListNode newNode, pre_newNode;
        RandomListNode dummy = new RandomListNode(0);
        pre_newNode = dummy;
        while (head != null){
            // 1.根据映射创建新node
            if (mapping.containsKey(head)){
                newNode = mapping.get(head);

            }else {
                newNode = new RandomListNode(head.label);
                mapping.put(head, newNode);
            }
            // 2. 每次把新的node，previous和current连接起来
            pre_newNode.next = newNode;

            // 3. 添加新node的random
            RandomListNode newRandom = null;
            if (head.random != null){
                 if (mapping.containsKey(head.random)){
                     newRandom = mapping.get(head.random);
                 }else {
                     newRandom = new RandomListNode(head.random.label);
                     mapping.put(head.random, newRandom);
                 }
            }

            newNode.random = newRandom;
            // 4. 两条linkedList，都各自向后移动一个node，从而开始下一次循环
            head = head.next;
            pre_newNode = newNode;
        }
        return dummy.next;
    }

    //Version2
    //空间复杂度是constant time/O(1)/no extra space
    public RandomListNode copyRandomList1(RandomListNode head) {
        if (head == null) return null;
        copyNodes(head);
        copyRandoms(head);
        return splitLinkedList(head);
    }

    private RandomListNode splitLinkedList(RandomListNode head) {
        RandomListNode newNode = head.next;
        while (head != null && head.next != null){
            RandomListNode temp = head.next;
            head.next = head.next.next;
            head = temp;
        }
        return newNode;
    }

    private void copyRandoms(RandomListNode head) {
        while (head != null){
            if (head.random != null){
                head.next.random = head.random.next;
            }
            head = head.next.next;
        }
    }

    private void copyNodes(RandomListNode head) {
        while (head != null){
            RandomListNode newNode = new RandomListNode(head.label);
//            RandomListNode temp = head.next;
//            head.next = newNode;
//            newNode.next = temp;
//            head = temp;
            newNode.next = head.next;
            head.next = newNode;
            head = head.next.next;
        }
    }
}
