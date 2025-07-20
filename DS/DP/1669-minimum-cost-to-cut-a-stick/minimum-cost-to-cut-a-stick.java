class Solution {
    public int minCost(int n, int[] cuts) {
        int c = cuts.length;
        int[] allCuts = new int[c + 2];
        allCuts[0] = 0;
        allCuts[c + 1] = n;

        for (int i = 0; i < c; i++) {
            allCuts[i + 1] = cuts[i];
        }

        Arrays.sort(allCuts);

        int[][] dp = new int[c + 2][c + 2];

        for (int length = 2; length <= c + 1; length++) {
            for (int i = 0; i + length <= c + 1; i++) {
                int j = i + length;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i + 1; k < j; k++) {
                    int cost = allCuts[j] - allCuts[i] + dp[i][k] + dp[k][j];
                    dp[i][j] = Math.min(dp[i][j], cost);
                }
            }
        }

        return dp[0][c + 1];
    }

    // public int minCost(int n, int[] cuts) {
    //     int[] allCuts = new int[cuts.length + 2];
    //     int dp[][] = new int[n+2][n+2];
    //     for(int i=0; i<n+2; i++){
    //         Arrays.fill(dp[i], -1);
    //     }
    //     allCuts[0] = 0;
    //     allCuts[allCuts.length - 1] = n;
    //     for (int i = 0; i < cuts.length; i++) {
    //         allCuts[i + 1] = cuts[i];
    //     }
    //     Arrays.sort(allCuts);

    //     return helper(allCuts, 0, allCuts.length - 1, dp);
    // }

    private int helper(int[] cuts, int left, int right, int dp[][]) {
        if (left + 1 >= right) return 0;

        int minCost = Integer.MAX_VALUE;

        if(dp[left][right]!=-1) return dp[left][right];

        for (int i = left + 1; i < right; i++) {
            int cost = (cuts[right] - cuts[left])
                    + helper(cuts, left, i, dp)
                    + helper(cuts, i, right, dp);
            minCost = Math.min(minCost, cost);
        }

        return dp[left][right] = minCost;
    }
}