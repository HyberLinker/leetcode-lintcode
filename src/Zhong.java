import java.util.Arrays;

public class Zhong {
    public static void main(String[] args) {
        int[] nums = {0, 7, 3, 6 ,5, 8};
        int[] result = solution(nums);
        for (int i = 0; i < nums.length; i++)
            System.out.print(result[i]);
        }

    public static int[] solution(int[] nums){
        Arrays.sort(nums);
        int n = nums.length;
        int[] result = new int[n];
        int start = 0, end = n - 1;
        for (int i = 0; i < n; i++){
            if(nums[i] % 2 != 0){
                result[start++] = nums[i];
            }
        }
        for (int i = n - 1; i >= 0; i--){
            if (nums[i] % 2 == 0){
                result[end--] = nums[i];
            }
        }
        return result;
    }

}
