package pers.james.array;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {
    public static void main(String[] args) {
        int[] nums = {0,0,1,0};
        System.out.println(subarraySum(nums, 0));
    }
    /**
     * 我的方法，并不好使
     */
//    public static int subarraySum(int[] nums, int k) {
//        int  ans = 0, begin = 0, sum = 0;
//        if (nums.length == 1) {
//            if (nums[0] == k) return 1;
//            else return 0;
//        }
//
//        if (k == 0){
//            int i = 0, j = 0, sum1 = 0;
//            for (i = 0; i < nums.length; i++){
//                if (nums[i] != 0){
//                    sum1 += ((i - j + 1 - 1)+1)*(i-j+1)/2;
//                    j = i + 1;
//                }else continue;
//            }
//            return sum1;
//        }
//
//        for (int i = 0; i < nums.length && begin < nums.length; i++){
//            sum += nums[i];
//            if (sum == k){
//                ans++;
//                if (i != nums.length - 1){
//                    if (nums[i+1] == nums[begin]) {
//                        ans++;
//                        begin++;
//                        i++;
//                    }else if (nums[i+1] > nums[begin]){
//                        i = begin;
//                        begin++;
//                        sum = 0;
//                        continue;
//                    }else if (nums[i+1] < nums[begin]){
//                        continue;
//                    }
//                }else {
//                    if (begin != nums.length){
//                        i = begin;
//                        begin++;
//                        continue;
//                    }else break;
//                }
//            }else{
//                if (i == nums.length - 1){
//                    i = begin;
//                    begin++;
//                    sum = 0;
//                }else continue;
//
//            }
//        }
//        return ans;
//    }
    /**
     * 二层循环
     */
    public static int subarraySum(int[] nums, int k){
        int len = nums.length, ans = 0;
        for (int i=0; i < len; i++){
            int sum = 0;
            for (int j = i; j < len; j++){
                sum += nums[j];
                if (sum == k) ans++;
            }
        }
        return ans;
    }

    /**
     *  cummulative sum
     */
    public static int subarraySum1(int[] nums, int k){
        int len = nums.length, ans = 0;
        int[] sum = new int[len];
        sum[0] = 0;
        //{3,4,7,2,-3,1,4,2} k=7,考虑indice=2，如果不把sum[0]赋值成0
        //就会漏过前两个数，他们的和也为7

        for(int i = 1; i < len; i++){
            sum[i] = sum[i-1]+nums[i-1];
        }

        for (int i = 0; i < len; i++){
            for (int j=0; j < len; j++){
                if (sum[j]-sum[i] == k) ans++;
            }
        }
        return ans;
    }


    /**
     * 利用hashmap
     * @param nums
     * @param k
     * @return
     */
    //例子，{3,4,7,7,-8,1,4,3}
    public static int subarraySum2(int[] nums, int k){
        int ans = 0, len = nums.length, sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); //sum[i] - k = 0 的情况要考虑到
        for (int i = 0; i < len; i++){
            sum += nums[0];
            if (map.containsKey(sum - k)){
                ans += map.get(sum - k);
            }

            if (!map.containsKey(sum)) map.put(sum, 1);
            else map.put(sum, map.get(sum)+1);
        }
        return ans;
    }
}
