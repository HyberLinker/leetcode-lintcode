package pers.james.bfs;

import pers.james.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TraverseBinaryTree {
    /**
     * 单层从左到右，双层从右到左
     */
    public void fun(TreeNode root){

    }

    public void bfs(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean isOdd = false;
        while (!queue.isEmpty()){
            int size = queue.size();
            List<TreeNode> level = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                level.add(cur);
                if (cur.left != null)queue.offer(cur.left);
                if (cur.right != null)queue.offer(cur.right);
            }
            if (isOdd){
                for (int i = 0; i < level.size(); i++) {
                    System.out.println(level.get(i).val);
                }

            }else {
                for (int i = level.size()-1; i >=0; i--) {
                    System.out.println(level.get(i).val);
                }
            }
            isOdd = !isOdd;
        }
    }


}
