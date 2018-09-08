package pers.james.array;


public class RotateArray {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6};
        rotate(nums, 2);
    }
//    public void rotate(int[] nums, int k) {
//        int len = nums.length;
//        int[] newArray = new int[len];
//        for (int i =0; i < len; i++){
//            newArray[(i+k)%len] = nums[i];
//        }
//        for (int i =0; i < len; i++){
//            nums[i] = newArray[i];
//        }
//    }

    public static void rotate(int[] nums, int k) {
        k = k % nums.length;
        int count = 0;
        for (int start = 0; count < nums.length; start++) {
            int current = start;
            int prev = nums[start];
            do {
                int next = (current + k) % nums.length;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
                count++;
            } while (start != current);
        }
    }
}
