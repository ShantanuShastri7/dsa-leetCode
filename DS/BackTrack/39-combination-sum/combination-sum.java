class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Set<List<Integer>> res = new HashSet<>();
        List<Integer> curr = new ArrayList<>();

        helper(candidates, 0, res, curr, 0, target);

        return new ArrayList<>(res);
    }

    private void helper(int[] nums, int index, Set<List<Integer>> res, List<Integer> curr, int sum, int target){
        if(index==nums.length || sum>=target){
            if(sum==target){
                res.add(new ArrayList<>(curr));
            }
            return;
        }

        curr.add(nums[index]);
        helper(nums, index, res, curr, sum+nums[index], target);
        helper(nums, index+1, res, curr, sum+nums[index], target);

        curr.remove(curr.size()-1);

        helper(nums, index+1, res, curr, sum, target);
        return;
    }
}