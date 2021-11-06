package pers.james.twoPointer;

import java.util.Arrays;

/**
 * leetcode 上没有这道题，没法验证这个方法对不对
 *
 * 两数之差，同向双指针
 * 先确定left，然后向右找，第一个right使得 nums[right]-nums[left] >= target
 * 然后，固定right，只需要向右移动left，如果当前right找不到结果。
 *
 * 从当前left，再找第一个right使得 nums[right]-nums[left] >= target
 * 然后，固定right，只需要向右移动left，。。。
 *
 * 注意：left不需要回撤，left和right都是一只向右走
 */
public class TwoMinus {
    public int[] twoSum7(int[] nums, int target){
        int[] result = new int[2];
        Arrays.sort(nums);
        int left = 0, right = 1;
        while (right < nums.length){
            while (right < nums.length && nums[right] - nums[left] < target) right++;
            if (right >= nums.length) return result;
            while (left < right){
                if (nums[right] - nums[left] == target) {
                    result[0] = left+1;
                    result[1] = right+1;
                    return result;
                }else if (nums[right] - nums[left] < target) break;
                else left++;
            }
            right++;
        }
        return result;
    }
}
