class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] memo = new int[m][n];
        for (int[] row : memo) Arrays.fill(row, -1);
        return helper(m - 1, n - 1, memo, obstacleGrid);
    }

    private int helper(int m, int n, int[][] memo, int[][] obstacle) {
        if (m < 0 || n < 0) return 0;
        if (obstacle[m][n] == 1) return 0;
        if (m == 0 && n == 0) return 1;
        if (memo[m][n] != -1) return memo[m][n];

        int up = helper(m - 1, n, memo, obstacle);
        int left = helper(m, n - 1, memo, obstacle);

        return memo[m][n] = up + left;
    }
}