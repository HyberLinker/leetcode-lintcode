package pers.james.binarySearch;

public class SearchInRotatedSortedArray {
    public static void main(String[] args) {

        int[] nums = {4,5,6,7,0,1,2};
        System.out.println(search1(nums, 0));
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

    public static int search1(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int mid;
        while (start + 1 < end) {
            mid = start + (end - start)/2;
            //先看mid落在哪一段
            if (nums[mid] > nums[end]) {
                //再看target在哪
                //必须把范围都包括进去，不然会死循环end 和 start在每次while都至少一个移动才可以
                if (target <= nums[mid] && target >= nums[start]) {
                    end = mid;
                }else {
                    start = mid;
                }
            }else{
                if (target >= nums[mid] && target <= nums[end]) {
                    start = mid;
                }else{
                    end = mid;
                }
            }
        }

        if (nums[start] == target) {
            return start;
        }

        if (nums[end] == target) {
            return end;
        }
        return -1;
    }

}
