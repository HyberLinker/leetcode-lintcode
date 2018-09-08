package pers.james.bfs;

import java.util.*;

public class TopologicalSorting {
      class DirectedGraphNode {
          int label;
          ArrayList<DirectedGraphNode> neighbors;
          DirectedGraphNode(int x) { label = x; neighbors = new ArrayList<DirectedGraphNode>(); }
      }

    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        // write your code here
        ArrayList<DirectedGraphNode> result = new ArrayList<>();
        Map<DirectedGraphNode, Integer> indegrees = new HashMap<>();

        //record the indegree of each node(the least indegree will be 1, so indegree = 0 will not be stored in this map)
        //一个拓扑图，总是存在入度=0的vertex，因为必然有些vertex不需要prerequisite
        for (DirectedGraphNode node:graph
             ) {
            for (DirectedGraphNode neighbor:node.neighbors
                 ) {
                if (!indegrees.containsKey(neighbor)){
                    indegrees.put(neighbor, 1);
                }else {
                    indegrees.put(neighbor, indegrees.get(neighbor)+1);
                }
            }

        }

        //initial result: put the nodes which has the 0 indegree in the result list
        Queue<DirectedGraphNode> queue = new LinkedList<>();
        for (DirectedGraphNode n: graph
             ) {
            if (!indegrees.containsKey(n)){
                result.add(n);
                queue.offer(n);
            }
        }

        //BFS
        while (!queue.isEmpty()){
            DirectedGraphNode cur = queue.poll();
            for (DirectedGraphNode neighbor:cur.neighbors
                 ) {
                indegrees.put(neighbor, indegrees.get(neighbor)-1);
                if (indegrees.get(neighbor) == 0){
                    result.add(neighbor);
                    queue.offer(neighbor);
                }
            }
        }
        return result;
    }
}
