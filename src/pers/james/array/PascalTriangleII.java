package pers.james.array;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangleII {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> preRow = null;
        List<Integer> row = new ArrayList<>();

        row.add(1);

        if (rowIndex == 0){
            return row;
        }

        for (int i = 1; i <= rowIndex; i++){
            preRow = row;
            row = new ArrayList<>();
            row.add(1);
            for (int j = 1; j < i; j++){
                row.add(preRow.get(j)+preRow.get(j-1));
            }
            row.add(1);
        }

        return row;
    }
}
