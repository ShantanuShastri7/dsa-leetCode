class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();

        helper(nums, res, curr, nums.length);

        return res;
    }

    private void helper(int[] nums, List<List<Integer>> res, List<Integer> curr, int target) {
        if (curr.size() == target) {
            res.add(new ArrayList<>(curr));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (curr.contains(nums[i]))
                continue; 

            curr.add(nums[i]);
            helper(nums, res, curr, target); 
            curr.remove(curr.size() - 1); 
        }

        return;
    }
}