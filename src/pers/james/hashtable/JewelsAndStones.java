package pers.james.hashtable;

import java.util.HashSet;
import java.util.Set;

public class JewelsAndStones {
    public int numJewelsInStones(String J, String S) {
        int lenj = J.length(), lens = S.length();
        int ans = 0;
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < lenj; i++){
            set.add(J.charAt(i));
        }
        for (int i = 0; i < lens; i++){
            if (set.contains(S.charAt(i))){
                ans++;
            }
        }
        return ans;
    }
}
