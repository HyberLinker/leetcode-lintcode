package pers.james.array;

import java.util.HashSet;
import java.util.Set;

public class ArrayNesting {
    public static void main(String[] args) {
        int[] nums = {5,4,0,3,1,6,2};
//        System.out.println(arrayNesting(nums));
//        boolean[] b = new boolean[1];
        int[] b = new int[1];
        System.out.println(b[0]);
    }
    public static int arrayNesting(int[] nums) {
        int len = nums.length, ans = 0;

        for (int i = 0; i < len; i++){
            Set<Integer> set = new HashSet<>();
            int current = i;
            while (!set.contains(current)){
                set.add(current);
                current = nums[current];
            }

            ans = Math.max(ans, set.size());
        }
        return ans;
    }

    public static int arrayNesting1(int[] nums) {
        int len = nums.length, ans = 0;
        int[] visited = new int[len];
        for (int i = 0; i < len; i++){
            if (visited[i] == 0){
                int start = nums[i], count = 0;
                do {
                    start = nums[start];
                    count++;
                    visited[start] = 1;
                }while (start != nums[i]);
                ans = Math.max(ans,count);
            }
        }
        return ans;
    }
}
