class Solution {
    public int coinChange(int[] coins, int amount) {
        if(coins.length==0) return 0;
        if(amount==0) return 0;

        Arrays.sort(coins);
        if(coins[0]>amount) return -1;

        int[][] dp = new int[coins.length][amount+1];
        for(int i=0; i<coins.length; i++) Arrays.fill(dp[i], -1);

        int result = helper(coins, amount, coins.length-1, dp);
        return result==1000000?-1:result;
    }

    private int helper(int[] coins, int amount, int index, int dp[][]){
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