package pers.james.dp;

import java.util.Objects;

/**
 * @author 11101526
 * @date 2021/3/27 21:17
 */
public class UniquePathsII {
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (Objects.isNull(obstacleGrid)) {
            return 0;
        }
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[][] dp = new int[m][n];
        //初始化
        //不能一味的把第一排和第一列，有障碍物的地方设置为0，没有的地方设置为1
        //因为如果前一个是0，后一个一定也是0

        if (obstacleGrid[0][0] == 1) {
            return 0;
        }
        dp[0][0] = 1;

//        for (int i = 0; i < m; i++) {
//            if (obstacleGrid[i][0] == 0) {
//                dp[i][0] = 1;
//            }
//        }
//        for (int i = 0; i < n; i++) {
//            if (obstacleGrid[i][0] == 0) {
//                dp[0][i] = 1;
//            }
//        }
        //初始化第一列
        for (int i = 1; i < m; i++) {
            //当前位置没有石头 并且 上一个位置能到达
            if (obstacleGrid[i][0] == 0 && dp[i-1][0] != 0) {
                dp[i][0] = 1;
            }
        }
        //初始化第一行
        for (int i = 1; i < n; i++) {
            if (obstacleGrid[0][i] == 0 && dp[0][i-1] != 0) {
                dp[0][i] = 1;
            }
        }

        //状态转移
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 0) {
                    dp[i][j] = dp[i][j-1] + dp[i-1][j];
                }
            }
        }

        return dp[m-1][n-1];
    }

    public static void main(String[] args) {
        int[][] a = {{0,1,0,0,0},{1,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0}};
        System.out.println(uniquePathsWithObstacles(a));
    }
}


