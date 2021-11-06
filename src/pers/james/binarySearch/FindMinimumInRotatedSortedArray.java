package pers.james.binarySearch;

/**
 * @author 11101526
 * @date 2021/3/5 16:25
 */
public class FindMinimumInRotatedSortedArray {
    public int findMin(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        int mid;
        while (start + 1 < end) {
            mid = start + (end - start)/2;
            //使用end，<= end
            if (nums[end] >= nums[mid]) {
                end = mid;
            }else {
                start = mid;
            }
        }

        if (nums[start] > nums[end]) {
            return nums[end];
        }else {
            return nums[start];
        }
    }
}
