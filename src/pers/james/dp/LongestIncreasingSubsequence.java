package pers.james.dp;

/**
 * @author 11101526
 * @date 2021/4/13 21:12
 */
public class LongestIncreasingSubsequence {
    public static int lengthOfLIS(int[] nums) {
        int res = 1;
        int[] dp = new int[nums.length];
        dp[0] = 1;

        //state transfer
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] +1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {0,1,0,3,2,3};
        lengthOfLIS(nums);
    }
}
