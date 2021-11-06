package pers.james.BinaryTree_DivideConquer;

import pers.james.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumDepthofBinaryTree {
    public int minDepth(TreeNode root) {
        return helper(root);
    }

    private int helper(TreeNode node) {
        if (node == null) return 0;

        int leftMin = helper(node.left);
        int rightMin = helper(node.right);

        if (node.right == null || node.left == null){
            return Math.max(leftMin, rightMin) + 1;
        }
        return Math.min(leftMin, rightMin) + 1;
    }

    public int minDepth1(TreeNode root) {
        int minDepth = 0;
        if (root == null) return minDepth;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            minDepth++;
            int size = queue.size();
            for (int i = 0; i < size; i++){
                TreeNode node = queue.poll();
                if (node == null){
                    continue;
                }
                if (node.right == null && node.left == null) return minDepth;
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }
        return minDepth;
    }
}
