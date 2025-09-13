class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        if(nums.length==0) return 0;
        if(Arrays.stream(nums).sum()<target) return 0;

        return helper(nums, 0, target, 0);
    }

    private int helper(int[] nums, int sum, int target, int index){
        if(index==nums.length && sum==target) return 1;
        if(index==nums.length && sum!=target) return 0;

        int add = helper(nums, sum+nums[index], target, index+1);
        int subtract = helper(nums, sum-nums[index], target, index+1);

        return add+subtract;
    }
}