package pers.james.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return result;
        }
        Arrays.sort(candidates);

        help(candidates, target, 0, new ArrayList<Integer>(), result);


        return result;
    }

    private void help(int[] candidates,
                      int remainTarget,
                      int startIndex,
                      ArrayList<Integer> combination,
                      List<List<Integer>> result) {

        if (remainTarget == 0){
            result.add(new ArrayList<Integer>(combination));
        }

        for (int i = startIndex; i < candidates.length; i++){

            if (candidates[i] > remainTarget) break;
            /**
             * 如果，if条件中是i！=0，输入是[10,1,2,7,6,1,5]，8
             * 结果就会少个[1,1,6]，因为当发现前后两个1相同，就会把这个答案跳过
             * 所以，if (i != 0 && candidates[i] == candidates[i - 1]) continue；，是用来去candidates[]中的重复元素用的
             *
             * 我们当前是startIndex，说明上一个数是startIndex-1，也就是combination最后一个数的下标是startIndex-1 ，现在要选的
             * 是candidates[i]，说明candidates[i-1]一定是没被选中的，它不在combination并且candidates[i] == candidates[i - 1]，
             * 说明跳过了一个1去写下一个1。
             *
             * 选1，必须从第一个1开始选，不能跳过一个1选下一个1
             * 比如，[1,1,1,2], 4
             * [1',1'',2],[1',1''',2],[1'',1''',2],这里只能存在第一个
             *
             * 每层递归，都会有一个新的startIndex，只要不是第一次进这一层，当前数 = 前一个数，都跳过
             */
            if (i != startIndex && candidates[i] == candidates[i - 1]) continue;

            combination.add(candidates[i]);
            help(candidates, remainTarget - candidates[i], i + 1, combination, result);
            combination.remove(combination.size() - 1);

        }
    }
}
