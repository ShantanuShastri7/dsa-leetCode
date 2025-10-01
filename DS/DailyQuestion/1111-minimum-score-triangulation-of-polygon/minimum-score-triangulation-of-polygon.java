class Solution {
    public int minScoreTriangulation(int[] values) {
        int[][] dp = new int[values.length][values.length];
        for(int i=0; i<values.length; i++){
            Arrays.fill(dp[i], -1);
        }
        return triangulate(values, 0, values.length - 1, dp);
    }

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