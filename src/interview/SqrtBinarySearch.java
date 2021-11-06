package interview;

public class SqrtBinarySearch {
    public static void main(String[] args) {
        System.out.println(bs(15));
    }
    public void fun(int n){

    }

    public static int bs(int n){
        int start = 0;
        int end = n;
        while (start+1 < end){
            int mid = start + (end - start)/2;
            if (mid*mid >= n){
                end = mid;
            }else if (mid * mid < n){
                start = mid;
            }
        }

        if (end*end == n) return end;
        else if (start*start == n) return start;

        return -1;
    }
}
