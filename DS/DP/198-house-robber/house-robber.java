class Solution {
    public int rob(int[] nums) {
        int prev = nums[0];
        int prev2 = 0;

        for(int i=1; i<nums.length; i++){
            int pick = nums[i];
            if(i>1) pick+=prev2;

            int notPick = prev;

            int curr = Math.max(pick, notPick);
            prev2=prev;
            prev=curr;
        }
        
        return prev;
    }

    // public int rob(int[] nums) {
    //     int[] memo = new int[nums.length];
    //     memo[0]=nums[0];

    //     for(int i=1; i<nums.length; i++){
    //         int pick = nums[i];
    //         if(i>1) pick+=memo[i-2];

    //         int notPick = memo[i-1];

    //         memo[i] = Math.max(pick, notPick);
    //     }
        
    //     return memo[nums.length-1];
    // }

    // public int rob(int[] nums) {
    //     int[] memo = new int[nums.length];
    //     // Arrays.fill(memo, -1);
    //     // return helper(nums.length-1, nums, memo);
    // }

    private int helper(int index, int[] nums, int[] memo){
        if(index==0) return nums[0];
        if(index<=0) return 0;
        if(memo[index]!=-1) return memo[index];

        int pick = nums[index] + helper(index-2, nums, memo);
        int notPick = helper(index-1, nums, memo);

        return memo[index] = Math.max(pick, notPick);
    }
}