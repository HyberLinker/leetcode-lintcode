package pers.james.dfs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
//        helper(nums, result, new ArrayList<Integer>(), new HashSet<Integer>());

        boolean[] isVisited = new boolean[nums.length];
        withoutSet(nums, result, new ArrayList<Integer>(), isVisited);
        return result;
    }

    private void helper(int[] nums, List<List<Integer>> result, List<Integer> permutation, Set<Integer> set){
        if (permutation.size() == nums.length){
            result.add(new ArrayList<Integer>(permutation));
            return;
        }
        for (int i = 0; i < nums.length; i++) {

            if (set.contains(nums[i])) continue;

            permutation.add(nums[i]);
            set.add(nums[i]);
            helper(nums, result, permutation, set);
            set.remove(nums[i]);
            permutation.remove(permutation.size()-1);
        }
    }

    //faster than using set
    //set查找的时候，不是o（1）的时间，而是o（size of string）的时间
    private void withoutSet(int[] nums, List<List<Integer>> result, List<Integer> permutation, boolean[] isVisited){
        if (permutation.size() == nums.length){
            result.add(new ArrayList<Integer>(permutation));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (isVisited[i]) continue;

            permutation.add(nums[i]);
            isVisited[i] = true;
            withoutSet(nums, result, permutation, isVisited);
            isVisited[i] = !isVisited[i];
            permutation.remove(permutation.size()-1);
        }
    }

    public static void main(String[] args) {
        boolean[] isVisited = new boolean[3];
        System.out.println(isVisited[1]);

    }
}
