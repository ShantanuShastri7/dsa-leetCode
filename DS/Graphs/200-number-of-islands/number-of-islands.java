class Solution {
    public int numIslands(char[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int numberOfIslands=0;

        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(!visited[i][j] && grid[i][j]=='1'){
                    numberOfIslands++;
                    visited[i][j]=true;
                    numberOfIslands(i,j,visited, grid);
                }
            }
        }
        
        return numberOfIslands;
    }

    private void numberOfIslands(int i, int j, boolean[][] visited, char[][] grid){
        int[][] directions = new int[][]{{-1,0},{0,-1},{1,0},{0,1}};

        for(int[] change : directions){
            int newi = i+change[0];
            int newj = j+change[1];

            if(newi>=0 && newi<visited.length && newj>=0 && newj<visited[0].length && !visited[newi][newj] && grid[newi][newj]=='1'){
                visited[newi][newj]=true;
                numberOfIslands(newi, newj, visited, grid);
            }
        }
    }
}