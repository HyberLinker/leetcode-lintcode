package pers.james.array;

public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int curGroupSum = nums[0];
        int ans = nums[0];

        for (int i = 1; i < nums.length; i++){
            curGroupSum = Math.max(nums[i], nums[i]+curGroupSum);
            ans = Math.max(ans, curGroupSum);
        }
        return ans;
    }
}
