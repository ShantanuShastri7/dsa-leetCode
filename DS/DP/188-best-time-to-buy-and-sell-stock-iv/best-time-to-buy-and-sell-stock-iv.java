class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n + 1][2][k+1];

        for (int index = n - 1; index >= 0; index--) {
            for (int buy = 0; buy <= 1; buy++) {
                for (int count = 0; count < k; count++) {
                    if (buy == 0) {
                        dp[index][buy][count] = Math.max(
                            -prices[index] + dp[index + 1][1][count], 
                            dp[index + 1][0][count]                     
                        );
                    } else {
                        dp[index][buy][count] = Math.max(
                            prices[index] + dp[index + 1][0][count + 1],
                            dp[index + 1][1][count]
                        );
                    }
                }
            }
        }

        return dp[0][0][0];
    }
}