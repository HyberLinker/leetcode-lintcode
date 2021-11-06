package pers.james.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 11101526
 * @date 2021/3/20 17:25
 */
public class ClimbingStairs {
    int res = 0;
    int[] memory;

    /**
     * 正向dfs
     * 超时
     * @param n
     * @return
     */
    public int climbStairsDFS(int n) {
        dfs(n, 0);
        return res;
    }

    /**
     * 没有返回值
     * 从 currentSteps 走到 n 就把res+1
     * @param n
     * @param currentSteps
     */
    private void dfs(int n, int currentSteps) {
        if (currentSteps >= n) {
            if (currentSteps == n) {
                res++;
            }
            return;
        }
        dfs(n, currentSteps+1);
        dfs(n, currentSteps+2);
    }

    public static void main(String[] args) {
//        ClimbingStairs stairs = new ClimbingStairs();
//        stairs.dp(10);
//        System.out.println("总路线：" + stairs.dp(5));
        int a = 1;
        dp(2);
    }

    /**
     * 逆向dfs
     * 超时
     * @param n
     * @return
     */
    public int climbStairsDFS2(int n) {
        return dfs2(n, 0);
    }

    /**
     * 从x走到n有多少种方案 = (x+1 到 n 的方案) + (x+2 到 n 的方案)
     * @param n
     * @param x
     * @return 有返回值，返回值是方案个数
     */
    private int dfs2(int n, int x) {
        if (x == n) {
            return 1;
        }
        if (x > n) {
            return 0;
        }
        return dfs2(n, x+1) + dfs2(n, x+2);
    }


    /**
     * 记忆搜索+dfs
     * 同样超时啊
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        //FIXME 数组长度要多一位，不然后面 x+1 的时候会数组越界
        memory = new int[n+1];
        //FIXME memory数组初始化的时候所有元素默认是0，所以这里不用赋值了
        for (int i = 0; i < memory.length; i++) {
            memory[i] = -1;
        }
        return dfsWithMemory(n, 0);
    }

    private int dfsWithMemory(int n, int x) {
        if (x == n) {
            return 1;
        }
        if (x > n) {
            return 0;
        }

        if (memory[x] != -1) {
            return memory[x];
        }
        memory[x] = dfsWithMemory(n, x+1) + dfsWithMemory(n, x+2);
        return memory[x];
    }


    /**
     * 起始点没有在台阶上所以是dp[0]
     * n 是台阶数
     * dp长度是n+1, n个台阶 + 起点位置
     * dp[n] 表示在第n个台阶，到第n个台阶有几种走法，这个不好理解，可以先思考dp[n-1]
     * dp[n-1] 表示在第n-1个台阶，到第n个台阶有几种走法；很明显只有 1种，所以dp[n-1] = 1。可以逆退出 dp[n]=1
     * @param n
     * @return dp[0] 表示从起点0刚好到第n个台阶有几种走法
     */
    public static int dp(int n) {
        int[] dp = new int[n+1];
        dp[n] = 1;
        dp[n - 1] = 1;

        //从倒数第三个位置，倒推出0的位置
        for (int i = n - 2; i >= 0 ; i--) {
            dp[i] = dp[i + 1] + dp[i + 2];
        }

        return dp[0];
    }

    /**
     * 空出dp[n]，填写从 0 到 n-1
     * @param n
     * @return
     */
    public static int dp1(int n) {

        int[] dp = new int[n+1];
        dp[n - 1 ] = 1;
        dp[n - 2] = 2;

        for (int i = n - 3; i >= 0 ; i--) {
            dp[i] = dp[i + 1] + dp[i + 2];
        }

        return dp[0];
    }
}
