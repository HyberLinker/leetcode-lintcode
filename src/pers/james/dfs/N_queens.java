package pers.james.dfs;

import java.util.ArrayList;
import java.util.List;

public class N_queens {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        if (n == 0) return result;

        helper(n, new ArrayList<Integer>(), result);
        return result;
    }

    private void helper(int n, List<Integer> board, List<List<String>> allBoard){

        if (board.size() == n){
            allBoard.add(produceCheeseBoard(board));
            return;
        }

        for (int colIndex = 0; colIndex < n; colIndex++) {
            if (!isValid(colIndex, board)) continue;

            board.add(colIndex);
            helper(n, board, allBoard);
            board.remove(board.size()-1);
        }
    }

    private boolean isValid(int colIndex, List<Integer> board){
        int rows = board.size();
        for (int row = 0; row < rows; row++) {
            int col = board.get(row);
            if (col == colIndex) return false;
            // 左下到右上，斜线位置
            if (row + col == rows + colIndex) return false;
            // 左上到右下，斜线位置
            if (row - col == rows - colIndex) return false;
        }
        return true;
    }

    private List<String> produceCheeseBoard(List<Integer> board){

        List<String> each_stringBoard = new ArrayList<>();
        for (int row = 0; row < board.size(); row++) {
            StringBuilder sb = new StringBuilder();
            for (int col = 0; col < board.size(); col++) {
                if (board.get(row) == col) sb.append("Q");
                else sb.append(".");
            }
            each_stringBoard.add(sb.toString());
        }

        return each_stringBoard;
    }


}
