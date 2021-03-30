package pers.james.dp;

/**
 * @author 11101526
 * @date 2021/3/26 21:35
 */
public class UniquePaths {
    /**
     * dp[i][j] = dp[i+1][j] + dp[i][j+1]
     * dp[i][j] 的含义：(i,j)到达终点的所有路径个数
     * = 下面那个格的路径和 + 右边那个路径和
     * 这种思路，就需要从后往前推
     *
     * sum[i][j] = sum[i-1][j] + sum[i][j-1]
     * sum[i][j]的含义：从(0,0)出发到达（i,j）的所有路径个数
     * @param m
     * @param n
     * @return
     */
    public static int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        //初始化
        //终点到自己有一条路
        dp[m-1][n-1] = 1;
        //状态转移
        for (int i = m-1; i >=0 ; i--) {
            for (int j = n-1; j >= 0 ; j--) {
                //跳过终点格
                if (i == m-1 && j == n-1) {
                    //break 会跳出 j 的内循环，直接开始i--；continue 会跳出当前 j 循环，开始 j--
                    continue;
                }
                //超边界处理
                int down;
                if (i + 1 > m -1) {
                    down = 0;
                }else {
                    down = dp[i+1][j];
                }
                int right;
                if (j + 1 > n -1) {
                    right = 0;
                }else {
                    right = dp[i][j+1];
                }
                dp[i][j] =  down + right;
            }
        }

        return dp[0][0];
    }

    public static void main(String[] args) {
        uniquePaths(3, 7);
    }
}
