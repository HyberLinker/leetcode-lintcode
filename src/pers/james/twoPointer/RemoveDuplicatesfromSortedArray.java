package pers.james.twoPointer;

public class RemoveDuplicatesfromSortedArray {
    public static int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int lastNonDup = 0, searchPointer = 0;
        for (; searchPointer < nums.length; searchPointer++) {
            if (nums[searchPointer] != nums[lastNonDup]){
                nums[++lastNonDup] = nums[searchPointer];
            }
        }
        return lastNonDup+1;
    }
}
