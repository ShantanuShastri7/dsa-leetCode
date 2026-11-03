class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length; 
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int res = Integer.MIN_VALUE;

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(!visited[i][j] && grid[i][j]==1){
                    res = Math.max(res, helper(grid,visited, i, j));
                }
            }
        }

        return res==Integer.MIN_VALUE?0:res;
    }

    private int helper(int[][] grid, boolean[][] visited, int x, int y){
        int[][] direcs = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
        visited[x][y]=true;

        int res=1;
        for(int[] direc : direcs){
            int newx = x+direc[0];
            int newy = y+direc[1];

            if(newx>=0 && newx<grid.length && newy>=0 && newy<grid[0].length && grid[newx][newy]==1 && !visited[newx][newy]){
                res += helper(grid, visited, newx, newy);
            }
        }

        return res;
    }
}