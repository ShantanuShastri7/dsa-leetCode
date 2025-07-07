class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return helper(nums, target, nums.length-1);
    }

    private int helper(int[] nums, int target, int index){
        if(index==0){
            if(target==0 && nums[0]==0) return 2;
            if(Math.abs(target)==Math.abs(nums[0])) return 1;
            else return 0;
        }

        int addition = helper(nums, target-nums[index], index-1);
        int substraction = helper(nums, target+nums[index], index-1);

        return addition+substraction;
    }
}