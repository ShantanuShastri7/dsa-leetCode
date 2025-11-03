class Solution {
    public void solveSudoku(char[][] board) {
        helper(board, 0, 0);
    }

    private boolean helper(char[][] board, int row, int col) {
        // ✅ If we've filled all rows, Sudoku is solved
        if (row == 9) return true;

        // Move to next row if we’ve reached end of this one
        if (col == 9) return helper(board, row + 1, 0);

        // Skip already-filled cells
        if (board[row][col] != '.') 
            return helper(board, row, col + 1);

        // Try placing all valid numbers
        ArrayList<Integer> validNums = getValidNums(board, row, col);
        for (Integer num : validNums) {
            board[row][col] = (char) (num + '0');

            // If placing this number leads to a solution, bubble up true
            if (helper(board, row, col + 1))
                return true;

            // ❌ Backtrack
            board[row][col] = '.';
        }

        // No valid number fits → backtrack
        return false;
    }

    private ArrayList<Integer> getValidNums(char[][] board, int row, int col) {
        Set<Integer> present = new HashSet<>();

        // Check current row
        for (int j = 0; j < 9; j++) {
            if (board[row][j] != '.')
                present.add(board[row][j] - '0');
        }

        // Check current column
        for (int i = 0; i < 9; i++) {
            if (board[i][col] != '.')
                present.add(board[i][col] - '0');
        }

        // Check 3x3 subgrid
        int rowStart = (row / 3) * 3;
        int colStart = (col / 3) * 3;
        for (int i = rowStart; i < rowStart + 3; i++) {
            for (int j = colStart; j < colStart + 3; j++) {
                if (board[i][j] != '.')
                    present.add(board[i][j] - '0');
            }
        }

        // Collect all valid numbers not already present
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            if (!present.contains(i))
                result.add(i);
        }

        return result;
    }
}
