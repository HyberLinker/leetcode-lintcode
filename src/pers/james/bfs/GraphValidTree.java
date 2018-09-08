package pers.james.bfs;

import java.util.*;

public class GraphValidTree {
    public boolean validTree(int n, int[][] edges) {
        // write your code here
        if (edges.length != n - 1) return false;
        Map<Integer, Set<Integer>> graph = transferGraph(n, edges);
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> set = new HashSet<>();

        queue.offer(0);
        set.add(0);
        while (!queue.isEmpty()){
            Integer node = queue.poll();
            for (Integer i:graph.get(node)
                 ) {
                if (set.contains(i)) continue;
                set.add(i);
                queue.offer(i);
            }
        }
        if (set.size() != n) return false;
        return true;
    }

    private Map<Integer, Set<Integer>> transferGraph(int n, int[][] edges){
        Map<Integer, Set<Integer>> graph = new HashMap<>();

        for (int i = 0; i < n; i++){
            graph.put(i, new HashSet<Integer>());
        }

        for (int i = 0; i < edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        return graph;
    }
}
