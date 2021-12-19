package pers.james.on;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class LongestConsecutiveSequence {
    /**
     * 算法时间看着像是 for嵌套 while n^2，但是，有个if判断，只有在数字为当前序列的第一个数才会进行while
     * 所以while只运行了 n次，总时间是 o（n+n） = o（n）
     * 这里while只运行了n次，指的是while循环了n次，每个for都会调用while，但是while只循环了n次。
     * 可以想象一下，如果while在第一个数，循环了10次，那么会有10个数在for到的时候，不会进入while循环。
     * @param nums
     * @return
     */
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int maxLen = 1;
        for (Integer integer : set) {
            if (!set.contains(integer - 1)) { //这步逻辑异常重要，没有就会超时；这步是找到当前数字没有先序数字在set中，意味着当前数字是目前寻找序列的第一个数
                int bigger = integer;
                int len = 1;
                while (set.contains(++bigger)) {
                    len++;
                }
                maxLen = Math.max(maxLen, len);
            }
        }
        return maxLen;
    }
}
