package pers.james.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MaximumAverageSubarrayI {
    public static void main(String[] args) {
        Integer[] nums = {10,27,3};
        String[] a = {"1","20","3"};
        List list = Arrays.asList(nums);
        Collections.sort(list);
        System.out.println(list);
//        System.out.println(Arrays.asList(nums).get(0).getClass());
//
//        for (Object i:list
//             ) {
//            System.out.println(i);
//        }

    }
    public double findMaxAverage(int[] nums, int k) {
        int len = nums.length;
        int[] sums = new int[len];
        sums[0] = nums[0];
        for (int i = 1; i < len; i++) sums[i] = sums[i-1] + nums[i];

        double ans = sums[k - 1]*1.0/k;

        for (int i = k; i < len; i++) ans = Math.max(ans, (sums[i] - sums[i - k])*1.0/k);
        return ans;
    }
}
