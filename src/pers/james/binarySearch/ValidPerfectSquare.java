package pers.james.binarySearch;

/**
 * 367. Valid Perfect Square 有效的完全平方数
 * easy
 * @author JamesLiu
 * @date 2022年01月09日 19:55:00
 */
public class ValidPerfectSquare {
    //find target找到返回true，找不到false
    public static boolean isPerfectSquare(int num) {
        int left = 0;
        int right = num;
        while (left < right) {
            int mid = left + (right - left)/2;
            if (mid < num/mid) {
                left = mid + 1;
            }else if (mid > num/mid) {
                right = mid - 1;
            }else {
                right = mid; //这里不能直接return mid；因为 num/mid 的值会向下取整，所以当mid = num/mid的时候，可能并不是我们想要的值
            }
            System.out.printf("left:{%d}, right{%d}\n", left, right);
        }
        if (right*right == num) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int num = 681;
        num = 104976;
        System.out.println(isPerfectSquare(num));
    }
}
