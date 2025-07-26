// User function Template for Java

class Solution {

    int countDistinctIslands(int[][] grid) {
        // Your Code here
        int n = grid.length; 
        int m = grid[0].length;
        int count=0;
        boolean visited[][] = new boolean[n][m];
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(!visited[i][j] && grid[i][j]==1){
                    bfs(grid, visited, i, j);
                    count++;
                }
            }
        }
        
        return count;
    }
    
    private void bfs(int[][] grid, boolean[][] visited, int i, int j){
        Queue<Pair<Integer, Integer>> q = new ArrayDeque<>();
        visited[i][j]=true;
        q.offer(new Pair<>(i,j));
        
        while(!q.isEmpty()){
            int newi = q.peek().getKey();
            int newj = q.poll().getValue();
            
            for(int m=-1; m<=1; m++){
                for(int n=-1; n<=1; n++){
                    int nrow=newi+m;
                    int ncol=newj+n;
                    
                    if(nrow>=0 && nrow<grid.length && ncol>=0 && ncol<grid[0].length
                    && grid[nrow][ncol]==1 && !visited[nrow][ncol]){
                        q.offer(new Pair<>(nrow,ncol));
                        visited[nrow][ncol]=true;
                    }
                }
            }
        }
    }
}
