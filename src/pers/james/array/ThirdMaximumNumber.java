package pers.james.array;

public class ThirdMaximumNumber {
    public static void main(String[] args) {
        int[] nums = {-2147483648,1,2,-2147483648};
        System.out.println(thirdMax(nums));
    }
    public static int thirdMax(int[] nums) {
        Integer max1 = null, max2 = null, max3 = null;
        for (Integer i:nums
                ) {

            if (i.equals(max1) || i.equals(max2) || i.equals(max3)) continue;

            if (max1 == null || i > max1){
                max3 = max2;
                max2 = max1;
                max1 = i;
            }else if (max2 == null || i > max2){
                max3 = max2;
                max2 = i;
            }else if (max3 == null || i > max3){
                max3 = i;
            }

        }
        return max3 == null?max1:max3;
    }
}
