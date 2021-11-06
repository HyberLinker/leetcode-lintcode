package pers.james.twoPointer;

public class MoveZeros {
    public void moveZeroes(int[] nums) {
        if (nums.length == 0 || nums == null) return;
        int index = 0, searchPointer = 0;
        for ( ; searchPointer < nums.length; searchPointer++) {
            if (nums[searchPointer] != 0){
                int temp = nums[searchPointer];
                nums[searchPointer] = nums[index];
                nums[index++] = temp;
            }
        }
    }
}
