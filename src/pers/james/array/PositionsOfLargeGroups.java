package pers.james.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PositionsOfLargeGroups {
    public List<List<Integer>> largeGroupPositions(String S) {
        List<List<Integer>> ans = new ArrayList<>();
        int start = 0;
        for (int i = 0; i < S.length(); i++){
            if (i == S.length() - 1 || S.charAt(i) != S.charAt(i+1)){
                if (i - start + 1 >= 3) ans.add(Arrays.asList(new Integer[]{start, i}));
                start = i + 1;
            }
        }
        return ans;
    }
}
