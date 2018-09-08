package pers.james.array;

public class BeautifulArrangementII {
    public static void main(String[] args) {
        constructArray(5,2);
    }
    public static int[] constructArray(int n, int k) {
        int[] temp = new int[n];
        int[] ans = new int[n];

        for (int i = 1; i <= n; i++){
            temp[i-1] = i;
        }

        for (int i = 0; i < n - k; i++){
            ans[i] = temp[i];
        }

        int[] reminder = new int[k];
        for (int i = 0; i < k; i++){
            reminder[i] = temp[n-k+i];
        }

        int c = n-k, start = 0, end = k-1;
        while (!(start>end)){
            if ((c-n+k) % 2 == 0){
                ans[c++] = reminder[end--];
            }else {
                ans[c++] = reminder[start++];
            }
        }
        return ans;
    }
}
