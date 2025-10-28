class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        backtrack(candidates, target, 0, new ArrayList<>(), res);
        return res;
    }

    private void backtrack(int[] candidates, int target, int index, List<Integer> curr, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(curr));
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            if (candidates[i] > target) break;
            curr.add(candidates[i]);
            backtrack(candidates, target - candidates[i], i, curr, res);
            curr.remove(curr.size() - 1);
        }
    }
}
