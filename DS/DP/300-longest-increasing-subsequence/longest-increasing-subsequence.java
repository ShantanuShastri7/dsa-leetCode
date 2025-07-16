class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n+1][n+1];

        for (int i = n-1; i>=0; i--) {
            for (int j = i-1; j>=-1; j--) {
                int notTake = dp[i+1][j+1];
                int take = 0;
                if (j == -1 || nums[i] > nums[j]) {
                    take = 1 + dp[i+1][i+1];
                }

                dp[i][j + 1] = Math.max(take, notTake);
            }
        }
        return dp[0][0];
    }

    private int helper(int[] nums, int index, int prevIndex, int[][] dp) {
        if (index == nums.length)
            return 0;

        if (dp[index][prevIndex + 1] != -1)
            return dp[index][prevIndex + 1];

        int notTake = helper(nums, index + 1, prevIndex, dp);
        int take = 0;
        if (prevIndex == -1 || nums[index] > nums[prevIndex]) {
            take = 1 + helper(nums, index + 1, index, dp);
        }

        return dp[index][prevIndex + 1] = Math.max(take, notTake);
    }
}