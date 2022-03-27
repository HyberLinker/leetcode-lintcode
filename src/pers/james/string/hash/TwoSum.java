package pers.james.string.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * 1. Two Sum
 * easy
 * @author JamesLiu
 * @date 2022年03月26日 22:26:00
 */
public class TwoSum {
    /**
     * 时间复杂度O1，空间复杂度On
     * 1. 使用map，key存放nums中的数，value是对应的index
     * 2. 遍历nums，先把当前的key value存入map，然后再
     * 3. 寻找map是否有target-nums[i] 的key，如果有，且对应的value不同，则返回这两个index（无序）
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                Integer index2 = map.get(target - nums[i]);
                res[0] = i;
                res[1] = map.get(target - nums[i]);
                return res;
            }
            map.put(nums[i], i);//有重复key直接覆盖，不影响结果，答案是只要找出一对下标即可。
            // put放到if后面，可以不用考虑判断index是否是同一个位置。因为每次put都是i的下一个位置了
        }
        return res;
    }
}
