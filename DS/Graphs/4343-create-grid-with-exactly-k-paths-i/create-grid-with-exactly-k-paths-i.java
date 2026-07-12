class Solution {
    public String[] createGrid(int m, int n, int k) {
        char[][] grid = new char[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = '.';
            }
        }

        int startCount = countPaths(grid);

        if (startCount < k) {
            return new String[0]; 
        }

        if (startCount == k) {
            return buildResult(grid);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if ((i == 0 && j == 0) || (i == m - 1 && j == n - 1)) {
                    continue;
                }

                if (grid[i][j] == '.') {
                    grid[i][j] = '#';
                    int newCount = countPaths(grid);

                    if (newCount < k) {
                        grid[i][j] = '.'; 
                    } else if (newCount == k) {
                        return buildResult(grid);
                    } 

                }
            }
        }

        return new String[0];
    }

    private int countPaths(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        if (grid[0][0] == '#' || grid[m-1][n-1] == '#') return 0;

        int[][] dp = new int[m][n];
        dp[0][0] = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '#') {
                    dp[i][j] = 0;
                    continue;
                }
                if (i > 0) dp[i][j] += dp[i-1][j];
                if (j > 0) dp[i][j] += dp[i][j-1];
            }
        }

        return dp[m-1][n-1];
    }

    private String[] buildResult(char[][] grid) {
        String[] res = new String[grid.length];
        for (int i = 0; i < grid.length; i++) {
            res[i] = new String(grid[i]);
        }
        return res;
    }
}