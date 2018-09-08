package pers.james.binarySearch;

public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        int[] nums = {5,1,3};
        System.out.println(search(nums, 5));
    }
    public static int search(int[] nums, int target) {
        int len = nums.length;
        int start = 0, end = len - 1;
        if (nums == null || len == 0) return -1;
        while(start + 1 < end){
            int mid = start + (end - start)/2;

            if (nums[mid] >= nums[start]){  //或者 nums[mid] > nums[end]
                if (target >= nums[start] && target <= nums[mid]){
                    end = mid;
                }else{
                    start = mid;
                }
            }else {
                if (nums[mid] <= target && target <= nums[end]){
                    start = mid;
                }else {
                    end = mid;
                }
            }
        }

        if (nums[end] == target) return end;
        else if (nums[start] == target)return start;
        else return -1;
    }
}
