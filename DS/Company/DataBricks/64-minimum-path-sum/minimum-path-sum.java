class Solution {
    public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];

        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(i==0 && j==0) dp[i][j]=grid[0][0];
                else {

                    int up = grid[i][j];
                    if(i>0) up += dp[i-1][j];
                    else up += 999999;

                    int left = grid[i][j];
                    if(j>0) left += dp[i][j-1];
                    else left+=999999;

                    dp[i][j] = Math.min(up, left);
                }
            }
        }

        return dp[grid.length-1][grid[0].length-1];
    }

    //Memoization
    // public int minPathSum(int[][] grid) {
    //     if(grid.length==0) return 0;
    //     if(grid.length==1 && grid[0].length==1) return grid[0][0];

    //     int[][] memo = new int[grid.length][grid[0].length];

    //     for(int i=0; i<grid.length; i++) Arrays.fill(memo[i], -1);

    //     return helper(grid, grid.length-1, grid[0].length-1, memo);
    // }

    private int helper(int[][] grid, int i, int j, int[][] memo){
        if(i<0 || j<0) return 99999;
        if(i==0 && j==0) return grid[i][j];

        if(memo[i][j]!=-1) return memo[i][j];

        int up = grid[i][j] + helper(grid, i-1, j, memo);
        int left = grid[i][j] + helper(grid, i, j-1, memo);

        return memo[i][j] = Math.min(up, left);
    }
}