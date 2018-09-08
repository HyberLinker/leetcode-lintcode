package pers.james.array;

import java.util.Stack;

public class FlippingAnImage {
    public int[][] flipAndInvertImage(int[][] A) {
        int len = A.length;
        int[][] result = new int[len][len];

        for (int i = 0; i < len; i++){
            int[] ele = A[i];
            Stack<Integer> temp = new Stack<>();
            for (int j = 0; j < len; j++){
                int a = A[i][j];
                if (a == 1) a = 0;
                else a = 1;

                temp.push(a);
            }
            for (int j = 0; j < len; j++){
                result [i][j] = temp.pop();
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println((int)(4.7));
    }
}
