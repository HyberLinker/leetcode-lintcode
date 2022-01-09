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
            if (mid > x/mid) { //mid*mid 有可能溢出 可以用mid > x / mid 或者 Math.pow是double
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
