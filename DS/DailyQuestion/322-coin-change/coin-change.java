class Solution {
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int dp[][] = new int[coins.length][amount+1];
        for(int i=0; i<=amount; i++){
            if(i%coins[0]==0) dp[0][i]=i/coins[0];
            else dp[0][i]=1000000;
        }
        for(int i=1; i<coins.length; i++){
            for(int j=0; j<=amount; j++){
                int notPick = dp[i-1][j];
                int pick=1000000;
                if(coins[i]<=j){
                    pick=1+dp[i][j-coins[i]];
                }
                dp[i][j]=Math.min(pick,notPick);
            }
        }
        return dp[coins.length-1][amount]==1000000?-1:dp[coins.length-1][amount];
    }



    // public int coinChange(int[] coins, int amount) {
    //     int res = helper(coins, coins.length-1, amount);

    //     return res==Integer.MAX_VALUE?-1:res;
    // }

    private int helper(int[] coins, int index, int amount){
        if(amount==0) return 0;
        if(index==0){
            if(amount%coins[0]==0) return amount/coins[0];

            return Integer.MAX_VALUE;
        }

        int notPick = helper(coins, index-1, amount);
        int pick = Integer.MAX_VALUE;
        if(amount>=coins[index]){
            pick = 1 + Math.min(helper(coins, index, amount-coins[index]), helper(coins, index-1, amount-coins[index]));
        }

        return Math.min(notPick, pick);
    }
}