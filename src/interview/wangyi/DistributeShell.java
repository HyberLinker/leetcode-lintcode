package interview.wangyi;

public class DistributeShell {
    public int solution(int n){
        int start = 0, end = n;
        while (start + 1 < end){
            int mid = start + (end - start)/2;
            if (isLarge(mid, n)){
                end = mid;
            }else start = mid;
        }
       return end;
    }

    private boolean isLarge(int m, int n){
        int remain = n;
        int niu = 0;

        while (remain > 0){
             m = Math.min(m, remain);
             remain -= m;
             remain -= remain/10;
             niu += m;
        }

        if (niu*2 >= n) return true;
        else return false;
    }

    public static void main(String[] args) {
        System.out.println(new DistributeShell().solution(70));
    }
}
