package pers.james.BinaryTree_DivideConquer;

import pers.james.TreeNode;

public class MaximumDepthOfBinaryTree {
    int maxDepth;
    /**
     *
     * @param root
     * @return
     *
     * 递归，分治法
     */
    public int maxDepth1(TreeNode root) {
        if (root == null) return 0;

        int leftD = maxDepth(root.left);
        int rightD = maxDepth(root.right);

        return Math.max(leftD, rightD) + 1;
    }


    /**
     *
     * @param root
     * @return
     * 递归， 遍历（traverse）
     */
    public int maxDepth(TreeNode root) {
        maxDepth = 0;
        traverse(root, 1);
        return maxDepth;
    }

    private void traverse(TreeNode root, int curDepth) {
        if (root == null) return;

        if (curDepth > maxDepth) maxDepth = curDepth;

        traverse(root.left, curDepth+1);
        traverse(root.right, curDepth+1);
    }
}
