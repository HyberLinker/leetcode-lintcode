package pers.james.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (candidates == null || candidates.length == 0) return result;
        Arrays.sort(candidates);

        help(candidates, target, 0, new ArrayList<Integer>(), result);

        return result;

    }

    private void help(int[] candidates,
                      int remainTarget,
                      int startIndex,
                      List<Integer> combination,
                      List<List<Integer>> result) {
        /**
         * 3. 递归的出口，用了一个深拷来赋值新数组
         */
        if (remainTarget == 0){
            result.add(new ArrayList<Integer>(combination));
            return;
        }

        /**
         * 2. 递归的拆解,
         * for loop中的每个数都会做一次combination的起点
         * 在每次以一个数为起点后，递归之后的结果
         * 完成递归后，remove这个数，开始以下一个数为起点的再一次过程
         */
        for (int i = startIndex; i < candidates.length; i++){
            /**
             * 当remainTarget为负数的时候return
             * 这里因为数组被排序过，只要当前的数已经大于remainTarget，那么剩下的数一定不会再加入combination了
             * break跳出以当前数为起点的循环，开始换下一个数作为起点
             */
            if (candidates[i] > remainTarget) break;
            /**
             * 去重，这道题不需要这步
             * 如果，前后出现重复数candidates = [1,1,1,2],就会跳过重复数
             * i！=0，是为了保证数组不越界
             */
            if (i != 0 && candidates[i] == candidates[i - 1]) continue;

            combination.add(candidates[i]);
            help(candidates, remainTarget - candidates[i], i, combination, result);
            combination.remove(combination.size() - 1);

        }
    }

    /**
     *
     * @param candidates 需要被去重的整型数组
     * @return nums 去重之后的整型数组
     *
     * index记录的是不重复数组的最后一个数
     *
     * for中，每一次用当前数，和去重后那段数组的最后一个数相比，如果不等，就加到index+1的位置，并且index移动到index+1；
     * 如果相等就跳过，只需要找到不重复的数即可
     */
    private int[] removeDuplicates(int[] candidates) {
        Arrays.sort(candidates);

        int index = 0;
        for (int i = 0; i < candidates.length; i++) {
            if (candidates[i] != candidates[index]) {
                candidates[++index] = candidates[i];
            }
        }

        int[] nums = new int[index + 1];
        for (int i = 0; i < index + 1; i++) {
            nums[i] = candidates[i];
        }

        return nums;
    }
}
