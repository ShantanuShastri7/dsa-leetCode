import java.util.*;

class Solution {
    public List<List<String>> solveNQueens(int n) {
        ArrayList<String> board = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) sb.append(".");
        String emptyRow = sb.toString();
        for (int i = 0; i < n; i++) board.add(emptyRow);

        List<List<String>> result = new ArrayList<>();
        helper(result, 0, n, board);
        return result;
    }

    private void helper(List<List<String>> result, int col, int n, ArrayList<String> board) {
        if (col == n) {
            result.add(new ArrayList<>(board));
            return;
        }

        for (int row = 0; row < n; row++) {
            if (isSafe(board, row, col)) {
                // Place queen
                StringBuilder sb = new StringBuilder(board.get(row));
                sb.setCharAt(col, 'Q');
                board.set(row, sb.toString());

                helper(result, col + 1, n, board);

                // Backtrack (remove queen)
                sb.setCharAt(col, '.');
                board.set(row, sb.toString());
            }
        }
    }

    private boolean isSafe(ArrayList<String> board, int row, int col) {
        int n = board.size();

        // Check left row
        for (int j = col - 1; j >= 0; j--) {
            if (board.get(row).charAt(j) == 'Q') return false;
        }

        // Check upper-left diagonal
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board.get(i).charAt(j) == 'Q') return false;
        }

        // Check lower-left diagonal
        for (int i = row + 1, j = col - 1; i < n && j >= 0; i++, j--) {
            if (board.get(i).charAt(j) == 'Q') return false;
        }

        return true;
    }
}