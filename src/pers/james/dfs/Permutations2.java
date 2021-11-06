package pers.james.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations2 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] isVisited = new boolean[nums.length];
        Arrays.sort(nums);
        helper(nums, new ArrayList<Integer>(), result, isVisited);
        return result;
    }

    public void helper(int[] nums, List<Integer> permutation, List<List<Integer>> result, boolean[] isVisited){
        if (permutation.size() == nums.length){
            result.add(new ArrayList<Integer>(permutation));
            return;
        }
        for (int i = 0; i < nums.length; i++) {

            if (isVisited[i]) continue;
            /**
             * continue 还是 break
             *
             * break 会跳出某一位选择的for loop，比如，[1', 1'', 2]选择第二个数的时候，如果遇到break，第二位数的选择就会跳过。
             * 由[] 到 选择[1'']的时候，进入递归，会进入if循环 if (i !=0 && nums[i] == nums[i - 1] && !isVisited[i-1]) break;
             * 如果此时break，就会跳过[2,1',1'']的这种排序；
             * continue的话，就会从[]->[2]
             */
            if (i !=0 && nums[i] == nums[i - 1] && !isVisited[i-1]) continue;

            permutation.add(nums[i]);
            isVisited[i] = true;
            helper(nums, permutation, result, isVisited);
            isVisited[i] = !isVisited[i];
            permutation.remove(permutation.size()-1);
        }
    }
}
