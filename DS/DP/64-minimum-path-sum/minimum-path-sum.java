class Solution {
    public int minPathSum(int[][] grid) {
        int[] dp = new int[grid[0].length];

        for(int i=0; i<grid.length; i++){
            int[] temp = new int[grid[0].length];
            for(int j=0; j<grid[0].length; j++){
                if(i==0&&j==0) temp[j]=grid[i][j];
                else{
                    int up=Integer.MAX_VALUE; int left=Integer.MAX_VALUE;
                    if(i>0) up = grid[i][j] + dp[j];
                    if(j>0) left = grid[i][j] + temp[j-1];
                    temp[j] = Math.min(up, left);
                }
            }
            dp=temp;
        }

        return dp[grid[0].length-1];
    }

    // public int minPathSum(int[][] grid) {
    //     int[][] memo = new int[grid.length][grid[0].length];
    //     for (int i = 0; i < grid.length; i++) {
    //         Arrays.fill(memo[i], -1);
    //     }
    //     return helper(grid, grid.length - 1, grid[0].length - 1, memo);
    // }

    private int helper(int[][] grid, int m, int n, int[][] memo) {
        if (m == 0 && n == 0) {
            return grid[m][n];
        }
        if (m < 0 || n < 0) return Integer.MAX_VALUE; 

        if (memo[m][n] != -1) return memo[m][n];

        int up = helper(grid, m - 1, n, memo);
        int left = helper(grid, m, n - 1, memo);

        return memo[m][n] = grid[m][n] + Math.min(up, left);
    }
}