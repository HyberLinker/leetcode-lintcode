package pers.james.BinaryTree_DivideConquer;

import pers.james.TreeNode;

public class SubtreeWithMaximumAverage {
    private RetureType1 subTreeResult = null;

    public TreeNode findSubtree(TreeNode root){
        helper(root);
        return subTreeResult.subTreeRoot;
    }

    private RetureType1 helper(TreeNode root) {
        if (root == null) {
            RetureType1 rootResult = new RetureType1(null, 0, 0);
            return rootResult;
        }

        RetureType1 left = helper(root.left);
        RetureType1 right = helper(root.right);

        RetureType1 rootResult = new RetureType1(root, left.num + right.num + 1, left.sum + right.sum + root.val);

        if (subTreeResult == null || rootResult.sum*subTreeResult.num > subTreeResult.sum*rootResult.num){
            subTreeResult = rootResult;
        }
        return rootResult;
    }

    class RetureType1 {
        TreeNode subTreeRoot;
        int num;
        int sum;

        public RetureType1(TreeNode subTreeRoot, int num, int sum) {
            this.subTreeRoot = subTreeRoot;
            this.num = num;
            this.sum = sum;
        }
    }

}

