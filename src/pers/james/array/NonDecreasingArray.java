package pers.james.array;

public class NonDecreasingArray {
    public static void main(String[] args) {
        int[] nums = {3,4,2,3};
        System.out.println(checkPossibility(nums));
    }
//    public static boolean checkPossibility(int[] nums) {
//        int len = nums.length, count = 0;
//        for (int i = 0; i < len - 1; i++){
//            if (nums[i] > nums[i+1]) {
//                count++;
//                if (i+2 <= len - 1 && nums[i] <= nums[i+2]) continue;
//                else {
//                    if (i != 0){
//                        if ( nums[i-1] < nums[i+1]) continue;
//                        else{
//                            count++;
//                        }
//                    }
//                }
//            }
//        }
//        if (count > 1) return false;
//        return true;
//    }
    public static boolean checkPossibility(int[] nums) {
        int len = nums.length, count = 0;
        for (int i = 1; i < len && count <= 1; i++){
            if (nums[i-1] > nums[i]){
                count++;
                if (nums[i-2] <= nums[i] || i-2<0) nums[i-1] = nums[i];
                else nums[i] = nums[i-1];
            }
        }
        return count <=1;
    }

//    public static boolean checkPossibility(int[] nums) {
//        int cnt = 0;                                                                    //the number of changes
//        for(int i = 1; i < nums.length && cnt<=1 ; i++){
//            if(nums[i-1] > nums[i]){
//                cnt++;
//                if(i-2<0 || nums[i-2] <= nums[i])nums[i-1] = nums[i];                    //modify nums[i-1] of a priority
//                else nums[i] = nums[i-1];                                                //have to modify nums[i]
//            }
//        }
//        return cnt<=1;
//    }
}
