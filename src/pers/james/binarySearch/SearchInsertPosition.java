package pers.james.binarySearch;

/**
 * 35. Search Insert Position
 * esay
 */
public class SearchInsertPosition {
    /**
     * 刷 代码随想录 的时候，看leetcode中文社区的一个最高分题解。思路无关所谓的区间不变性
     *
     * 1. 抽象成找第一个大于等于target数的index nums[pos-1] < target <= nums[pos]
     * 2. 注意while left<right, 退出循环left=right
     * 3. 注意mid取值是否要加1（出现left=mid需要+1）不然会死循环
     * 4. 区间变化left,right取值
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        //当target大于最右边的数，这个index已经超出[0, nums.length - 1]的范围了，所以要单独拎出来
        if (target > nums[right]) {
            return right + 1;
        }
        //寻找[0, nums.length - 1]满足条件的index
        while (left < right) {
            int mid = left + (right - left)/2;
            if (nums[mid] > target) {
                right = mid;
            }else if (nums[mid] < target) {
                left = mid + 1;
            }else {
                right = mid;
            }
        }
        return left;
    }
}
