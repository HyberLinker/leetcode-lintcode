package pers.james.dp;

/**
 * @author 11101526
 * @date 2021/3/30 21:45
 */
public class MinimunPathSum {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        //initialization
        // dp[i][j] 表示 从（0,0）到 （i,j）路径和最小值
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];

        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i-1][0] + grid[i][0];
        }

        for (int i = 1; i < n; i++) {
            dp[0][i] = dp[0][i-1] + grid[0][i];
        }

        //status transfer
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                //不是算一共多少路径，而是算路径上数之和最小
                dp[i][j] = Math.min(dp[i][j-1], dp[i-1][j]) + grid[i][j];
            }
        }

        return dp[m-1][n-1];
    }
}
