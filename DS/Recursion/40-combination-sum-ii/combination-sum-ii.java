class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        Set<List<Integer>> res = new HashSet<>();
        backtrack(candidates, target, 0, new ArrayList<>(), res);
        return new ArrayList<>(res);
    }

    private void backtrack(int[] candidates, int target, int index, List<Integer> curr, Set<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(curr));
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            if (candidates[i] > target) break;

            if (i>index && candidates[i-1]==candidates[i]) continue;

            curr.add(candidates[i]);
            backtrack(candidates, target - candidates[i], i + 1, curr, res);
            curr.remove(curr.size() - 1);
        }
    }
}
