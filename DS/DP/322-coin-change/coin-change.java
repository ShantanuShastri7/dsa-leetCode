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

    private int helper(int[] coins, int amount, int index,int dp[][]){
        if(index==0){
            if(amount%coins[0]==0) return amount/coins[0];
            return 1000000;
        }
        if(dp[index][amount]!=-1) return dp[index][amount];
        int notPick = helper(coins, amount, index-1, dp);
        int pick=1000000;
        if(coins[index]<=amount){
            pick=1+helper(coins, amount-coins[index], index, dp);
        }

        return dp[index][amount]=Math.min(pick,notPick);
    }
}