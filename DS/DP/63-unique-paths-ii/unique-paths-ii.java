class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    int m = obstacleGrid.length;
    int n = obstacleGrid[0].length;

    int[] dp = new int[n];
    dp[0] = (obstacleGrid[0][0] == 1) ? 0 : 1;

    for (int i = 0; i < m; i++) {
        int[] temp = new int[n];
        for (int j = 0; j < n; j++) {
            if (obstacleGrid[i][j] == 1) {
                temp[j] = 0;
            } else {
                int up = (i > 0) ? dp[j] : 0;
                int left = (j > 0) ? temp[j - 1] : 0;
                temp[j] = (i == 0 && j == 0) ? dp[0] : up + left;
            }
        }
        dp = temp;
    }

    return dp[n - 1];
}

    // public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    //     int m = obstacleGrid.length;
    //     int n = obstacleGrid[0].length;
    //     int[][] memo = new int[m][n];
    //     for (int[] row : memo) Arrays.fill(row, -1);
    //     return helper(m - 1, n - 1, memo, obstacleGrid);
    // }

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