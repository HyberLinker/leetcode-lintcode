package pers.james.linkedlist_array;

import java.util.ArrayList;
import java.util.List;

/**
 * 160. Intersection of Two Linked Lists
 * easy
 * @author JamesLiu
 * @date 2022年03月20日 10:45:00
 */
public class IntersectionOfTwoLinkedLists {
    /**
     * 解法一
     * 时间复杂度O（m+n），空间复杂度O（m+n）
     * 1. 分别遍历两个链表，把元素val分别存在两个数组中
     * 2. 两个指针，同时从后往前遍历两个数组，当指针指向val不同时。上一个就是交点
     * 3. 因为val是可以重复的，所以记录元素index，用找倒数第几个node的方法，找到答案
     *
     * 思路大体没问题，但是理解错题意：
     * 这里同学们要注意，交点不是数值相等，而是指针相等。指的不是val，而是next
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //1. 分别遍历两个链表，把元素val分别存在两个数组中
        List<Integer> listA = new ArrayList<>();
        List<Integer> listB = new ArrayList<>();
        ListNode hA = headA;
        ListNode hB = headB;
        while (hA != null) {
            listA.add(hA.val);
            hA = hA.next;
        }
        while (hB != null) {
            listB.add(hB.val);
            hB = hB.next;
        }
        //2. 两个指针，同时从后往前遍历两个数组，当指针指向val不同时。上一个就是交点
        int indexA = listA.size() - 1;
        int indexB = listB.size() - 1;
        while (indexA >= 0 && indexB >= 0) {
            if (!listA.get(indexA).equals(listB.get(indexB))) {
                break;
            }
            indexA--;
            indexB--;
        }
        //3. 因为val是可以重复的，所以记录元素index，用找倒数第几个node的方法，找到答案
        int intersectionIndex = indexA + 1;
        if (intersectionIndex > listA.size() - 1) {
            return null;
        }
        hA = headA;
        while (intersectionIndex > 0) {
            hA = hA.next;
            intersectionIndex--;
        }
        return hA;
    }

    /**
     * 上面的变形，指针相同，而不是val相同
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        //1. 分别遍历两个链表，把元素val分别存在两个数组中
        List<ListNode> listA = new ArrayList<>();
        List<ListNode> listB = new ArrayList<>();
        ListNode hA = headA;
        ListNode hB = headB;
        while (hA != null) {
            listA.add(hA);
            hA = hA.next;
        }
        while (hB != null) {
            listB.add(hB);
            hB = hB.next;
        }
        //2. 两个指针，同时从后往前遍历两个数组，当指针指向node不同时。上一个就是交点
        int indexA = listA.size() - 1;
        int indexB = listB.size() - 1;
        while (indexA >= 0 && indexB >= 0) {
            if (listA.get(indexA) != listB.get(indexB)) {
                break;
            }
            indexA--;
            indexB--;
        }
        //3. 因为list存的是node，所以不用再遍历，直接返回指定node即可
        int intersectionIndex = indexA + 1;
        if (intersectionIndex > listA.size() - 1) {
            return null;
        }
        return listA.get(intersectionIndex);
    }

    /**
     * leetcode 之前提交的答案
     * 时间O（m+n） 空间O1
     * 1. 遍历a链表获取长度sizeA，遍历b链表，获取长度sizeB。取长度和size = sizeA + sizeB
     * 2. a、b两个链表都遍历size下；a到头后，移动到b的headB；b到头后，移动到a的headA。
     * 当a=b的时候，这个就是交点，直接返回；如果没有a=b，则没有交点
     *
     * 假设a长度m，b长度n，a和b重叠的node长度为x
     * a中相交点node之前长度为 m-x
     * b中相交点node之前长度为 n-x
     * 所以
     * 先遍历a，到头，遍历b，走到node，长度是 m+n-x
     * 先遍历b，到头，遍历a，走到node，长度是 n+m-x
     *
     * 所以在 m+n 的遍历过程中，存在 m+n-x 的位置，使两个指针指向的node相同，那么就是交点
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        int iterateNum = 0;
        ListNode hA = headA;
        ListNode hB = headB;
        while (hA != null) {
            iterateNum++;
            hA = hA.next;
        }
        while (hB != null) {
            iterateNum++;
            hB = hB.next;
        }
        for (int i = 0; i < iterateNum; i++) {
            if (hA != null) { //链表可能直接为null，所以不用 hA.next != null
                hA = hA.next;
            }else {
                //hA已经到了尾部节点
                hA = headB;
            }

            if (hB != null) {
                hB = hB.next;
            }else {
                //hA已经到了尾部节点
                hB = headA;
            }

            if (hA == hB) {
                return hA;
            }
        }
        return null;
    }

    /**
     * getIntersectionNode2 的优化，不用计算存储长度
     * 1. 循环退出的条件是 a指针和b指针指向的node相同
     * 指向node相同，且不为null，说明有交点
     * 指向node相同，且为null，说明没有交点
     * 2. 如果一个head为null，遍历完，a和b都指向null
     * 3. 如果两个null，直接跳出循环，返回null
     * 4. 不会出现死循环。如果没有交点，就是最坏情况，需要遍历长度是两个链表长度和即m+n
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode3(ListNode headA, ListNode headB) {
        ListNode hA = headA;
        ListNode hB = headB;
        while (hA != hB) {
            hA = hA == null ? headB :  hA.next;
            hB = hB == null ? headA : hB.next;
        }
        return hA;
    }

    /**
     * 代码随想录
     * 双指针，需要记录链表长度
     * 1. 获取headA和headB长度。如果headA 比 headB 长，headA长度为m, headB长度为n。
     * 2. headA先移动 m-n，然后 A和B同时移动。判断A == B是否相等，true则返回当前node；
     * 如果移动到尾部都没有相同的node，说明没有交点返回null
     *
     * 处理的麻烦点是，需要确认那个链表更长，长的需要先移动差值。下面算法采用交换的方式，保持headA是更长的链表
     * 或者采用根据差值x的正负情况，分别对headA做不同的处理。
     * 如果差值为正，headA向右移动x个；差值为负的时候，headA向左加上虚拟节点x个（这种空间复杂度会高，毕竟会new新的节点）
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode4(ListNode headA, ListNode headB) {
        // 1. 获取headA和headB长度。如果headA 比 headB 长，headA长度为m, headB长度为n。
        int sizeA = 0;
        int sizeB = 0;
        ListNode hA = headA;
        ListNode hB = headB;
        while (hA != null) {
            sizeA++;
            hA = hA.next;
        }
        while (hB != null) {
            sizeB++;
            hB = hB.next;
        }
        //2. headA先移动 m-n，然后 A和B同时移动。判断A == B是否相等，true则返回当前node；
        //如果移动到尾部都没有相同的node，说明没有交点返回nul
        if (sizeB > sizeA) {
            //保证headA比headB长
            //交换长度
            int sizeTemp = sizeA;
            sizeA = sizeB;
            sizeB = sizeTemp;

            //交换链表
            ListNode tempNode = headA;
            headA = headB;
            headB = tempNode;
        }

        int subNum = sizeA - sizeB;
        hA = headA;
        hB = headB;
        while (subNum > 0) {
            hA = hA.next;
            subNum--;
        }

        while (hA != null) {
            if (hA == hB) {
                return hA;
            }
            hA = hA.next;
            hB = hB.next;
        }
        return null;
    }
}
