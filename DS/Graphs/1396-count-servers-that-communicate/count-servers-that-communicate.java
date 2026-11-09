class Solution {
    public int countServers(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int res=0;

        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                int[] count = new int[1];
                if(grid[i][j]==1 && !visited[i][j]){
                    count[0]=1;
                    dfsHelper(grid, i, j, visited, count);
                    if(count[0]==1) continue;
                    res+=count[0];
                }
            }
        }

        return res;
    }

    private void dfsHelper(int[][] grid, int x, int y, boolean[][] visited, int[] count){
        visited[x][y]=true;

        for(int j = 0; j < grid[0].length; j++){
            if(grid[x][j] == 1 && !visited[x][j]){
                count[0]++;
                dfsHelper(grid, x, j, visited, count);
            }
        }

        // Check every cell in the CURRENT COLUMN (Up and Down)
        for(int i = 0; i < grid.length; i++){
            if(grid[i][y] == 1 && !visited[i][y]){
                count[0]++;
                dfsHelper(grid, i, y, visited, count);
            }
        }
    }
}