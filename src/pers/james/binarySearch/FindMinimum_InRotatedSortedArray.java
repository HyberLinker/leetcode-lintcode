package pers.james.binarySearch;

public class FindMinimum_InRotatedSortedArray {
    public int findMin(int[] nums){
        int start = 0, end = nums.length - 1;

        while (start + 1 < end){
            int mid = start + (end - start)/2;
            if (nums[mid] <= nums[nums.length-1]){
                end = mid;
            }else start = mid;
        }

        if (start <= nums[nums.length-1]) return nums[start];
        else return nums[end];
    }

    public static void main(String[] args) {
        FindMinimum_InRotatedSortedArray f = new FindMinimum_InRotatedSortedArray();
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        System.out.println(f.findMin(nums));
    }
}
