package pers.james.binarySearch;

import java.util.Objects;

public class FindFirstAndLastPositionOfElementInSortedArray {
    /**
     * 这个使用的是九章的末班
     * 1. while 是保留两个相邻的left和right
     * 2. while循环后要单独对left和right进行判断
     * @param nums
     * @param target
     * @return
     */
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
        int[] ints = searchRange1(nums, target);
        for (int i : ints) {
            System.out.println(i);
        }
    }

    /**
     * 2022.1.3
     * 思路都一样，找一遍first，再找一遍last
     * 但是while的逻辑变动 left<right, 保证出循环后left=right,区间中只有一个数
     * @param nums
     * @param target
     * @return
     */
    public static int[] searchRange1(int[] nums, int target) {
        int[] res = new int[2];
        int left = 0;
        int right = nums.length - 1;
        //first
        while (left < right) {
            int mid = left + (right - left)/2;
            if (nums[mid] > target) {
                right = mid - 1;
            }else if (nums[mid] < target) {
                left = mid + 1;
            }else {
                right = mid;
            }
            System.out.printf("find first: left【%d】, right【%d】\n", left, right);
        }
        if (nums[left] == target) {
            res[0] = left;
        }else {
            res[0] = -1;
        }


        left = 0;
        right = nums.length - 1;
        //last
        while (left < right) {
            int mid = left + (right - left)/2 + 1; //有left=mid这种情况出现，如果出现超时，就要+1
            if (nums[mid] > target) {
                right = mid - 1;
            }else if (nums[mid] < target) {
                left = mid + 1;
            }else {
                left = mid;
            }
            System.out.printf("find last: left【%d】, right【%d】\n", left, right);
        }
        if (nums[left] == target) {
            res[1] = left;
        }else {
            res[1] = -1;
        }
        return res;
    }
}
