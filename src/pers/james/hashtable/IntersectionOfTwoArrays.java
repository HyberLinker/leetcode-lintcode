package pers.james.hashtable;

import java.util.HashSet;
import java.util.Set;

public class IntersectionOfTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> set1 = new HashSet<>();
        int[] ans = null;

        for (int i = 0; i < nums1.length; i++){
            set.add(nums1[i]);
        }

        for (int i = 0; i < nums2.length; i++){
            if (set.contains(nums2[i])){
                set1.add(nums2[i]);
            }
        }
        ans = new int[set1.size()];
        int j = 0;
        for (int i : set1){
            ans[j++] = i;
        }
        return ans;
    }
}
