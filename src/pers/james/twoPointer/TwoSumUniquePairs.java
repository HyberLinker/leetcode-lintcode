package pers.james.twoPointer;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class TwoSumUniquePairs {
    //version1: hashset
    public int twoSum(int[] nums, int target){
//        Set<Integer> num1Set = new HashSet<>();
        int result = 0;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!set.contains(target-nums[i])){
                set.add(nums[i]);
            }else {
                if (!set.contains(nums[i])) {
                    result++;
                    set.add(nums[i]);
                }
                //如果nums=[7，7] target = 14
                if (nums[i] == target-nums[i]) result++;
            }
        }
        return result;
    }

    //version2：two pointers
    public int twoSumP(int[] nums, int target){
        int result = 0;
        Arrays.sort(nums);
        int left = 0, right = nums.length-1;
        while (left < right){
            if (nums[left] + nums[right] == target){
                if (left-1 >=0 && nums[left] != nums[left-1]){
                    result++;
                }else if (left == 0){
                    result++;
                }
                left++;
                right--;

            }else if (nums[left] + nums[right] > target) right--;
            else left++;
        }
        return result;
    }

}
