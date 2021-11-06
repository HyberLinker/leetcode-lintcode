package pers.james.bfs;

import pers.james.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Serialize_and_DeserializeBinaryTree {
    public static void main(String[] args) {
        String data = "{1,#,2,3}";
        deserialize(data);
    }
    // Encodes a tree to a single string.

    /**
     * solution 1
     * @param root
     * @return
     */
    public String serialize(TreeNode root) {
        if (root == null) {
            return "{}";
        }
        // arrayList 只是用来存储所有的treeNode，这样就不用创建单独得queue去遍历整个树
        // arraylist 来表示 queue
        ArrayList<TreeNode> queue = new ArrayList<TreeNode>();
        queue.add(root);
        //queue的size是不断增长的
        for (int i = 0; i < queue.size(); i++) {
            TreeNode node = queue.get(i);
            if (node == null) {
                continue;
            }
            queue.add(node.left);
            queue.add(node.right);
        }
        //去掉尾端所有的null（从最后一个，到第一个不为null的node）
        while (queue.get(queue.size() - 1) == null) {
            queue.remove(queue.size() - 1);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("{");
        sb.append(queue.get(0).val);
        for (int i = 1; i < queue.size(); i++) {
            if (queue.get(i) == null) {
                sb.append(",#");
            } else {
                sb.append(",");
                sb.append(queue.get(i).val);
            }
        }
        sb.append("}");
        return sb.toString();
    }

    /**
     * solution 2
     * @param root
     * @return
     */
    public static String serialize1(TreeNode root){
        if (root == null) return "{}";
        Queue<TreeNode> queue = new LinkedList<>();
        List<TreeNode> tree = new ArrayList<>();
        queue.offer(root);
        tree.add(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            if (node == null) continue;
            queue.offer(node.left);
            queue.offer(node.right);
            tree.add(node.left);
            tree.add(node.right);
        }

        //去尾端node==null的值
        while (tree.get(tree.size()-1) == null) tree.remove(tree.size()-1);
        StringBuilder s = new StringBuilder();
        s.append("{");
        s.append(tree.get(0).val);
        for (int i = 1; i < tree.size(); i++){
            s.append(",");
            if (tree.get(i) == null){
                s.append("#");
            }else {
                s.append(tree.get(i).val);
            }
        }
        s.append("}");
        return s.toString();
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        if (data.equals("{}")) {
            return null;
        }
        String[] vals = data.substring(1, data.length() - 1).split(",");
        ArrayList<TreeNode> queue = new ArrayList<TreeNode>();
        TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
        queue.add(root);
        int index = 0;
        boolean isLeftChild = true;
        for (int i = 1; i < vals.length; i++) {
            if (!vals[i].equals("#")) {
                TreeNode node = new TreeNode(Integer.parseInt(vals[i]));
                if (isLeftChild) {
                    queue.get(index).left = node;
                } else {
                    queue.get(index).right = node;
                }
                queue.add(node);
            }
            if (!isLeftChild) {
                index++;
            }
            isLeftChild = !isLeftChild;
        }
        return root;
    }
}
