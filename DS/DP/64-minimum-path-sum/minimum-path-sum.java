class Solution {
    public int minPathSum(int[][] grid) {
        int[][] memo = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            Arrays.fill(memo[i], -1);
        }
        return helper(grid, grid.length - 1, grid[0].length - 1, memo);
    }

    private int helper(int[][] grid, int m, int n, int[][] memo) {
        if (m == 0 && n == 0) {
            return grid[m][n];
        }
        if (m < 0 || n < 0) return Integer.MAX_VALUE;  // or a large value like 1e9

        if (memo[m][n] != -1) return memo[m][n];

        int up = helper(grid, m - 1, n, memo);
        int left = helper(grid, m, n - 1, memo);

        return memo[m][n] = grid[m][n] + Math.min(up, left);
    }
}