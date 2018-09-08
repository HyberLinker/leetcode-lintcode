package pers.james.array;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();

        if (numRows == 0) return triangle;

        triangle.add(new ArrayList<Integer>());
        triangle.get(0).add(1);

        if (numRows == 1) return triangle;

        // 第二行初始化，如果输入numRows = 1
        triangle.add(new ArrayList<Integer>());
        triangle.get(1).add(1);
        triangle.get(1).add(1);


        for (int i = 2; i < numRows; i++){
            List<Integer> row = new ArrayList<>();
            List<Integer> preRow = triangle.get(i - 1);

            row.add(1);

            for (int j = 1; j < i; j++){
                row.add(preRow.get(j) + preRow.get(j - 1));
            }

            row.add(1);
            triangle.add(row);
        }
        return triangle;
    }
}
