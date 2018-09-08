package pers.james.array;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicateII {
    public static void main(String[] args) {
        int[] nums = {1,2,3,1,2,3};
        int k = 2;
//        System.out.println(containsNearbyDuplicate(nums,k));
    }
//    public static boolean containsNearbyDuplicate(int[] nums, int k) {
//        int len = nums.length;
//
//        for (int j = 0; j < len - k; j++){
//            if (nums[j] == nums[j+k]) return true;
//        }
//
//        return false;
//    }

//    public static boolean containsNearbyDuplicate(int[] nums, int k) {
//        Set<Integer> set = new HashSet<Integer>();
//        for(int i = 0; i < nums.length; i++){
//            if(i > k) set.remove(nums[i-k-1]); //remove element if its distance to nums[i] is not lesser than k
//            if(!set.add(nums[i])) return true; //because all still existed elements is closer than k distance to the num[i],
//                                                // therefore if the add() return false, it means there's a same value element
//                                                // already existed within the distance k,
//                                                // therefore return true.
//        }
//        return false;
//    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++){
            if (i > k) {
                set.remove(nums[i - k - 1]);
            }
            boolean b = set.add(nums[i]);

            if (!b) return true;

        }
        return false;
    }
}
