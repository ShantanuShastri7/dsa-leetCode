class Solution {
    public int perfectSum(int[] nums, int target) {
        int n = nums.length;
        Integer[][] dp = new Integer[n][target + 1];
        return helper(nums, n - 1, target, dp);
    }

    private int helper(int[] nums, int index, int target, Integer[][] dp) {
        if (index == 0) {
            if (target == 0 && nums[0] == 0) return 2; // pick or not pick 0
            if (target == 0 || target == nums[0]) return 1;
            return 0;
        }

        if (dp[index][target] != null) return dp[index][target];

        int notPick = helper(nums, index - 1, target, dp);
        int pick = 0;
        if (nums[index] <= target) {
            pick = helper(nums, index - 1, target - nums[index], dp);
        }

        return dp[index][target] = pick + notPick;
    }
}
