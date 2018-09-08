package pers.james.bfs;

import pers.james.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTree_Level_Order_Traversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()){
            List<Integer> levelResult = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++){
                TreeNode node = queue.poll();
                levelResult.add(node.val);

                if (node.left != null) queue.offer(node.left);

                if (node.right != null) queue.offer(node.right);
            }
            result.add(levelResult);
        }
        return result;
    }
}
