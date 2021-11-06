package pers.james.twoPointer;

public class SortColors {
    /**
     * One-pass algorithm
     * 把0都放到左边，2都放到右边，剩下的1自然就在中间
     * @param nums
     */
    public void sortColors(int[] nums) {
        int left = 0, right = nums.length-1, i = 0;
        while (i <= right){
            if (nums[i] == 0){
                swap(nums, i, left);
                left++;
                i++;
            }else if (nums[i] == 1){
                i++;
            }else {
                swap(nums, i, right);
                right--;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }

    public static void main(String[] args) {
        SortColors s = new SortColors();
        int[] nums = {2,0,1};
        s.sortColors(nums);
    }

    // 还有另外两种方法：
    // 1. 用两次partition array，把大于0的放右边，然后再把大于1的放右边
    // 2. counting sort，记录0，1，2分别出现的个数，然后再重写nums数组
}
