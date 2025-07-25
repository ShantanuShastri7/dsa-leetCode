class Solution {
    public int numEnclaves(int[][] board) {
        int n = board.length;
        int m = board[0].length;
        boolean visited[][] = new boolean[n][m];

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(i==0 || i==n-1 || j==0 || j==m-1){
                    if(!visited[i][j] && board[i][j]==1) dfs(i, j, board, visited);
                }
            }
        }
        int count=0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(visited[i][j]!=true && board[i][j]==1){
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(int n, int m, int[][] board, boolean visited[][]){
        visited[n][m]=true;

        if(n<board.length-1 && board[n+1][m]==1 && !visited[n+1][m]){
            dfs(n+1, m, board, visited);
        }
        if(n>0 && board[n-1][m]==1 &&  !visited[n-1][m]){
            dfs(n-1, m, board, visited);
        }
        if(m<board[0].length-1 && board[n][m+1]==1 && !visited[n][m+1]){
            dfs(n, m+1, board, visited);
        }
        if(m>0 && board[n][m-1]==1 && !visited[n][m-1]){
            dfs(n, m-1, board, visited);
        }
    }
}