package pers.james.binarySearch;

/**
 * @author 11101526
 * @date 2021/3/5 17:31
 */
public class FindMinimumInRotatedSortedArrayII {
    public int findMin(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        int mid;
        while (start + 1 < end) {
            mid = start + (end - start)/2;
            if (nums[end] > nums[mid]) {
                end = mid;
            }else if (nums[end] < nums[mid]){
                start = mid;
            }else {
                end -= 1;
            }
        }

        if (nums[start] > nums[end]) {
            return nums[end];
        }

        return nums[start];
    }
}
