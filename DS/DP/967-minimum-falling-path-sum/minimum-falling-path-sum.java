class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int[] dp = new int[matrix[0].length];
        int n = matrix.length;
        if(n==1) return matrix[0][0];
        Arrays.fill(dp, 10000000);

        for (int i = 0; i < n; i++) {
            int[] temp = new int[matrix[0].length];
            for (int j = 0; j < n; j++) {
                if(j==0){
                    temp[j] = matrix[i][j] + Math.min(dp[j], dp[j+1]);
                } else if(j==n-1){
                    temp[j] = matrix[i][j] + Math.min(dp[j], dp[j-1]);
                } else {
                    temp[j] = matrix[i][j] + Math.min(Math.min(dp[j], dp[j+1]), dp[j-1]);
                }   
            }
            dp=temp;
        }

        return Arrays.stream(dp).min().getAsInt()-10000000;
    }

    // public int minFallingPathSum(int[][] matrix) {
    //     int res = 100000000;
    //     int[][] dp = new int[matrix.length][matrix[0].length];
    //     for (int i = 0; i < matrix[0].length; i++) {
    //         Arrays.fill(dp[i], 100000000);
    //     }
    //     for (int i = 0; i < matrix[0].length; i++) {
    //         res = Math.min(res, helper(matrix, matrix.length - 1, i, dp));
    //     }

    //     return res;
    // }

    private int helper(int[][] matrix, int m, int n, int[][] dp) {
        if (m == 0)
            return matrix[m][n];
        if (m < 0 || n < 0)
            return 1000000;

        if (dp[m][n] != 100000000)
            return dp[m][n];
        int res;
        if (n == 0)
            res = Math.min(helper(matrix, m - 1, n, dp), helper(matrix, m - 1, n + 1, dp));
        else if (n == matrix[0].length - 1)
            res = Math.min(helper(matrix, m - 1, n, dp), helper(matrix, m - 1, n - 1, dp));
        else
            res = Math.min(Math.min(helper(matrix, m - 1, n, dp), helper(matrix, m - 1, n + 1, dp)),
                    helper(matrix, m - 1, n - 1, dp));

        return dp[m][n] = res + matrix[m][n];
    }
}