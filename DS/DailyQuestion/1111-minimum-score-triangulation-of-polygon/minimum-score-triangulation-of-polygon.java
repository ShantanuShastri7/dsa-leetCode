class Solution {
    public int minScoreTriangulation(int[] values) {
        int n = values.length;
        int[][] dp = new int[n][n];

        // dp[i][j] = minimum triangulation score for polygon between i and j
        for (int len = 2; len < n; len++) {          // length of the interval
            for (int i = 0; i + len < n; i++) {
                int j = i + len;
                dp[i][j] = Integer.MAX_VALUE;

                // Try all possible middle points
                for (int k = i + 1; k < j; k++) {
                    int cost = dp[i][k] + dp[k][j] + values[i] * values[k] * values[j];
                    dp[i][j] = Math.min(dp[i][j], cost);
                }
            }
        }

        return dp[0][n - 1];
    }

    // Memiozation
    // public int minScoreTriangulation(int[] values) {
    //     int[][] dp = new int[values.length][values.length];
    //     for(int i=0; i<values.length; i++){
    //         Arrays.fill(dp[i], -1);
    //     }
    //     return triangulate(values, 0, values.length - 1, dp);
    // }

    private int triangulate(int[] values, int start, int end, int[][] dp) {
        if (end - start < 2) return 0;
        if(dp[start][end]!=-1) return dp[start][end];
        int minScore = Integer.MAX_VALUE;

        for (int i = start + 1; i < end; i++) {
            int cost = triangulate(values, start, i, dp)
                     + triangulate(values, i, end, dp)
                     + values[start] * values[i] * values[end];
            minScore = Math.min(minScore, cost);
        }

        return dp[start][end]=minScore;
    }
}