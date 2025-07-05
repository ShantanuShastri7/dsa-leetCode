class Solution {
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if(sum%2!=0) return false;
        int sum2=sum/2;

        boolean dp[][] = new boolean[nums.length][sum2+1];
        for (int i = 0; i < nums.length; i++) {
            dp[i][0] = true;
        }

        if (nums[0] <= sum2) {
            dp[0][nums[0]] = true;
        }

        for(int i=1; i<nums.length; i++){
            for(int target=1; target<=sum2; target++){
                boolean notPick = dp[i - 1][target];
                boolean pick = false;
                if (target >= nums[i]) {
                    pick = dp[i - 1][target - nums[i]];
                }
                dp[i][target] = pick || notPick;
            }
        }

        return dp[nums.length-1][sum2];
    }
}