package pers.james.BinaryTree_DivideConquer;

import pers.james.TreeNode;

public class Lowest_Common_Ancestor_of_a_BinaryTree {
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null || root == p || root == q) return root;

        TreeNode leftLCA = lowestCommonAncestor(root.left, p, q);
        TreeNode rightLCA = lowestCommonAncestor(root.right, p, q);

//        if (leftLCA == null && rightLCA == null) return null;

        if (leftLCA != null && rightLCA != null) return root;

        if (leftLCA != null) return leftLCA;

        if (rightLCA != null) return rightLCA;

        return null;
    }


    /**
     *
     * @param root
     * @param p
     * @param q
     * @return
     * ReturnType包装的divide&conquer，应该也可以判断 当p或者q不存在的情况
     * 因为，leetcode上的原题是要求，p和q一定存在的情况
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return helper(root, p, q).lca;
    }

    private ReturnTypeLCA helper(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return new ReturnTypeLCA(false, false, null);
//        else if (root == p) return new ReturnTypeLCA(true, false, root);
//        else if (root == q) return new ReturnTypeLCA(false, true, root);

        ReturnTypeLCA left = helper(root.left, p , q);
        ReturnTypeLCA right = helper(root.right, p, q);

        ReturnTypeLCA rootResult = new ReturnTypeLCA(left.existA || right.existA, left.existB || right.existB, root);

        if (root == p) return new ReturnTypeLCA(true, left.existB || right.existB, root);
        else if (root == q) return new ReturnTypeLCA(left.existA || right.existA, true, root);

        // A 和 B 都在左边
        if (left.existA && left.existB) return left;
        // A 和 B 都在右边
        else if (right.existB && right.existA) return right;
        // A 和 B 不在一边 （和 A，B都不存在）
        else return rootResult;

    }

    class ReturnTypeLCA{
        boolean existA, existB;
        TreeNode lca;

        public ReturnTypeLCA(boolean existA, boolean existB, TreeNode lca) {
            this.existA = existA;
            this.existB = existB;
            this.lca = lca;
        }
    }

}

