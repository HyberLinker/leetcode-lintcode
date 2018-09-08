package pers.james.array;

import java.util.HashMap;
import java.util.Map;

public class KdiffPairsInAnArray {
    public int findPairs(int[] nums, int k) {
        int len = nums.length, ans = 0;
        if (nums == null || len == 0 || k < 0) return ans;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i:nums
             ) {
            if (map.containsKey(i)){
                map.put(i, map.get(i)+1);
            }else {
                map.put(i, 1);
            }
        }

        for (Map.Entry<Integer, Integer> entry:map.entrySet()
             ) {
            if (k == 0){
                if (entry.getValue() >= 2){
                    ans++;
                }
            }else if (map.containsKey(entry.getKey()+k)) ans++;
        }
        return ans;
    }
}
