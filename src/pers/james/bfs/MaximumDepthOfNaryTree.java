package pers.james.bfs;

import java.util.LinkedList;
import java.util.List;

public class MaximumDepthOfNaryTree {
    public int maxDepth(Node root) {
        if (root == null) return 0;
        int ans = 0;
        LinkedList<Node> queue = new LinkedList<>();
        queue.offer(root);
        Node last = root;
        while (!queue.isEmpty()){

            Node current = queue.poll();
            if (current.children != null){
                for (Node n : current.children
                        ) {
                    queue.add(n);
                }
            }


            if (last == current){
                ans++;
                if (queue.isEmpty()) return ans;
                last = queue.peekLast();
            }

        }
        return ans;
    }
}

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
}