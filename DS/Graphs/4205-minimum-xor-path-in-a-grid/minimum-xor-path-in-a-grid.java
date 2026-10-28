class Solution {
    public int minCost(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        // dp[i][j] will store all possible XOR sums achievable at cell (i, j)
        Set<Integer>[][] dp = new HashSet[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = new HashSet<>();
            }
        }
        
        // Base case: starting cell
        dp[0][0].add(grid[0][0]);
        
        // DP transition: Build possible XOR sums from top to bottom, left to right
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int val : dp[i][j]) {
                    // Move Down
                    if (i + 1 < m) {
                        dp[i + 1][j].add(val ^ grid[i + 1][j]);
                    }
                    // Move Right
                    if (j + 1 < n) {
                        dp[i][j + 1].add(val ^ grid[i][j + 1]);
                    }
                }
            }
        }
        
        // Find the minimum XOR sum in the bottom-right cell
        int minXOR = Integer.MAX_VALUE;
        for (int val : dp[m - 1][n - 1]) {
            minXOR = Math.min(minXOR, val);
        }
        
        return minXOR;
    }
}