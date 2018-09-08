package pers.james.array;

import java.util.Stack;

public class ShortestUnsortedContinuousSubarray {
    public static void main(String[] args) {
        int[] nums = {2,6,4,8,10,9,15};
        System.out.println(findUnsortedSubarray(nums));
    }
//    public static int findUnsortedSubarray(int[] nums) {
//        Stack< Integer > stack = new Stack < Integer > ();
//        int l = nums.length, r = 0;
//        for (int i = 0; i < nums.length; i++) {
//            while (!stack.isEmpty() && nums[stack.peek()] > nums[i])
//                l = Math.min(l, stack.pop());
//            stack.push(i);
//        }
//        stack.clear();
//        for (int i = nums.length - 1; i >= 0; i--) {
//            while (!stack.isEmpty() && nums[stack.peek()] < nums[i])
//                r = Math.max(r, stack.pop());
//            stack.push(i);
//        }
//        return r - l > 0 ? r - l + 1 : 0;
//    }

    public static int findUnsortedSubarray(int[] nums) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) min = Math.min(min, nums[i+1]);
        }
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] < nums[i - 1]) max = Math.max(max, nums[i-1]);
        }

        int l, r;



        for (l = 0; l < nums.length; l++) {
            if (min < nums[l]) break;
        }
        for (r = nums.length - 1; r >= 0; r--) {
            if (max > nums[r]) break;
        }
        return r - l < 0 ? 0 : r - l + 1;
    }
}
