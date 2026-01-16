class Solution {
    public int knapsack(int W, int val[], int wt[]) {
        int maxWt = Arrays.stream(wt).max().getAsInt();
        
        int[][] dp = new int[val.length][W+1];
        for(int i=0; i<val.length; i++){
            Arrays.fill(dp[i], -1);
        }
        return helper(W, val, wt, val.length-1, dp);
    }
    
    private int helper(int W, int[] val, int[] wt, int index, int[][] dp){
        if(index<0) return 0;
        
        if(dp[index][W]!=-1) return dp[index][W];
        
        int notPick = helper(W, val, wt, index-1, dp);
        
        int pick=0;
        
        if(wt[index]<=W){
            pick = val[index] + helper(W-wt[index], val, wt, index-1, dp);
        }
        
        return dp[index][W] = Math.max(pick, notPick);
    }
}
