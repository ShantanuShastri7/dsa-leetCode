class Solution {
    public int maxProfit(int[] prices) {
        int dp[][] = new int[prices.length+1][2];
        dp[prices.length][1] = 0;
        dp[prices.length][0] = 0;

        for (int i = prices.length - 1; i >= 0; i--) {
            for (int j = 0; j <= 1; j++) {
                if (j == 0) {
                    int profit = Math.max((dp[i+1][1] - prices[i]), dp[i+1][0]);
                    dp[i][j] = profit;
                } else {
                    int profit = Math.max((prices[i] + dp[i+1][0]), dp[i+1][1]);
                    dp[i][j] = profit;
                }
            }
        }

        return dp[0][0];
    }

    private int helper(int[] prices, int index, int buy, int dp[][]) {
        if (index == prices.length)
            return 0;

        if (dp[index][buy] != -1)
            return dp[index][buy];

        if (buy == 0) {
            int profit = Math.max((helper(prices, index + 1, 1, dp) - prices[index]),
                    (helper(prices, index + 1, 0, dp)));
            return dp[index][buy] = profit;
        } else {
            int profit = Math.max((prices[index] + helper(prices, index + 1, 0, dp)),
                    helper(prices, index + 1, 1, dp));
            return dp[index][buy] = profit;
        }
    }

}