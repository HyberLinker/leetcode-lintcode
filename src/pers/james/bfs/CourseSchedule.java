package pers.james.bfs;
import java.util.*;

public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        Map<Integer, Integer> indegrees = new HashMap<>();

        //初始化图，放进去节点的值，和盛放邻居的容器set
        for (int i = 0; i < numCourses; i++) {
            graph.put(i, new HashSet<Integer>());
        }

        //把邻居放进graph，并生成indegrees
        for (int i = 0; i < prerequisites.length; i++) {
            int u = prerequisites[i][1];
            int v = prerequisites[i][0];
            graph.get(u).add(v);
            if (!indegrees.containsKey(v)){
                indegrees.put(v, 1);
            }else {
                indegrees.put(v, indegrees.get(v)+1);
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> result = new ArrayList<>();

        for (Map.Entry<Integer, Set<Integer>> e:graph.entrySet()
             ) {
            int node = e.getKey();
            if (!indegrees.containsKey(node)){
                queue.offer(node);
                result.add(node);
            }
        }
        while (!queue.isEmpty()){
            int temp = queue.poll();
            Set<Integer> neighbors = graph.get(temp);
            for (Integer n:neighbors
                 ) {
                indegrees.put(n, indegrees.get(n)-1);
                if (indegrees.get(n) == 0){
                    queue.offer(n);
                    result.add(n);
                }
            }
        }

        if (result.size() == numCourses) return true;
        else return false;

//        if (result.size() == numCourses) {
//            int[] array = new int[numCourses];
//            for (int i = 0; i < numCourses; i++) {
//                array[i] = result.get(i);
//            }
//            return array;
//        }else return new int[0];

    }
}
