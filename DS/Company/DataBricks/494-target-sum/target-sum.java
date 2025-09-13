class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        if(nums.length==0) return 0;
        if(Arrays.stream(nums).sum()<target) return 0;

        Map<String, Integer> map = new HashMap<>();

        return helper(nums, 0, target, 0, map);
    }

    private int helper(int[] nums, int sum, int target, int index, Map<String, Integer> map){
        if(index==nums.length && sum==target) return 1;
        if(index==nums.length && sum!=target) return 0;

        if(map.containsKey(Integer.toString(index)+":"+Integer.toString(sum))) {
            return map.get(Integer.toString(index)+":"+Integer.toString(sum));
        }
        
        int add = helper(nums, sum+nums[index], target, index+1, map);
        int subtract = helper(nums, sum-nums[index], target, index+1, map);

        map.put(Integer.toString(index)+":"+Integer.toString(sum), add+subtract);

        return add+subtract;
    }
}