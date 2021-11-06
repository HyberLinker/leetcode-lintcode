package pers.james.BinaryTree_DivideConquer;

import pers.james.TreeNode;

/**
 * leetcode 没有这道题，所以这两个写法都不保证正确性
 */
public class SubtreeWithMaximumAverage {
    private RetureType1 subTreeResult = null;

    /**
     * 解法一
     * 1. 用全局变量subTreeResult去储存最终的结果（每层当前的结果）
     * 2. 每层返回的值是，当前层的node，sum，num数据的集合（ReturnType）
     * @param root
     * @return
     */
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

    /**
     * 解法二
     * 1. 每一层都有当前最优解（把结果bottom-up向上一直抛出）
     * 2. 每层的返回值是当前整个题目的结果
     * @param root
     * @return
     */
    public TreeNode findSubtree1(TreeNode root){
        return helper1(root).subTreeRoot;
    }
    private RetureType1 helper1(TreeNode root) {

        if (root == null) return new RetureType1(null, 0, 0);

        RetureType1 left = helper(root.left);
        RetureType1 right = helper(root.right);

        RetureType1 subTreeMax = null;
        if (left.sum*right.num > right.sum*left.num) subTreeMax = left;
        else subTreeMax = right;

        int sum = left.sum + right.sum + root.val;
        int num = left.num + right.num + 1;
        if (sum*subTreeMax.num > subTreeMax.sum*num) return new RetureType1(root, num, sum);
        else return subTreeMax;
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

