class Solution {
    public int rob(int[] nums) {
        if(nums.length==0) return 0;
        if(nums.length==1) return nums[0];

        int[] memo = new int[nums.length+1];
        Arrays.fill(memo, -1);
        int[] memo2 = new int[nums.length+1];
        Arrays.fill(memo2, -1);

        int robFirst = nums[0] + helper(nums, 2, nums.length-2, memo);
        int notRobFirst = helper(nums, 1, nums.length-1, memo2);

        return Math.max(robFirst, notRobFirst);
        
    }

    private int helper(int[] nums, int start, int end, int[] memo){
        if(start>end) return 0;

        if(memo[start]!=-1) return memo[start];

        int rob = nums[start] + helper(nums, start+2, end, memo);
        int notRob = helper(nums, start+1, end, memo);

        return memo[start] = Math.max(rob, notRob);
    }
}