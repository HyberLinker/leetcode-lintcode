package pers.james.twoPointer;

import java.util.Arrays;

public class TriangleCount {
    public int triangleCount(int[] nums){
        int result = 0;
        if (nums == null || nums.length < 3) return 0;
        Arrays.sort(nums);
        for (int i = 2; i < nums.length; i++) {
            int left = 0, right = i - 1;
            while (left < right){
                if (nums[left]+nums[right] > nums[i]){
                    result += right-- - left;
                }else left++;
            }
        }
        return result;
    }
}
