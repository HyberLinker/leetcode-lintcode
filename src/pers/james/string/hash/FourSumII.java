package pers.james.string.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * 454. 4Sum II
 * medium
 * @author JamesLiu
 * @date 2022年03月27日 11:19:00
 */
public class FourSumII {
    /**
     * 这道题
     * 1. 是分成四个数组， 不是同一个数组的四个数
     * 2. 不关心重复数，也就是结果的四元组，是可以取任意数的，只要和相同（index肯定是不能全部相同，才算一个结果）
     * 所以这个题和3sum4sum完全不同，这道题更简单点
     * 进阶：如果就是给出一个数组（而不是四个数组），在这里找出四个元素相加等于0，答案中不可以包含重复的四元组
     * 
     * 思路
     * 1. 构造map，key为nums1+nums2两数之和，value为key出现的次数
     * 2. 双循环遍历nums1和nums2，填充map
     * 3. 设置int res计数结果
     * 4. 双循环遍历nums3和nums4，每个组合取0-(nums3+nums4)是否存在于map中，如果存在则取map的value，用res计数
     * @param nums1
     * @param nums2
     * @param nums3
     * @param nums4
     * @return
     */
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num1 : nums1) {
            for (int num2 : nums2) {
                int preSum = num1 + num2;
                map.put(preSum, map.getOrDefault(preSum, 0) + 1);
            }
        }
        int res = 0;
        for (int num3 : nums3) {
            for (int num4 : nums4) {
                int left = 0 - (num3 + num4);
                if (map.containsKey(left)) {
                    res += map.get(left);
                }
            }
        }
        return res;
    }
}
