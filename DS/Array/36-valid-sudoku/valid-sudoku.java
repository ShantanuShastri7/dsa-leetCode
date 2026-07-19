class Solution {
    public boolean isValidSudoku(char[][] board) {
        int n=board.length; 
        int m=board[0].length;

        int[][] check = new int[n+m+9][10];

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(board[i][j]=='.') continue;
                int num = board[i][j]-'0';
                if(check[i][num]!=0) return false;
                else{
                    check[i][num]=1;
                }

                if(check[n+j][num]!=0) return false;
                else{
                    check[n+j][num]=1;
                }

                int ch = (i / 3) * 3 + (j / 3);
                if(check[n+m+ch][num]!=0) return false;
                else{
                    check[n+m+ch][num]=1;
                }
            }
        }

        return true;
    }
}