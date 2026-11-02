class Solution {
    int MOD = 1000000007;

    public int uniquePaths(int[][] grid) {
        int m = grid.length; 
        int n = grid[0].length;

        int[][][] dp = new int[m][n][2];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                Arrays.fill(dp[i][j], -1);
            }
        }

        return helper(grid, dp, 0, 0, -1);
    }

    //dir=1 -> moved right, dir=0 -> moved down
    private int helper(int[][] grid, int[][][] dp, int x, int y, int dir){
        if(x==grid.length-1 && y==grid[0].length-1){
            return 1;
        }

        if(grid[x][y]==1){
            if(dir==0){
                int newx = x+1;
                int newy = y;
                if(newx>=0 && newx<grid.length && newy>=0 && newy<grid[0].length){
                    return helper(grid, dp, newx, newy, 1);
                }else{
                    return 0;
                }
            }else{
                int newx = x;
                int newy = y+1;
                if(newx>=0 && newx<grid.length && newy>=0 && newy<grid[0].length){
                    return helper(grid, dp, newx, newy, 0);
                }else{
                    return 0;
                }
            }
        }

        if(dir!=-1 && dp[x][y][dir]!=-1) return dp[x][y][dir];

        int[][] direcs = new int[][]{{1,0}, {0,1}};
        int res=0;

        for(int[] direc : direcs){
            int newx = x + direc[0];
            int newy = y + direc[1];

            if(newx>=0 && newx<grid.length && newy>=0 && newy<grid[0].length){
                // Apply modulo arithmetic here during addition
                res = (res + helper(grid, dp, newx, newy, direc[0]==1?1:0)) % MOD;
            } 
        }
        
        if(dir==-1) dir=0;
        return dp[x][y][dir]=res;
    }
}