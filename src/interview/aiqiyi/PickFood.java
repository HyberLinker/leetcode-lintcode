package interview.aiqiyi;

import java.util.*;

public class PickFood {
    static int result = 0;
    public int combination(int[] foods) {

        if (foods == null || foods.length == 0) return result;

        help(foods, 0, new ArrayList<Integer>());

        return result;

    }

    private void help(int[] foods,
                      int startIndex,
                      List<Integer> combination) {
        /**
         * 递归出口
         * 当选过最后一个食物时，说明找到一种组合，将result+1
         * 返回上一层
         */
        if (startIndex > foods.length - 1){
            result++;
            //打印，debug
//            for (Integer i:combination
//                    ) {
//                System.out.print("-"+i);
//            }
//            System.out.println();
            return;
        }
        /**
         * 题中，可能出来截断的组合，比如，int[] foods = {1,2,3,4,5}，已经找到{1，3，5}，通过出口退回{1，3}，这个时候for中i+1=5，
         * 如果写成for (int i = startIndex; i < foods.length; i++)就进不了for循环了，会直接跑到42行，返回到{1}
         * 但是，如果这样，就会把{1，3}这个结果跳过去，同理，单个的{1}，{2}.{3}这些结果也会跳过
         *
         * 所以，for改成 for (int i = startIndex; i <= foods.length; i++) 并添加一个递归出口
         */
        for (int i = startIndex; i <= foods.length; i++){
            if (i == foods.length){
                result++;
                //打印，debug
//                for (Integer j:combination
//                        ) {
//                    System.out.print("-"+j);
//                }
//                System.out.println();
                return;
            }
            combination.add(foods[i]);
            help(foods, i + 2, combination);
            combination.remove(combination.size() - 1);
        }
    }

    public static void main(String[] args) {
        PickFood c = new PickFood();
        int[] foods = {1,2,3,4,5,6};
        System.out.println(c.combination(foods));
        System.out.println(c.bfs(foods));
    }

    /**
     * bfs
     * 不能包括一个food都不选的情况，所以最后结果手动加一
     * @param foods
     * @return
     */
    private int bfs(int[] foods){
        int result = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < foods.length; i++) {
            queue.offer(i);
        }
        while (!queue.isEmpty()){
            int curt = queue.poll();
            result++;
            for (int i = curt + 2; i < foods.length; i++) {
                queue.offer(i);
            }
        }
        return result + 1;
    }

}
