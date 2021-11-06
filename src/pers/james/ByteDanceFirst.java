package pers.james;


import java.util.*;

/**
 * 第三题
 */
//public class ByteDanceFirst {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String s = sc.nextLine();
//        ByteDanceFirst main = new ByteDanceFirst();
//        int result = main.parsenum(s,3);
//        System.out.println(result);
//
//    }
//
//    private int parsenum(String s, int n){
//        Integer num1, num2, num3;
//
//        if (s.length() > 3*n + 3 || s.length() <= n) return 0;
//        else if (n == 0 && Integer.parseInt(s) < 255 && Integer.parseInt(s) >=0) return 1;
//        else {
//            num1 = parsenum(s.substring(1, s.length()), n - 1);
//            num2 = parsenum(s.substring(2, s.length()), n - 1);
//            if (Integer.parseInt(s.substring(0, 3)) < 256){
//                num3 = parsenum(s.substring(3, s.length()), n - 1);
//            }else num3 = 0;
//        }
//        return num1+num2+num3;
//    }
//}


/**
 * 第五题
 */
public class ByteDanceFirst {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Integer n = sc.nextInt();
        Integer m = sc.nextInt();

        int[] relation = new int[m*2];
        for (int i = 0; i < m*2; i++){
            relation[i] = sc.nextInt();
        }
//        for (int i = 0; i < relation.length; i++){
//            System.out.println(relation[i]);
//        }
        ByteDanceFirst main = new ByteDanceFirst();
        ArrayList<DirectedGraphNode> graph = main.productGraph(relation);
        for (DirectedGraphNode node:graph
             ) {
            System.out.println(node.label);
        }

//        int result = main.findHot(graph);
//        System.out.println(result);
    }

    private ArrayList<DirectedGraphNode> productGraph(int[] relation){
        ArrayList<DirectedGraphNode> graph = new ArrayList<>();
        DirectedGraphNode cur = null;
        DirectedGraphNode neighbor = null;
        for (int i = 0; i < relation.length; i++){
            graph.add(new DirectedGraphNode(-1));
        }
        for (int i = 0; i < relation.length; i++){
            DirectedGraphNode newNode = new DirectedGraphNode(relation[i]);
            if (i % 2 == 0){
                cur = newNode;
                if (graph.get(relation[i]) != null && graph.get(relation[i]).label != -1) graph.add(relation[i], cur);
            }else {
                neighbor = newNode;
                cur.neighbors.add(neighbor);
                if (graph.get(relation[i]) != null&& graph.get(relation[i]).label != -1) graph.add(relation[i], neighbor);
            }
        }
        return graph;
    }

    class DirectedGraphNode {
        int label;
        ArrayList<DirectedGraphNode> neighbors;
        DirectedGraphNode(int x) { label = x; neighbors = new ArrayList<DirectedGraphNode>(); }
    }

    private int findHot(ArrayList<DirectedGraphNode> graph){
        int num = 0;
        int size = graph.size();
        for (DirectedGraphNode startNode:graph
             ) {
            if (bfs(startNode, size)) num++;
        }
        return num;
    }

    private boolean bfs(DirectedGraphNode node, int size) {
        Queue<DirectedGraphNode> queue = new LinkedList<>();
        Set<DirectedGraphNode> set = new HashSet<>();
        queue.offer(node);
        set.add(node);
        while (!queue.isEmpty()){
            DirectedGraphNode cur = queue.poll();
            for (DirectedGraphNode neighbor:cur.neighbors
                 ) {
                if (!set.contains(neighbor)){
                    queue.offer(neighbor);
                    set.add(neighbor);
                }
            }
        }
        if (set.size() != size) return false;
        return true;
    }
}


/**
 * 第二题
 */
//public class ByteDanceFirst {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        Integer line = sc.nextInt();
//        int[][] grid = new int[line][line];
//        for (int x = 0; x < line; x++){
//            for (int y = 0; y < line; y++){
//                int element = sc.nextInt();
//                grid[x][y] = element;
//            }
//        }
//        ByteDanceFirst main = new ByteDanceFirst();
//        int result = main.countDepartment(grid);
//        System.out.println(result);
//
//    }
//
//    private int countDepartment(int[][] grid){
//        if (grid == null || grid.length == 0 || grid[0].length == 0) {
//            return 0;
//        }
//        int result = 0;
//        int n = grid.length;
//        int m = grid[0].length;
//        for (int i = 0; i < n; i++){
//            for (int j = 0; j < m; j++){
//                if (grid[i][j] == 1){
//                    bfs(grid, i, j);
//                    result++;
//                }
//            }
//        }
//        return result;
//    }
//
//    private void bfs(int[][] grid, int x, int y){
//        int[] deltX = {-1, 0, 1, 0};
//        int[] deltY = {0, 1, 0, -1};
//        Queue<Pos> queue = new LinkedList<>();
//        queue.offer(new Pos(x, y));
//        grid[x][y] = 0;
//        while (!queue.isEmpty()){
//            Pos cur = queue.poll();
//            for (int i = 0; i < 4; i++){
//                int x1 = cur.x+deltX[i];
//                int y1 = cur.y+deltY[i];
//                if (isBound(grid, x1, y1) && grid[x1][y1] == 1){
//                    queue.offer(new Pos(x1, y1));
//                    grid[x1][y1] = 0;
//                }
//            }
//        }
//    }
//
//    private boolean isBound(int[][] grid, int x, int y){
//        int n = grid.length;
//        int m = grid[0].length;
//        return x >= 0 && x < n && y >= 0 && y < m;
//    }
//
//    class Pos{
//        int x;
//        int y;
//        public Pos(int x, int y) {
//            this.x = x;
//            this.y = y;
//        }
//    }


