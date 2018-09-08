package pers.james.BinaryTree_DivideConquer;

import pers.james.TreeNode;

public class Flatten_BinaryTree_to_LinkedList {
    public void flatten(TreeNode root) {
        helper(root);
    }

    private TreeNode helper(TreeNode root) {
        if (root == null) return null;

        TreeNode leftLast = helper(root.left);
        TreeNode rightLast = helper(root.right);

        if (leftLast != null){
            leftLast.right = root.right;
            root.right = root.left;
            root.left = null;
        }

        if (rightLast != null){
            return rightLast;
        }

        if (leftLast != null) return leftLast;

        return root;
    }
}
