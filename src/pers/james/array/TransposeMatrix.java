package pers.james.array;

public class TransposeMatrix {
    public static int[][] transpose(int[][] A) {
        int outerLen = A.length, innerLen = A[0].length;

        int[][] transposeM = new int[innerLen][outerLen];


        for (int i = 0; i < outerLen; i++){
            for (int j = 0; j < innerLen; j++){
//                if (i >= j){
//                    if (innerLen >= outerLen) transposeM[i][j] = A[j][i];
//                    if (innerLen < outerLen) transposeM[j][i] = A[i][j];
//
//                }
                transposeM[j][i] = A[i][j];
            }
        }
        return transposeM;
    }

    public static void main(String[] args) {
        int[][] A = {{5}, {8}};
        System.out.println(transpose(A));
    }
}
