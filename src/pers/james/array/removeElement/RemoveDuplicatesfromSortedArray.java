package pers.james.array.removeElement;


/**
 * 26. Remove Duplicates from Sorted Array
 * easy
 */
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

    /**
     * 2022.1.15
     * 以下思路是建立在，数组是单调的（有序递增，有序递减）
     * left=right=0开始
     * right寻找不等于left的数
     * 当nums[right] != nums[left], left+1 的位置赋值 nums[right]
     * 当nums[right] == nums[left], right向前+1，继续搜索
     * @param nums
     * @return
     */
    public static int removeDuplicates1(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] != nums[left]) {
                nums[++left] = nums[right];
            }
        }
        return left + 1; //left存储的是最后一个我们要找的数的index
    }
}
