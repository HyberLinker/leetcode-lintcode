package pers.james.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 11101526
 * @date 2021/3/24 18:27
 */
public class Triangle {
    public static int minimumTotal(List<List<Integer>> triangle) {
        int[][] dp = new int[triangle.size()][triangle.get(triangle.size()-1).size()];
        //初始化数组
        for (int i = 0; i < triangle.get(triangle.size() - 1).size(); i++) {
            dp[triangle.size() - 1][i] = triangle.get(triangle.size() - 1).get(i);
        }

        for (int i = triangle.size() - 2; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                dp[i][j] = Math.min(dp[i+1][j], dp[i+1][j+1]) + triangle.get(i).get(j);
            }
        }

        return dp[0][0];
    }

    public static void main(String[] args) {
        Integer[][] a = {{2},{3,4},{6,5,7},{4,1,8,3}};
        List<List<Integer>> ts = (List<List<Integer>>) twoDArrayToList(a);
        System.out.println(minimumTotal(ts));
    }


    public static <T> List<List<T>> twoDArrayToList(T[][] twoDArray) {
        return Arrays.stream(twoDArray)
                .map(Arrays::asList)
                .collect(Collectors.toList());
    }
}
