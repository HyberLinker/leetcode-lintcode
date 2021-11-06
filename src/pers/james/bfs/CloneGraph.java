package pers.james.bfs;

import java.util.*;

public class CloneGraph {
    /**
     * 分成三步：
     * 1. 遍历所有的node，存起来
     * 2. copy 一边所有的点（只包括val）
     * 3. copy 一边所有的边（neighbors）
     * @param node
     * @return
     */
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) return null;
        Map<UndirectedGraphNode, UndirectedGraphNode> newGraph = new HashMap<>();

        //copy node(label)
        List<UndirectedGraphNode> set = traversalNodes(node);
        for (UndirectedGraphNode n:set
             ) {
            newGraph.put(n, new UndirectedGraphNode(n.label));
        }

        //copy edges(neighbors)
        for (UndirectedGraphNode n: set){

            for (UndirectedGraphNode neighbor:n.neighbors
                 ) {
                //把邻居对应的新邻居找出来
                UndirectedGraphNode newNeighbor = newGraph.get(neighbor);
                newGraph.get(n).neighbors.add(newNeighbor);
            }
        }

        return newGraph.get(node);
    }

    private List<UndirectedGraphNode> traversalNodes(UndirectedGraphNode node){
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        Set<UndirectedGraphNode> set = new HashSet<>();
        queue.offer(node);
        set.add(node);
        while (!queue.isEmpty()){
            UndirectedGraphNode n = queue.poll();
            for (UndirectedGraphNode i:n.neighbors
                 ) {
                if (!set.contains(i)){
                    queue.offer(i);
                    set.add(i);
                }
            }
        }
        return new ArrayList<>(set);
    }

    class UndirectedGraphNode {
        int label;
        List<UndirectedGraphNode> neighbors;
        UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
    }
}





