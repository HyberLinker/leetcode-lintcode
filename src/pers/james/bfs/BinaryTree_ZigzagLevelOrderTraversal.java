package pers.james.bfs;

import pers.james.TreeNode;

import java.util.*;

public class BinaryTree_ZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        queue.offer(root);
        boolean isOdd = true;



        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode temp = queue.poll();
                level.add(temp.val);
                if (temp.left != null) queue.offer(temp.left);
                if (temp.right != null) queue.offer(temp.right);
            }
            if (!isOdd){
                Collections.reverse(level);
            }
            result.add(level);
            isOdd = !isOdd;
        }
        return result;
    }
}
