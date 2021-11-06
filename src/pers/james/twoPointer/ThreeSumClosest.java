package pers.james.twoPointer;

import java.util.Arrays;

public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3) return -1;
        Arrays.sort(nums);
        int sum = 0, diff = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length-2; i++) {
            int left = i+1, right = nums.length-1;
            while (left < right){
                int potential_sum = nums[i] + nums[left] + nums[right];
                int potential_diff = Math.abs(target-potential_sum);
                if (potential_sum > target){
                    right--;
                }else if (potential_sum < target) left++;
                else return target;

                if (potential_diff < diff){
                    diff = potential_diff;
                    sum = potential_sum;
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 2, 1, -4};
        ThreeSumClosest t = new ThreeSumClosest();
        t.threeSumClosest(nums , 1);
    }
}
