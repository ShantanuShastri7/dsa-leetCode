class Solution {
    public int countSquares(int[][] matrix) {
        int dp[][] = new int[matrix.length][matrix[0].length];

        for(int i=0; i<matrix[0].length; i++){
            dp[0][i]=matrix[0][i];
        }

        for(int i=0; i<matrix.length; i++){
           dp[i][0]=matrix[i][0];
        }

        for(int i=1; i<matrix.length; i++){
            for(int j=1; j<matrix[0].length; j++){
                if(matrix[i][j]==0) dp[i][j]=0;
                else{
                    int min = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]);
                    dp[i][j]=min+1;
                }
            }
        }

        int count=0;

        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                count+=dp[i][j];
            }
        }

        return count;
    }
}