package pers.james.BinaryTree_DivideConquer;

import pers.james.TreeNode;

public class Validate_Binary_Search_Tree {
    public boolean isValidBST(TreeNode root) {
        return helper(root).isValid;
    }

    private ReturnType helper(TreeNode root) {
        if (root == null) {
            int maxVal = Integer.MIN_VALUE;
            int minVal = Integer.MAX_VALUE;
            ReturnType r = new ReturnType(true);
            r.minVal = minVal;
            r.maxVal = maxVal;
            return r;
        }

        ReturnType left = helper(root.left);
        ReturnType right = helper(root.right);

        if (!left.isValid || !right.isValid) return new ReturnType(false);
        else if (root.left != null && left.maxVal >= root.val) return new ReturnType(false);
        else if (root.right != null && right.minVal <= root.val) return new ReturnType(false);

        int maxVal = Math.max(right.maxVal, root.val);
        int minVal = Math.min(left.minVal, root.val);
        ReturnType rootResult = new ReturnType(true);
        rootResult.maxVal = maxVal;
        rootResult.minVal = minVal;
        return rootResult;
    }

    class ReturnType{
        boolean isValid;
        int maxVal;
        int minVal;

        public ReturnType(boolean isValid) {
            this.isValid = isValid;
        }
    }
}
