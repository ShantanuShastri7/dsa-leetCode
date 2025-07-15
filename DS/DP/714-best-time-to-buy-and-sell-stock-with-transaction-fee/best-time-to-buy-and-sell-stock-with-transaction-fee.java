class Solution {
    public int maxProfit(int[] prices, int fee) {
        int dp[][] = new int[prices.length][2];
        for(int i=0; i<prices.length; i++){
            Arrays.fill(dp[i], -1);
        }
        return helper(prices, 0, 0, dp, fee);
    }

    private int helper(int[] prices, int index, int buy, int dp[][], int fee) {
        if (index == prices.length)
            return 0;

        if (dp[index][buy] != -1)
            return dp[index][buy];

        if (buy == 0) {
            int profit = Math.max((helper(prices, index + 1, 1, dp, fee) - prices[index]),
                    (helper(prices, index + 1, 0, dp, fee)));
            return dp[index][buy] = profit;
        } else {
            int profit = Math.max((prices[index] - fee + helper(prices, index + 1, 0, dp, fee)),
                    helper(prices, index + 1, 1, dp, fee));
            return dp[index][buy] = profit;
        }
    }
}