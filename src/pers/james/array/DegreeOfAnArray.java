package pers.james.array;

import java.util.HashMap;
import java.util.Map;

public class DegreeOfAnArray {
    public static void main(String[] args) {
        System.out.println(findShortestSubArray(new int[]{1}));
    }
    public static int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int maxFreq = -1, minLen = Integer.MAX_VALUE;
        String target = "";
        for (int i = 0; i < nums.length; i++){
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], 1);
            }else {
                int a = map.get(nums[i]) + 1;
                map.put(nums[i], a);
            }

        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()
             ) {
            int v = entry.getValue();
            if (v > maxFreq){
                maxFreq = v;
                target = entry.getKey().toString();
            }else if (v == maxFreq){
                target += "-" + (entry.getKey().toString());
            }
        }

        String[] sArray = target.split("-");
            for (String s : sArray
                 ) {
                int a = Integer.parseInt(s);
                int beginIndex = 0, endIndex = -1, count = 0;
                for (int i = 0; i < nums.length; i++){
                    if (count == map.get(a)){
                        endIndex = i - 1;
                        break;
                    }else if (nums[i] == a && i == nums.length -1){
                        endIndex = i;
                        break;
                    }else {
                        if (nums[i] == a){
                            if (count == 0){
                                beginIndex = i;
                            }
                            count++;
                        }
                    }
                }
                minLen = minLen > (endIndex - beginIndex + 1) ? endIndex - beginIndex + 1 : minLen;
            }
        return minLen;
    }
}
