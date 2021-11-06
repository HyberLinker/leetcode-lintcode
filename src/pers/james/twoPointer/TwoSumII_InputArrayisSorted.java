package pers.james.twoPointer;

public class TwoSumII_InputArrayisSorted {
    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        int left = 0, right = numbers.length - 1;
        while (left < right){
            int num1 = numbers[left], nums2 = numbers[right];
            if (num1 + nums2 > target){
                right--;
            }else if (num1 + nums2 < target) left++;
            else {
                result[0] = left;
                result[1] = right;
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] numbers = {2,7,11,15};
        int target = 9;
        TwoSumII_InputArrayisSorted t = new TwoSumII_InputArrayisSorted();
        int[] result = t.twoSum(numbers, target);
        System.out.println(result);
    }

}
