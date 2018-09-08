package pers.james.BinaryTree_DivideConquer;

import pers.james.TreeNode;

public class Convert_BinarySearchTree_to_Sorted_DoublyLinkedList {
    class ReturnType{
        DoublyListNode first, last;

        public ReturnType(DoublyListNode first, DoublyListNode last) {
            this.first = first;
            this.last = last;
        }
    }
    public DoublyListNode bstToDoublyList(TreeNode root){
        if (root == null) return null;
        return helper(root).first;
    }

    private ReturnType helper(TreeNode root) {
        if (root == null){
            return null;
        }
        ReturnType left = helper(root.left);
        ReturnType right = helper(root.right);

        ReturnType rootResult = new ReturnType(null, null);
        DoublyListNode node = new DoublyListNode(root.val);

        if (left == null){
            rootResult.first = node;
        }else {
            left.last.next = node;
            node.prev = left.last;
            rootResult.first = left.first;
        }


        if (right == null) rootResult.last = node;
        else {
            right.first.prev = node;
            node.next = right.first;
            rootResult.last = right.last;
        }

        return rootResult;
    }
}
