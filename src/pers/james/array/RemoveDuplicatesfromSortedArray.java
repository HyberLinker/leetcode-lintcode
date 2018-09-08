package pers.james.array;

public class RemoveDuplicatesfromSortedArray {
    public static void main(String[] args) {
        int[] nums = {0,0,0,1,2,2,3};
        removeDuplicates(nums);
    }
    public static int removeDuplicates(int[] nums) {
        int len = nums.length;
        if (len == 0) return 0;
        int num = 0, current = nums[0], i = 0;
        for (int j = 1; j < len; j++){
            if (nums[j] == current) {
                num++;
                continue;
            }
            nums[i+1] = nums[j];
            current = nums[j];
            i++;
        }
        return len - num;
    }
}
