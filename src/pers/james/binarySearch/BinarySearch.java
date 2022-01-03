package pers.james.binarySearch;

public class BinarySearch {
    /**
     * 出自 代码随想录
     * 区间是[],左右都是闭
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        // 避免当 target 小于nums[0] nums[nums.length - 1]时多次循环运算
        if (target < nums[0] || target > nums[nums.length - 1]) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;// 定义target在左闭右闭的区间里，[left, right]
        while (left <= right) {  // 当left==right，区间[left, right]依然有效，所以用 <=
            int mid = left + (right - left)/2; // 防止溢出 等同于(left + right)/2
            if (nums[mid] > target) {
                right = mid - 1; // target 在左区间，所以[left, middle - 1]
            }else if (nums[mid] < target){
                left = mid + 1;// target 在右区间，所以[middle + 1, right]
            }else {
                return mid; // 数组中找到目标值，直接返回下标
            }
        }
        //没有找到
        return -1;
    }

    /**
     * 超时
     * 当left = right，并且nums[right] == target
     * 那么就会进入死循环
     * @param nums
     * @param target
     * @return
     */
    public static int searchChange(int[] nums, int target) {
        // 避免当 target 小于nums[0] nums[nums.length - 1]时多次循环运算
        if (target < nums[0] || target > nums[nums.length - 1]) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;// 定义target在左闭右闭的区间里，[left, right]
        while (left <= right) {  // 当left==right，区间[left, right]依然有效，所以用 <=
            int mid = left + (right - left)/2; // 防止溢出 等同于(left + right)/2
            if (nums[mid] > target) {
                right = mid - 1; // target 在左区间，所以[left, middle - 1]
            }else if (nums[mid] < target){
                left = mid + 1;// target 在右区间，所以[middle + 1, right]
            }else {
                right = mid;
            }
        }
        if (nums[right] == target) {
            return right;
        }
        if (nums[left] == target) {
            return left;
        }
        //没有找到
        return -1;
    }

    /**
     * 出自 代码随想录
     * 左闭右开区间[ )
     * @param nums
     * @param target
     * @return
     */
    public int search1(int[] nums, int target) {
        // 避免当 target 小于nums[0] nums[nums.length - 1]时多次循环运算
        if (target < nums[0] || target > nums[nums.length - 1]) {
            return -1;
        }
        int left = 0;
        int right = nums.length; //右边是开区间
        while (left < right) { //这里使用 < ,因为left == right在区间[left, right)是没有意义的
            int mid = left + (right - left)/2;
            if (nums[mid] > target) { // target 在左区间，在[left, middle)中
                right = mid;
            }else if (nums[mid] < target) {// target 在右区间，在[middle + 1, right)中
                left = mid + 1;
            }else {
                return mid;
            }
        }
        return -1;
    }

    /**
     * 出自 九章算法
     *
     * @param nums
     * @param target
     * @return
     */
    public int search2(int[] nums, int target) {
        // 避免当 target 小于nums[0] nums[nums.length - 1]时多次循环运算
        if (target < nums[0] || target > nums[nums.length - 1]) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left + 1 < right) { //left和right为相邻两个数就跳出循环
            int mid = left + (right - left)/2;
            if (nums[mid] > target) {
                right = mid;
            }else if (nums[mid] < target) {// target 在右区间，在[middle + 1, right)中
                left = mid;
            }else {
                //当nums[mid] == target，并不直接return mid，而是让right = mid或者left = mid，一直到while条件跳出。left和right相邻，然后再判断
                // 虽然没有直接return做剪枝，但是对于找到last和first这种题很方便
                right = mid;
            }
        }

        if (nums[left] == target) {
            return left;
        }
        if (nums[right] == target) {
            return right;
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {-1,0,3,5,9,12};
        int target = 9;
        searchChange(nums, target);
    }
}
