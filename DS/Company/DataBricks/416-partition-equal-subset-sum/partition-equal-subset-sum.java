class Solution {
    public boolean canPartition(int[] nums) {
        int totalSum = Arrays.stream(nums).sum();
        if(totalSum%2!=0) return false;

        boolean[][] dp = new boolean[nums.length][totalSum+1];
        totalSum=totalSum/2;

        for(int i=0; i<nums.length; i++){
            dp[i][0]=true;
        }
        dp[0][nums[0]]=true;

        for(int i=1; i<nums.length; i++){
            for(int j=1; j<=totalSum; j++){
                boolean notPick = dp[i-1][j];
                boolean pick=false;
                if(nums[i]<=j){
                    pick = dp[i-1][j-nums[i]];
                }

                dp[i][j] = pick||notPick;
            }
        }

        return dp[nums.length-1][totalSum];

    }
    // public boolean canPartition(int[] nums) {
    //     int totalSum = Arrays.stream(nums).sum();
    //     if(totalSum%2!=0) return false;

    //     totalSum=totalSum/2;

    //     int[][] memo = new int[nums.length+1][totalSum+1];
    //     for(int i=0; i<=nums.length; i++) Arrays.fill(memo[i], -1);

    //     return helper(nums, totalSum, 0, memo)==1;

    // }

    private int helper(int[] nums, int target, int index, int[][] memo){
        if(index==nums.length) return 0; 
        if(nums[index]==target) return 1;

        if(memo[index][target]!=-1) return memo[index][target];

        int notPick = helper(nums, target, index+1, memo);
        int pick=0;
        if(target-nums[index]>=0){
            pick = helper(nums, target-nums[index], index+1, memo);
        }

        return memo[index][target] = (notPick==1 || pick==1)?1:0;
    }
}