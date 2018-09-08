package pers.james.BinaryTree_DivideConquer;

import pers.james.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {
    /**
     *
     * @param root
     * @return 1. 递归的定义：找出以root为根的所有 root-to-leaf 的路径
     */
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();

        // 3. 递归出口
        if (root == null) return result;

        //所有的二叉树，最后要有一布验证，验证如果root是叶子节点的时候是否满足，即只有root一个节点的时候
        if (root.left == null && root.right == null) {
            result.add("" + root.val);
            return result;
        }

        // 2. 递归的拆解
        List<String> leftPaths = binaryTreePaths(root.left);
        List<String> rightPaths = binaryTreePaths(root.right);

        // 拆解之后的conquer（Merge的过程）, 分完之后要把结果合并起来
        for (String p:leftPaths
             ) {
            result.add(root.val + "->" + p);
        }

        for (String p:rightPaths
                ) {
            result.add(root.val + "->" + p);
        }

        return result;
    }
}
