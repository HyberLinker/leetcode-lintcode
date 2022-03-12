package pers.james.binarySearch;

/**
 *  69 Sqrt(x) x的平方根
 *  easy
 */
public class SqrtX {
    //找last<=target的数（左边距离target最近的数）
    public static int mySqrt(int x) {
        int left = 0;
        int right = x;
        while (left < right) {
            int mid = left + (right - left) / 2 + 1; //出现left=mid，这里要+1，不然死循环
            // long temp = mid*mid; //不论long还是int，都会越界变成负数。
            // 或者可以使用pow，double temp = Math.pow(mid, 2);
            if (mid > x/mid) {
                right = mid - 1;
            }else if (mid < x/mid) {
                left = mid;
            }else {
                left = mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int x = 8;
        x = 4;
        x = 0;
        System.out.println(mySqrt(x));
    }
}
