class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minTillNow = prices[0];
        int maxTillNow = 0;

        for(int i=0; i<prices.length; i++){
            if(prices[i]>maxTillNow){
                maxTillNow = prices[i];
            }
            if(prices[i]<minTillNow){
                minTillNow = prices[i];
                maxTillNow = minTillNow;
            }

            maxProfit = Math.max(maxProfit, maxTillNow - minTillNow);
        }
        
        return maxProfit;
    }
}