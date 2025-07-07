class Solution {
    public int change(int amount, int[] coins) {
        if (amount == 0)
            return 1;
        if (coins.length == 1 && amount % coins[0] == 0)
            return 1;

        int dp[][] = new int[coins.length][amount + 1];
        for(int i=0; i<=amount; i++){
            if(i%coins[0]==0) dp[0][i]=1;
            else dp[0][i]=0;
        }
        for(int i=0; i<coins.length; i++){
            dp[i][0]=1;
        }

        for(int i=1; i<coins.length; i++){
            for(int j=0; j<=amount; j++){
                int notPick = dp[i-1][j];
                int pick = 0;
                if (j >= coins[i]) {
                    pick = dp[i][j-coins[i]];
                }
                dp[i][j]=pick+notPick;
            }
        }

        return dp[coins.length - 1][amount];
    }

    private int helper(int amount, int[] coins, int index, int dp[][]) {
        if (amount == 0)
            return 1;
        if (index == 0) {
            if (amount % coins[0] == 0)
                return 1;
            return 0;
        }

        if (dp[index][amount] != -1)
            return dp[index][amount];

        int notPick = helper(amount, coins, index - 1, dp);
        int pick = 0;
        if (amount >= coins[index]) {
            pick = helper(amount - coins[index], coins, index, dp);
        }

        return dp[index][amount] = pick + notPick;
    }
}