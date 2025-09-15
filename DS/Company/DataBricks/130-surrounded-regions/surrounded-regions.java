class Solution {
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        boolean visited[][] = new boolean[n][m];

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(i==0 || i==n-1 || j==0 || j==m-1){
                    if(!visited[i][j] && board[i][j]=='O') dfs(i, j, board, visited);
                }
            }
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(visited[i][j]!=true){
                    board[i][j]='X';
                }
            }
        }
    }

    private void dfs(int n, int m, char[][] board, boolean visited[][]){
        visited[n][m]=true;

        if(n<board.length-1 && board[n+1][m]=='O' && !visited[n+1][m]){
            dfs(n+1, m, board, visited);
        }
        if(n>0 && board[n-1][m]=='O' &&  !visited[n-1][m]){
            dfs(n-1, m, board, visited);
        }
        if(m<board[0].length-1 && board[n][m+1]=='O' && !visited[n][m+1]){
            dfs(n, m+1, board, visited);
        }
        if(m>0 && board[n][m-1]=='O' && !visited[n][m-1]){
            dfs(n, m-1, board, visited);
        }
    }
}