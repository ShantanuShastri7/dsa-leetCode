class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n + 1][2][3];
        
        for (int index = n - 1; index >= 0; index--) {
            for (int buy = 0; buy <= 1; buy++) {
                for (int count = 0; count <= 1; count++) {
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
    // public int maxProfit(int[] prices) {
    //     int n = prices.length;
    //     int[][][] dp = new int[n][2][3];

    //     for (int i = 0; i < n; i++) {
    //         for (int j = 0; j < 2; j++) {
    //             for (int k = 0; k < 3; k++) {
    //                 dp[i][j][k] = -1;
    //             }
    //         }
    //     }

    //     return helper(prices, 0, 0, 0, dp);
    // }

    private int helper(int[] prices, int index, int buy, int count, int[][][] dp) {
        if (index == prices.length || count == 2) return 0;

        if (dp[index][buy][count] != -1) return dp[index][buy][count];

        int profit = 0;

        if (buy == 0) {
            profit = Math.max(-prices[index] + helper(prices, index + 1, 1, count, dp),
                              helper(prices, index + 1, 0, count, dp));
        } else {
            profit = Math.max(prices[index] + helper(prices, index + 1, 0, count + 1, dp),
                              helper(prices, index + 1, 1, count, dp));
        }

        return dp[index][buy][count] = profit;
    }
}
