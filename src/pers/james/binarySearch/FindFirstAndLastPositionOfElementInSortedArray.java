package pers.james.binarySearch;

import java.util.Objects;

public class FindFirstAndLastPositionOfElementInSortedArray {
    public static int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};
        if (Objects.isNull(nums) | nums.length == 0) {
            return result;
        }

        // find first
        int start = 0;
        int end = nums.length - 1;
        int mid = -1;
        int temp = -1;


        while (start + 1 < end) {
            mid = start + (end - start)/2;;
            temp = nums[mid];
            if (temp == target) {
                end = mid;
            }else if (temp < target) {
                start = mid;
            }else {
                end = mid;
            }
        }

        //start位置符合target，跳过判断end位置
        if (nums[start] == target) {
            result[0] = start;
        }else if (nums[end] == target) {
            result[0] = end;
        }

        //find last
        start = 0;
        end = nums.length - 1;

        while (start + 1 < end) {
            //先计算mid，再取出mid位置的值
            mid = start + (end - start)/2;
            temp = nums[mid];

            if (temp == target) {
                start = mid;
            }else if (temp < target) {
                start = mid;
            }else {
                end = mid;
            }
        }

        if (nums[end] == target) {
            result[1] = end;
        }else if (nums[start] == target) {
            result[1] = start;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,3,3,3,4,5,9};
        int target = 3;
        int[] ints = searchRange(nums, target);
        for (int i : ints) {
            System.out.println(i);
        }
    }
}
