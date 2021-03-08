package pers.james.binarySearch;

/**
 * @author 11101526
 * @date 2021/3/5 18:02
 */
public class FindPeakElement {
    public static int findPeakElement(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        int mid;
        while (start + 1 < end) {
            mid = start + (end - start)/2;
            if (nums[mid] > nums[mid - 1]) {
                start = mid;
            }else {
                end = mid;
            }
        }

        if (nums[start] > nums[end]) {
            return start;
        }
        return end;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        System.out.println(findPeakElement(nums));
    }
}
