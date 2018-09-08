package pers.james.array;

public class MaximumProductOfThreeNumbers {

    public static void main(String[] args) {
        int[] nums = {-4,-3,-2,-1,60};
        maximumProduct(nums);
    }
    public static int maximumProduct(int[] nums) {
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;

        for (int c:nums
             ) {
            if (c <= min1){
                min2 = min1;
                min1 = c;
            }else if (c <= min2) min2 = c;

//            if (c >= max3) max3 = c;
//            else if (c >= max2){
//                max3 = max2;
//                max2 = c;
//            }else if (c >= max1){
//                max3 = max2;
//                max2 = max1;
//                max1 = c;

            /**
             * 比较max1,max2,max3的先后顺序不能变，else if不能只用if
             */
            if (c >= max1){
                max3 = max2;
                max2 = max1;
                max1 = c;
            }else if (c >= max2){
                max3 = max2;
                max2 = c;
            }else if (c >= max3) max3 = c;
        }
        return Math.max(min1*min2*max1, max1*max2*max3);
    }
}

