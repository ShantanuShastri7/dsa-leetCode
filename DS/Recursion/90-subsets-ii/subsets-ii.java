class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Set<ArrayList<Integer>> res = new HashSet<>();
        ArrayList<Integer> cur = new ArrayList<>();
        Arrays.sort(nums); 
        
        helper(nums, res, 0, cur);
        List<List<Integer>> finalRes = new ArrayList<>();
        Iterator<ArrayList<Integer>> it = res.iterator();

        while (it.hasNext()) {
            finalRes.add(it.next());
        }
        return finalRes;
    }

    private void helper(int[] nums, Set<ArrayList<Integer>> result, int index, ArrayList<Integer> curr) {
        if (index >= nums.length) {
            result.add(new ArrayList<>(curr));
            return;
        }

        helper(nums, result, index + 1, curr);
        curr.add(nums[index]);
        helper(nums, result, index + 1, curr);
        curr.remove(curr.size() - 1);
    }
}