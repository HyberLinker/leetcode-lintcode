package pers.james.array;

public class ImageSmoother {
    public int[][] imageSmoother(int[][] M) {
        int r = M.length, c = M[0].length;
        int[][] result = new int[r][c];

        for (int i = 0; i < r; i++){
            for (int j = 0; j < c; j++){
                int count = 0, sum = 0;
                for (int ri = i - 1; ri <= i+1; ri++){
                    for(int cj = j -1; cj <= j+1; cj++){
                        if (ri >=0 && ri < r && cj >= 0 && cj < c){
                            count++;
                            sum += M[ri][cj];
                        }
                    }
                }
                result[i][j] = sum/count;
            }
        }
        return result;
    }
}
