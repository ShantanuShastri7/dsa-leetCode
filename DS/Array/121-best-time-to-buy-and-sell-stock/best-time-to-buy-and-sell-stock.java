class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length<2) return 0;

        int mini = prices[0];
        int maxP = 0;

        for(int i=0; i<prices.length; i++){
            mini = Math.min(mini, prices[i]);
            maxP = Math.max(maxP, prices[i]-mini);
        }

        return maxP;
    }
}