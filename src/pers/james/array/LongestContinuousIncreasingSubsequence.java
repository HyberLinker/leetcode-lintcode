package pers.james.array;

public class LongestContinuousIncreasingSubsequence {
    public int findLengthOfLCIS(int[] nums) {
        int maxlen = 1, len = nums.length, currentLen = 1;
        if (len == 0) return 0;
        for (int i = 0; i < len - 1; i++){
            if (nums[i] >= nums[i + 1]) currentLen = 1; //当后一个数比当前数小，就重置计数，开始准备下一组连续递增数列
            else if (nums[i] < nums[i + 1]) {
                currentLen++;
                if (currentLen > maxlen) maxlen = currentLen;
            }
        }
        return maxlen;
    }
}
