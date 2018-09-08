package pers.james.array;

public class FindPivotIndex {
    public static void main(String[] args) {
        int[] nums = {-1,-1,-1,-1};
        System.out.println(pivotIndex(nums));
    }
    public static int pivotIndex(int[] nums) {
        int len = nums.length, sum = 0, target = 0;
        for (int i = 0; i < len; i++){
            sum += nums[i];
        }
        for (int i = 0; i < len; i++){
            if ((sum - nums[i])%2 == 0 ){
                target = (sum - nums[i])/2;
                if (i < len/2){
                    int sum1 = 0;
                    for (int j = 0; j < i; j++){
                        sum1 += nums[j];
                    }
                    if (sum1 == target){
                        return i;
                    }
                }else {
                    int sum1 = 0;
                    for (int j = len - 1; j > i; j--){
                        sum1 += nums[j];
                    }
                    if (sum1 == target){
                        return i;
                    }
                }
            }else continue;
        }
        return -1;
    }
}
