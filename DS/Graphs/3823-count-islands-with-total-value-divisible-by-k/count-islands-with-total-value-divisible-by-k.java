class Solution {
    public int countIslands(int[][] grid, int k) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int res=0;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j]!=0 && !visited[i][j]){
                    long[] score = new long[1];
                    dfs(grid, visited, i, j, score);
                    if(score[0]%k==0) res++;
                }
            }
        }

        return res;
    }

    private void dfs(int[][] grid, boolean[][] visited, int i, int j, long[] score){
        int[][] direcs = {{-1,0},{1,0},{0,1},{0,-1}};
        visited[i][j]=true;

        score[0]+=grid[i][j];
        int res=0;
        for(int[] direc : direcs){
            int newi = i+direc[0];
            int newj = j+direc[1];

            if(newi>=0 && newi<grid.length && newj>=0 && newj<grid[0].length && !visited[newi][newj]){
                if(grid[newi][newj]!=0){
                    dfs(grid, visited, newi, newj, score);
                }
            }
        }

        return;
    }
}