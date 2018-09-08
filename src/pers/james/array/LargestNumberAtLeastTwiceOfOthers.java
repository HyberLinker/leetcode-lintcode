package pers.james.array;

public class LargestNumberAtLeastTwiceOfOthers {
    public static void main(String[] args) {
        int[] nums = {0,0,2,3};
        dominantIndex(nums);
    }
    public static int dominantIndex(int[] nums) {
        if(nums.length == 1) return 0;
        int maxIndex = 0;
        for (int i = 0; i < nums.length; i++){
            if (nums[i] > nums[maxIndex]) maxIndex = i;
        }

        for (int i = 0; i < nums.length; i++){
            if (nums[i] * 2 > nums[maxIndex] && maxIndex != i) return -1;
        }
        return maxIndex;
    }
}
