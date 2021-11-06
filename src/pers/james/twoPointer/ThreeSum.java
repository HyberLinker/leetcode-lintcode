package pers.james.twoPointer;

import java.util.*;

public class ThreeSum {
    // version1: hashset(不知道怎么去重)
    //比如[0,0,0] 结果出来是[[0,0,0],[0,0,0]]
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length-2; i++) {
            if (i > 0 && nums[i] == nums[i-1]) continue;
            int c = -nums[i];
            Set<Integer> set = new HashSet<>();
            for (int j = i+1; j < nums.length; j++) {
//                if (j > 0 && nums[j] == nums[j-1]) continue;
                if (!set.contains(c - nums[j])){
                    set.add(nums[j]);
                }else {
                    List<Integer> triplet = new ArrayList<>();
                    triplet.add(nums[j]);
                    triplet.add(c - nums[j]);
                    triplet.add(-c);
                    result.add(triplet);
                }
            }
        }
        return result;
    }

    //version2: two pointers
    public List<List<Integer>> threeSum1(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i-1]) continue;
            int c = -nums[i];
            int left = i + 1, right = nums.length-1;
            while (left < right){
                if (nums[left] + nums[right] == c){
                    List<Integer> triplet = new ArrayList<>();
                    triplet.add(-c);
                    triplet.add(nums[left]);
                    triplet.add(nums[right]);
                    result.add(triplet);
                    right--;
                    left++;

                    while (left < right && nums[left] == nums[left-1]) left++;
                    while (left < right && nums[right] == nums[right+1]) right--;
                }else if (nums[left] + nums[right] > c) right--;
                else left++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ThreeSum t = new ThreeSum();
        int[] nums = {-1, 0, 1, 2, -1, -4};
        t.threeSum(nums);
    }
}
