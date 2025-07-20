class Solution {
    public int maxCoins(int[] nums) {
        int n=nums.length;
        int allNums[] = new int[n+2];
        for(int i=0; i<n; i++){
            allNums[i+1]=nums[i];
        }
        allNums[0]=1;
        allNums[n+1]=1;
        int dp[][] = new int[n+1][n+1];
        for(int i=0; i<=n; i++){
            Arrays.fill(dp[i], -1);
        }
        return helper(allNums, 1, n, dp);
    }

    private int helper(int[] nums, int start, int end, int dp[][]){
        if(start>end) return 0;
        int maxCoins=0;
        
        if(dp[start][end]!=-1) return dp[start][end];

        for(int i=start; i<=end; i++){
            int coins = nums[start-1]*nums[i]*nums[end+1]+helper(nums,start, i-1, dp)+helper(nums,i+1, end, dp);
            maxCoins=Math.max(maxCoins, coins);
        }

        return dp[start][end] = maxCoins;
    }
}