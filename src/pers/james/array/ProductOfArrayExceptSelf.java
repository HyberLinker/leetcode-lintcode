package pers.james.array;

public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];//第一遍循环后，存的是左边所有数的累积（不包括当前i）
        res[0] = 1;
        for (int i = 1; i < len; i++){
            res[i] = res[i-1]*nums[i-1];
        }

        int right = 1;
        for (int i = len - 1; i >= 0; i--){
            res[i] *= right;
            right *= nums[i];
        }
        return res;
    }
}
