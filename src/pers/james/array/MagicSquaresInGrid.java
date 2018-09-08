package pers.james.array;

import java.util.ArrayList;
import java.util.List;

public class MagicSquaresInGrid {
    public static void main(String[] args) {
        int[][] grid = {{5,5,5},{5,5,5},{5,5,5}};
        numMagicSquaresInside(grid);

    }
    public static int numMagicSquaresInside(int[][] grid) {
        int R = grid.length, C = grid[0].length;
        int ans = 0;
        /**
         * 3*3grid，所以是从0到len-3，所以是 r<R-2
         */
        for (int r = 0; r < R-2; ++r)
            for (int c = 0; c < C-2; ++c) {
                if (grid[r+1][c+1] != 5) continue;  // optional skip
                if (magic(grid[r][c], grid[r][c+1], grid[r][c+2],
                        grid[r+1][c], grid[r+1][c+1], grid[r+1][c+2],
                        grid[r+2][c], grid[r+2][c+1], grid[r+2][c+2]))
                    ans++;
            }

        return ans;
    }
    public static boolean magic(int... vals) {
        /**
         * 检查magic grid中的数是不是1-9不重复的数
         * 每个1-9作为index，出现哪个位置的数，那个位置就加一，从count[1]到count[9]都应该为1
         */
        int[] count = new int[16];
        for (int v: vals) count[v]++;
        for (int v = 1; v <= 9; ++v)
            if (count[v] != 1)
                return false;

        return (vals[0] + vals[1] + vals[2] == 15 &&
                vals[3] + vals[4] + vals[5] == 15 &&
                vals[6] + vals[7] + vals[8] == 15 &&
                vals[0] + vals[3] + vals[6] == 15 &&
                vals[1] + vals[4] + vals[7] == 15 &&
                vals[2] + vals[5] + vals[8] == 15 &&
                vals[0] + vals[4] + vals[8] == 15 &&
                vals[2] + vals[4] + vals[6] == 15);
    }
}
