package pers.james.BinaryTree_DivideConquer;

import pers.james.TreeNode;

public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {

        return helper(root).balanced;
    }

    public ReturnType helper(TreeNode root){
        if (root == null) return new ReturnType(0, true);

        ReturnType left = helper(root.left);
        ReturnType right = helper(root.right);

        if (!left.balanced || !right.balanced) return new ReturnType(-1, false);

        if (Math.abs(left.depth - right.depth) > 1) return new ReturnType(-1, false);

        return new ReturnType(Math.max(left.depth, right.depth)+1, true);

    }
    class ReturnType {
        int depth;
        boolean balanced;

        public ReturnType(int depth, boolean balanced) {
            this.depth = depth;
            this.balanced = balanced;
        }
    }
}


