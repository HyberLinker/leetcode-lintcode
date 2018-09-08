package pers.james.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class Number_of_Islands {
    int[] deltX = {-1, 0, 1, 0};
    int[] deltY = {0, 1, 0, -1};

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int result = 0;
        int n = grid.length;
        int m = grid[0].length;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                if (grid[i][j] == '1'){
                    bfs(grid, i, j);
                    result++;
                }
            }
        }
        return result;
    }

    private void bfs(char[][] grid, int x, int y){
        Queue<Pos> queue = new LinkedList<>();
        queue.offer(new Pos(x, y));
        grid[x][y] = '0';
        while (!queue.isEmpty()){
            Pos cur = queue.poll();
//            grid[cur.x][cur.y] = '0';  不能再poll出的时候再设置成visited，再offer进队列的时候就要改
//            不然还是会重复拜访，但是time excess error
            for (int i = 0; i < 4; i++){
                int x1 = cur.x+deltX[i];
                int y1 = cur.y+deltY[i];
                if (isBound(grid, x1, y1) && grid[x1][y1] == '1'){
                    queue.offer(new Pos(x1, y1));
                    grid[x1][y1] = '0';
                }
            }
        }
    }

    private boolean isBound(char[][] grid, int x, int y){
        int n = grid.length;
        int m = grid[0].length;
        return x >= 0 && x < n && y >= 0 && y < m;
    }

    class Pos{
        int x;
        int y;
        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
