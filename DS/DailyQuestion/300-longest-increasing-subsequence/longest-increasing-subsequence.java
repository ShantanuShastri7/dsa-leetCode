class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n + 1][n + 1];

        for (int i = n - 1; i >= 0; i--) {
            // prev from i-1 down to -1
            for (int prev = i - 1; prev >= -1; prev--) {

                // Option 1: skip nums[i]
                int notPick = dp[i + 1][prev + 1];

                // Option 2: pick nums[i] if valid
                int pick = 0;
                if (prev == -1 || nums[i] > nums[prev]) {
                    pick = 1 + dp[i + 1][i + 1];
                }

                dp[i][prev + 1] = Math.max(pick, notPick);
            }
        }

        return dp[0][0];
    }

    // public int lengthOfLIS(int[] nums) {
    //     return helper(nums, nums.length-1, -1);
    // }

    private int helper(int[] nums, int index, int lastIndex){
        if(index<0) return 0;

        int notPick = helper(nums, index-1, lastIndex);

        int pick = 0;

        if(lastIndex==-1 || nums[index]<nums[lastIndex]){
            pick = 1 + helper(nums, index-1, index);
        }

        return Math.max(pick, notPick);
    }
}