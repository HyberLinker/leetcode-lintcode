package pers.james.array;

public class RemoveElement {
    public static void main(String[] args) {
        int[] nums = {3,2,2,3};
        int val = 3;
        removeElement(nums, val);

    }
    public static int removeElement(int[] nums, int val) {
        int i = 0, n = nums.length;
        while (i < n){
            if (nums[i] == val){
                nums[i] = nums[n-1];
                n--;
            }else i++;          //i++必须要在if里面，如果最后一个数==val，当他被换到第一个位置时，还需要再check一边第一个位置，所以不能每次循环都i++
        }
        return n;
    }
}
