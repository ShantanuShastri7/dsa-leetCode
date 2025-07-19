class Solution {
    public boolean increasingTriplet(int[] nums) {
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;

        for (int num : nums) {
            if (num <= first) {
                first = num; // Smallest so far
            } else if (num <= second) {
                second = num; // Second smallest
            } else {
                // Found a third one
                return true;
            }
        }

        return false;
    }

    //Tabulation MLE
    // public boolean increasingTriplet(int[] nums) {
    //     int n = nums.length;
    //     int[][][] dp = new int[nums.length+1][nums.length + 1][4];
    //     for (int i=0; i<=n; i++) {
    //         for(int j=0; j<=n; j++){
    //             if(i==n) {
    //                 dp[i][j][0]=0;
    //                 dp[i][j][1]=0;
    //                 dp[i][j][2]=0;
    //             }
    //             dp[i][j][3]=1;
    //         }
    //     }

    //     for (int i = n-1; i>=0; i--) {
    //         for (int j = i-1; j>=-1; j--) {
    //             for(int count=2; count>=0; count--){
    //                 boolean take = false;
    //                 if (j == -1 || nums[i] > nums[j]) {
    //                     take = dp[i+1][i+1][count+1]==1;
    //                 }
    //                 boolean notTake = dp[i+1][j+1][count]==1;
    //                 boolean res = take || notTake;

    //                 dp[i][j+1][count] = res ? 1 : 0;
    //             }
    //         }
    //     }

    //     return dp[0][0][0]==1;
    // }

    //Memiozaiton TLE
    // public boolean increasingTriplet(int[] nums) {
    //     int[][][] dp = new int[nums.length][nums.length + 1][3];
    //     for (int[][] d1 : dp) {
    //         for (int[] d2 : d1) {
    //             Arrays.fill(d2, -1);
    //         }
    //     }

    //     return helper(nums, 0, -1, 0, dp);
    // }

    private boolean helper(int[] nums, int index, int prevIndex, int len, int[][][] dp) {
        if (len == 3) return true;
        if (index == nums.length) return false;

        if (dp[index][prevIndex + 1][len] != -1) {
            return dp[index][prevIndex + 1][len] == 1;
        }

        boolean take = false;
        if (prevIndex == -1 || nums[index] > nums[prevIndex]) {
            take = helper(nums, index + 1, index, len + 1, dp);
        }

        boolean notTake = helper(nums, index + 1, prevIndex, len, dp);
        boolean res = take || notTake;

        dp[index][prevIndex + 1][len] = res ? 1 : 0;
        return res;
    }
}