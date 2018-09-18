package pers.james.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }
//    public static int lengthOfLongestSubstring(String s) {
//        int n = s.length(), ans = 0;
//        Map<Character, Integer> map = new HashMap<>(); // current index of character
//        // try to extend the range [i, j]
//        for (int j = 0, i = 0; j < n; j++) {
//            if (!map.containsKey(s.charAt(j))){
//                map.put(s.charAt(j), j);
//                ans = Math.max(j - i + 1, ans);
//            }else {
//                i = map.get(s.charAt(j)) + 1;
//                j = i - 1;
//                map.clear();
//            }
//        }
//        return ans;
//    }

    /**
     * 当再[i,j]中找到重复数，一定是j和j*重复（j*在[i,j)范围内），那么就可以跳过前[i,j*]，从j*+1开始继续
     * 区别在于，在[j*+1,j]范围中，不需要从j*+1再检查一边了（j不需要变，只用变i）
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j))+1, i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j);
        }
        return ans;
    }
}
