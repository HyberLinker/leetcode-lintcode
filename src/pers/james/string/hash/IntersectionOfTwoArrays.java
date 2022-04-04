package pers.james.string.hash;

import java.util.HashSet;
import java.util.Set;

/**
 * 349. Intersection of Two Arrays
 * easy
 * @author JamesLiu
 * @date 2022年03月27日 10:42:00
 */
public class IntersectionOfTwoArrays {
    /**
     * set 作用
     * 1. 去重
     * 2. 验证存在性
     *
     * 算法
     * 1. 把nums1放入set1
     * 2. 声明set2
     * 3. 遍历nums2，如果元素存在于set1，则放入set2
     * 4. set2构造数组返回
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        for (int i : nums1) {
            set1.add(i);
        }
        Set<Integer> set2 = new HashSet<>();
        for (int i : nums2) {
            if (set1.contains(i)) {
                set2.add(i);
            }
        }
        int[] res = new int[set2.size()];
        int index = 0;
        for (Integer integer : set2) {
            res[index++] = integer;
        }
        return res;
    }
}
