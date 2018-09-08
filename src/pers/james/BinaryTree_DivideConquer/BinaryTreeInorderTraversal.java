package pers.james.BinaryTree_DivideConquer;

import pers.james.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class BinaryTreeInorderTraversal {
    /**
     *
     * @param root
     * @return
     *
     * 非递归，需记忆！
     */
    public List<Integer> inorderTraversal1(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> inorder = new ArrayList<>();

        TreeNode cur = root;
        while (cur != null || !stack.empty()){
            while (cur != null){
                stack.push(cur);
                cur = cur.left;
            }

            cur = stack.pop();
            inorder.add(cur.val);
            cur = cur.right;
        }
        return inorder;
    }

    /**
     *
     * @param root
     * @return
     *
     * 递归，遍历（traverse）
     */
//    public List<Integer> inorderTraversal(TreeNode root) {
//
//        List<Integer> inorder = new ArrayList<>();
//        traverse(root, inorder);
//        return inorder;
//    }
//
//    private void traverse(TreeNode root, List<Integer> inorder) {
//
//        if (root == null) return;
//
//        traverse(root.left, inorder);
//        inorder.add(root.val);
//        traverse(root.right, inorder);
//    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> inorder = new ArrayList<>();

        if (root == null) return inorder;

        List<Integer> leftInorder = inorderTraversal(root.left);
        List<Integer> rightInorder = inorderTraversal(root.right);

        inorder.addAll(leftInorder);
        inorder.add(root.val);
        inorder.addAll(rightInorder);

        return inorder;
    }
}
