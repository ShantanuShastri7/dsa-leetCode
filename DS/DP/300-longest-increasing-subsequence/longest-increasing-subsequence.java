class Solution {
    public int lengthOfLIS(int[] nums) {
        int[][] dp = new int[nums.length+1][nums.length+1];

        for(int i=0; i<nums.length; i++){
            Arrays.fill(dp[i], -1);
        }

        helper(nums, 0, -1, dp);

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