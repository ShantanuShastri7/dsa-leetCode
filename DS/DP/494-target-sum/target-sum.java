class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        HashMap<String, Integer> dp = new HashMap<>();
        return helper(nums, target, nums.length - 1, dp);
    }

    private int helper(int[] nums, int target, int index, HashMap<String, Integer> dp) {
        if (index == 0) {
            if (target == 0 && nums[0] == 0)
                return 2;
            if (Math.abs(target) == Math.abs(nums[0]))
                return 1;
            else
                return 0;
        }
        if (dp.containsKey(Integer.toString(index) + ":" + Integer.toString(target)))
            return dp.get(Integer.toString(index) + ":" + Integer.toString(target));
        int addition = helper(nums, target - nums[index], index - 1, dp);
        int substraction = helper(nums, target + nums[index], index - 1, dp);
        dp.put(Integer.toString(index) + ":" + Integer.toString(target), addition + substraction);
        return dp.get(Integer.toString(index) + ":" + Integer.toString(target));
    }
}