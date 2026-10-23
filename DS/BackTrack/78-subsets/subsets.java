class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        ArrayList<Integer> curr = new ArrayList<>();

        helper(nums, 0, curr, res);

        return res;
    }

    private void helper(int[] nums, int index, List<Integer> curr, List<List<Integer>> res){
        if(index==nums.length){
            res.add(new ArrayList<>(curr));
            return;
        }

        curr.add(nums[index]);
        helper(nums, index+1, curr, res);
        curr.remove(curr.size()-1);

        helper(nums, index+1, curr, res);
        return;
    }
}