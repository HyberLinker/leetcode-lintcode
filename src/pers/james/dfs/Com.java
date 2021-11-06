package pers.james.dfs;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 现有input.size组数据，要求从每个数据中选出一个数，组成一个组合
 * 求，一共有多少中组合，打印所有的组合
 */
public class Com {
    public List<List<Integer>> solution(List<List<Integer>> input){
        List<List<Integer>> result = new ArrayList<>();
        dfs(input, new ArrayList<Integer>(), 0, result);
        return result;
    }

    private void dfs(List<List<Integer>> input, List<Integer> combination, int startIndex, List<List<Integer>> result) {

        if (combination.size() == input.size()) {
            List<Integer> l = new ArrayList<>(combination);
            for (Integer i:l
                 ) {
                System.out.print("-"+i);
            }
            System.out.println();
            result.add(l);
            return;
        }
        for (int i = startIndex; i < input.size(); i++) {
            for (int j = 0; j < input.get(i).size(); j++) {
                combination.add(input.get(i).get(j));
                dfs(input, combination, i+1, result);
                combination.remove(combination.size()-1);
            }
        }
    }

    public static void main(String[] args) {
//        List<List<Integer>> input = new ArrayList<>();
//        List<Integer> level = new ArrayList<>();
//        level.add(1);
//        level.add(2);
//        level.add(3);
//        input.add(new ArrayList<Integer>(level));
//        level.clear();
//        level.add(20);
//        level.add(21);
//        level.add(22);
//        input.add(new ArrayList<Integer>(level));
//        level.clear();
//        level.add(300);
//        level.add(301);
//        level.add(302);
//        input.add(new ArrayList<Integer>(level));
//
//        List<List<Integer>> result = new Com().solution(input);
        String s = null;
        String s1 = handleOrder(s);
        System.out.println(s);
        System.out.println(s1);


    }

    private static String handleOrder(String order) {
        if (order == null) {
            order = "O.lm_ts desc";
        } else if (order.indexOf("start_ts") != -1) {
            order = "P." + order;
        } else if (order.indexOf("end_ts") != -1) {
            order = "P." + order;
        } else {
            order = "O." + order;
        }
        return order;
    }
}
