package pers.james.BinaryTree_DivideConquer;

import pers.james.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePreorderTraversal {
    /**
     *
     * @param root
     * @return
     *
     * 非递归方法，用到了stack的数据结构，必背！
     */
    public List<Integer> preorderTraversal1(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> result = new ArrayList<>();

        if (root == null) return null;

        stack.push(root);
        while (!stack.empty()){
            TreeNode cur = stack.pop();
            result.add(cur.val);

            if (cur.right != null) stack.push(cur.right);
            if (cur.left != null) stack.push(cur.left);

        }

        return result;
    }

    /**
     *
     * @param root
     * @return
     *
     * 递归写法，分治法（divide&conquer）
     */
//    public List<Integer> preorderTraversal(TreeNode root) {
//        List<Integer> preorder = new ArrayList<>();
//
//        if (root == null) return preorder;
//
//        preorder.add(root.val);
//
//        List<Integer> leftPreorder = preorderTraversal(root.left);
//        List<Integer> rightPreorder = preorderTraversal(root.right);
//
//        preorder.addAll(leftPreorder);
//        preorder.addAll(rightPreorder);
//
//        return preorder;
//    }

    /**
     *
     * @param root
     * @return
     *
     * 递归， 遍历（traverse）
     */

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> preorder = new ArrayList<>();
        traverse(root, preorder);
        return preorder;
    }

    private void traverse(TreeNode root, List<Integer> preorder) {
        if (root == null){
            return;
        }
        preorder.add(root.val);

        traverse(root.left, preorder);
        traverse(root.right, preorder);
    }


}
