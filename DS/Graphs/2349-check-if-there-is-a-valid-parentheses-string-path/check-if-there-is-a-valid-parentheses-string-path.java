class Solution {
    public boolean hasValidPath(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        // Quick optimization: path length must be even, and start/end must be valid
        if ((m + n - 1) % 2 != 0 || grid[0][0] == ')' || grid[m - 1][n - 1] == '(') {
            return false;
        }

        // 3D memoization array: memo[x][y][valid]
        Boolean[][][] memo = new Boolean[m][n][201];
        return helper(grid, 0, 0, 0, memo);
    }

    private boolean helper(char[][] grid, int x, int y, int valid, Boolean[][][] memo) {
        // Update balance for current cell first
        if (grid[x][y] == '(') {
            valid++;
        } else {
            valid--;
        }

        // If balance drops below 0, invalid path
        if (valid < 0) return false;

        // If we reached the bottom-right corner, check if balance is 0
        if (x == grid.length - 1 && y == grid[0].length - 1) {
            return valid == 0;
        }

        // Check memoization table
        if (memo[x][y][valid] != null) {
            return memo[x][y][valid];
        }

        boolean oneCorrect = false;
        boolean secondCorrect = false;

        int x1 = x + 1, y1 = y;
        int x2 = x, y2 = y + 1;

        if (x1 < grid.length && y1 < grid[0].length) {
            oneCorrect = helper(grid, x1, y1, valid, memo);
        }

        if (!oneCorrect && x2 < grid.length && y2 < grid[0].length) {
            secondCorrect = helper(grid, x2, y2, valid, memo);
        }

        return memo[x][y][valid] = oneCorrect || secondCorrect;
    }
}