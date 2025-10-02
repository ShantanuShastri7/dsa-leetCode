class Solution {
    public int uniquePaths(int m, int n) {
        int[] prevUp= new int[m];
        int[] dp = new int[n];
        Arrays.fill(prevUp, 0);

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(i==0&&j==0) {
                    dp[0]=1;
                }else{
                    int up=0; int left=0;
                    if(i!=0) up = prevUp[j];
                    if(j!=0) left = dp[j-1];
                    dp[j]=up+left;
                }
            }
            prevUp=dp;
        }

        return dp[n-1];
    }


    // public int uniquePaths(int m, int n) {
    //     int dp[][] = new int[m][n];

    //     for(int i=0; i<m; i++){
    //         for(int j=0; j<n; j++){
    //             if(i==0&&j==0) dp[i][j]=1;
    //             else{
    //                 int up=0; int left=0;
    //                 if(i!=0) up = dp[i-1][j];
    //                 if(j!=0) left = dp[i][j-1];
    //                 dp[i][j] = left+up;
    //             }
    //         }
    //     }

    //     return dp[m-1][n-1];
    // }

    // public int uniquePaths(int m, int n) {
    //     int memo[][] = new int[m+1][n+1];
    //     for(int i=0;i<m+1;i++){
    //         Arrays.fill(memo[i],-1);
    //     }
    //     return helper(m,n,memo);
    // }

    private int helper(int m, int n, int memo[][]){
        if(m==1 && n==1) return 1;
        else if(m<1||n<1) return 0;
        if(memo[m][n]!=-1) return memo[m][n];

        int up = uniquePaths(m-1,n);
        int left = uniquePaths(m,n-1);
        
        return memo[m][n]=up+left;
    }
}