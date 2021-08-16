package pers.james.dp;

/**
 * @author 11101526
 * @date 2021/4/7 15:11
 */
public class JumpGame {
    /**
     * dp[i] 表示从0能不能走到i
     * bottom to top
     * @param nums
     * @return
     */
    public static boolean canJump(int[] nums) {
        boolean[] dp = new boolean[nums.length];
        //initialization
        dp[0] = true;
        //state transfer
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < i ; j++) {
                if (dp[j] && nums[j] + j >= i ) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[nums.length-1];
    }

    /**
     * dp[i] 表示从i能不能走到终点
     * top to bottom 相当于从终点回溯的过程
     * @param nums
     * @return
     */
    private boolean canJump1(int[] nums) {
        boolean[] dp = new boolean[nums.length];
        //initialization
        dp[nums.length - 1] = true;

        //state transfer
        for (int i = nums.length - 2; i >= 0 ; i--) {
            for (int j = nums.length - 1; j > i ; j--) {
                if (dp[j]) {
                    if (i + nums[i] >= j) {
                        dp[i] = true;
                        break;
                    }
                }
            }
        }
        return dp[0];
    }

    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        boolean b = canJump(nums);
        System.out.println(b);
    }
}
